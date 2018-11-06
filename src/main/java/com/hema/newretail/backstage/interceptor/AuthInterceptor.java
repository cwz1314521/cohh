package com.hema.newretail.backstage.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hema.newretail.backstage.common.utils.HttpClientUtils;
import com.hema.newretail.backstage.common.utils.RedisUtils;
import com.hema.newretail.backstage.common.utils.SpringUtils;
import com.hema.newretail.backstage.common.utils.ossutil.AliyunOSSClientUtil;
import com.hema.newretail.backstage.entry.BaseUserInfoEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * hema-newRetail-crm-com.hema.newretail.backstage.interceptor
 *
 * @author ZhangHaiSheng
 * @date 2018-09-06 17:57
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private AliyunOSSClientUtil aliyunOSSClientUtil;

    @Value("${auth.requestCodeUrl}")
    private String requestCodeUrl;
    @Value("${auth.requestAccessCodeUrl}")
    private String requestAccessCodeUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("--------------------------------crm interceptor----------------------------");
        logger.info("request请求地址url[{}] uri[{}] servletPath[{}]", request.getRequestURL(), request.getRequestURI(), request.getServletPath());
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return false;
        }
        String contentType = request.getHeader("content-type");
        if (null != contentType && contentType.contains("multipart/form-data")) {
            return true;
        }
        String sessionId = request.getSession().getId();
        logger.info("interceptor sessionId:" + sessionId);
        // 1是否有session? 有：放行；没有：判断是否有code
        // 2是否有code? 有：请求token；没有：返回前端，请求code
        RedisUtils redisUtils = (RedisUtils) SpringUtils.getApplicationContext().getBean("redisUtils");
        boolean isSessionNull = !redisUtils.hexists(AuthConstants.SESSION + sessionId, AuthConstants.REDIS_DB_INDEX);
        if (isSessionNull) {
            // 判断是否有code
            // 有：请求token；没有：返回前端，请求code
            String code = request.getParameter(AuthConstants.CODE);
            if (StringUtils.isEmpty(code)) {
                // 请求code
                logger.info("请求code");
                response.setHeader("code_url", requestCodeUrl);
                response.setHeader("code_error_code", "302");
                response.setHeader("Access-Control-Expose-Headers", "code_url,code_error_code");
                return false;
            } else {
                // 请求token,发起http请求
                String redirectUri = request.getParameter("redirectUri");
                if (StringUtils.isEmpty(redirectUri)) {
                    return false;
                }
                JSONObject jsonObject = requestAccessTokenFromAuthServer(request, code, redirectUri);
                // 保存session和access_token
                if (null == jsonObject) {
                    return false;
                }
                logger.info(jsonObject.toJSONString());
                boolean success = saveSessionAndToken(jsonObject, redisUtils, sessionId);
                if (success) {
                    logger.info("获取token成功的redirectUri:" + redirectUri);
                    response.setHeader("redirect_uri", redirectUri);
                    response.setHeader("code_error_code", "303");
                    String userinfoJson = redisUtils.hget(AuthConstants.SESSION + sessionId, AuthConstants.USER_INFO, AuthConstants.REDIS_DB_INDEX);
                    response.setHeader("userinfoJson", userinfoJson);
                    response.setHeader("Access-Control-Expose-Headers", "redirect_uri,code_error_code,userinfoJson");
                    logger.info("userinfoJson:" + userinfoJson);
                    return false;
                }
            }
        } else {
            // 权限校验
            String authJson = getAuthJson(redisUtils, sessionId);
            if (StringUtils.isEmpty(authJson)) {
                logger.info("authJson is null");
                logger.info("权限校验未通过");
                return false;
            }
            JSONArray array = JSONArray.parseArray(authJson);
            if (null == array || array.size() < 1) {
                return false;
            }
            for (Object anArray : array) {
                JSONObject json = (JSONObject) anArray;
                String apis = json.getString("apis");
//                logger.info("apis:" + apis);
                if (!StringUtils.isEmpty(apis) && apis.contains(request.getServletPath())) {
                    logger.info("权限校验通过");
                    return true;
                }
            }
            logger.info("权限校验未通过");
            return false;
        }
        return false;
    }

    /**
     * 从认证服务器请求token
     *
     * @param request     request
     * @param code        code
     * @param redirectUri redirectUri
     * @return 返回数据
     */
    private JSONObject requestAccessTokenFromAuthServer(HttpServletRequest request, String code, String redirectUri) {
        logger.info("请求token");
        String state = request.getParameter("state");
        String strParam = "code=" + code;
        strParam += "&redirectUri=" + redirectUri;
        strParam += "&state=" + (StringUtils.isEmpty(state) ? "" : state);
        return HttpClientUtils.httpPost(requestAccessCodeUrl, strParam);
    }

    /**
     * 保存session和token
     *
     * @param jsonObject jsonObject
     * @param redisUtils redisUtils
     * @param sessionId  sessionId
     * @return 是否保存成功 true 成功 false 失败
     */
    private boolean saveSessionAndToken(JSONObject jsonObject, RedisUtils redisUtils, String sessionId) {
        boolean success = (boolean) jsonObject.get("success");
        if (success) {
            JSONObject info = (JSONObject) jsonObject.get("info");
            String accessToken = (String) info.get("access_token");
            String userInfoJson = (String) info.get(AuthConstants.USER_INFO);
            if (!StringUtils.isEmpty(accessToken)) {
                // 设置session
                Map<String, String> sessionMap = new HashMap<>(1);
                sessionMap.put(AuthConstants.ACCESS_TOKEN_ID, accessToken);
                sessionMap.put(AuthConstants.USER_INFO, userInfoJson);
                redisUtils.hmset(AuthConstants.SESSION + sessionId, sessionMap, AuthConstants.REDIS_DB_INDEX);
                // 设置session过期时间
                redisUtils.expire(AuthConstants.SESSION + sessionId, AuthConstants.SESSION_EXPIRED_DATE);

                // 设置access_token
                Map<String, String> tokenMap = new HashMap<>(1);
                tokenMap.put(AuthConstants.SESSION_ID, sessionId);
                redisUtils.hmset(AuthConstants.ACCESS_TOKEN + accessToken, tokenMap, AuthConstants.REDIS_DB_INDEX);
                // 设置access_token的过期时间
                redisUtils.expire(AuthConstants.ACCESS_TOKEN + accessToken, AuthConstants.ACCESS_TOKEN_EXPIRED_DATE);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取当前用户的权限json数据
     *
     * @param redisUtils RedisUtils对象
     * @param sessionId  sessionId
     * @return 权限json数据
     */
    private String getAuthJson(RedisUtils redisUtils, String sessionId) {
        String str = "";
        try {
            String userInfoJson = redisUtils.hget(AuthConstants.SESSION + sessionId, AuthConstants.USER_INFO, AuthConstants.REDIS_DB_INDEX);
            if (StringUtils.isEmpty(userInfoJson)) {
                return null;
            }
            BaseUserInfoEntry userInfo = JSON.parseObject(userInfoJson, BaseUserInfoEntry.class);
            if (null == userInfo || null == userInfo.getPostId()) {
                return null;
            }
            String fileName = userInfo.getPostId() + ".json";
            logger.info("auth_postId fileName:" + fileName);
            str = aliyunOSSClientUtil.readStreamFileOfJson(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return str;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
