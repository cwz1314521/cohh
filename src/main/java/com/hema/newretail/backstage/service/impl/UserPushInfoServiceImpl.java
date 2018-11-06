package com.hema.newretail.backstage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hema.newretail.backstage.common.mongodbpage.MongoDBPageModel;
import com.hema.newretail.backstage.common.mongodbpage.SpringbootMongoDBPageable;
import com.hema.newretail.backstage.common.utils.Response;
import com.hema.newretail.backstage.common.utils.TimeUtil;
import com.hema.newretail.backstage.entry.PushInfoData;
import com.hema.newretail.backstage.entry.UserFormIdData;
import com.hema.newretail.backstage.entry.UserManagerData;
import com.hema.newretail.backstage.service.IUserPushInfoService;
import com.mongodb.WriteResult;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * 推送信息接口Service实现类
 */
@Service("userPushInfoService")
public class UserPushInfoServiceImpl implements IUserPushInfoService {

    private static final Integer TWOHUNDRED = 200;
    private static final String ACCESSTOKEN = "access_token";
    private static final String TEMPLATEIDOVER="40037";
    private static final String FORMIDOVER="41028";
    private static final String FORMIDUSED="41029";
    private static  final String PAGESTATUS="41030";
    private static final String OVERMAX="45009";
    private static final String COLLECTION="userFormIdData";

    private Logger logger = LoggerFactory.getLogger(UserPushInfoServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Value(value = "${weixin.appId}")
    private String appId;
    @Value(value = "${weixin.appSecret}")
    private String appSecret;
    @Value(value = "${weixin.templateId}")
    private String templateId;

    /**
     *查询推送信息列表
     * @param params{pageNum:int,pageSize:int}都是必填项
     * @return
     */
    @Override
    public Response findAll(Map<String, Object> params) {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();

        //Todo 获取登录用户的信息
        String admin = "admin";
        SpringbootMongoDBPageable pageable = new SpringbootMongoDBPageable();
        MongoDBPageModel pm=new MongoDBPageModel();

        int pageSize = (int)params.get("pageSize");
        int pageNum = (int)params.get("pageNum");

        pm.setPagenumber(pageNum);
        pm.setPagesize(pageSize);

        Sort sort = new Sort(Sort.Direction.DESC,"pushTime");
        pm.setSort(sort);

        pageable.setPage(pm);

        Criteria criteria = Criteria.where("operator").is(admin);
        Query query = Query.query(criteria);
        long total = mongoTemplate.count(query, PushInfoData.class,"pushInfoData");
        List<PushInfoData> datas = mongoTemplate.find(query.with(pageable),PushInfoData.class,"pushInfoData");
        for (PushInfoData data:datas){
            Map<String,Object> pushInfo = new HashMap<String, Object>();
            pushInfo.put("id",data.getId());
            pushInfo.put("content",data.getContent());
            pushInfo.put("operator",data.getOperator());
            pushInfo.put("pushTimeStr", TimeUtil.getStringByDate(data.getPushTime()));
            pushInfo.put("title",data.getTitle());
            List<String> users = data.getUsers();
            List<Map<String,Object>> userList = new ArrayList<Map<String, Object>>();
            for (String user:users){
                Map<String,Object> userMap = new HashMap<String, Object>();
                UserManagerData userManagerData= mongoTemplate.findById(user,UserManagerData.class,"userManagementData");
                if(userManagerData != null){
                    userMap.put("nickName",userManagerData.getNickname());
                    userMap.put("telephone",userManagerData.getPhoneNumber());
                }
                userList.add(userMap);
            }
            pushInfo.put("users",userList);
            result.add(pushInfo);
        }

        return Response.success(result,total,pageSize,pageNum);
    }

    /**
     * 根据id获取推送信息详情
     * @param id
     * @return
     */
    @Override
    public PushInfoData findOne(String id) {
        return mongoTemplate.findById(id,PushInfoData.class,"pushInfoData");
    }

    /**
     * 保存推送信息
     * @param data
     */
    @Override
    public void save(PushInfoData data) {
        mongoTemplate.insert(data,"pushInfoData");
    }

    /**
     * 保存用户FormId
     * @param data
     */
    @Override
    public void saveFormId(UserFormIdData data) {
        mongoTemplate.insert(data,"userFormIdData");
    }

    /**
     *根据用户openId查询用户FormId
     * @param openId
     * @return
     */
    @Override
    public UserFormIdData findOneByOpenId(String openId) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_WEEK,-7);
        Date beginTime = c.getTime();
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC,"createTime"));

        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("openId").is(openId),Criteria.where("createTime").gte(beginTime).lte(date));
        Query query = new Query(criteria);
        query.with(sort).limit(1);
        List<UserFormIdData> datas = mongoTemplate.find(query, UserFormIdData.class,"userFormIdData");
        if(datas.size()>0){
            return datas.get(0);
        }else{
            return null;
        }
    }

    /**
     * 获取微信认证信息AccessToken
     * @return
     */
    @Override
    public String getAccessToken() {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        System.out.println("appId:"+appId);
        System.out.println("appSecret:"+appSecret);
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+appSecret;
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == TWOHUNDRED) {
                String entity = EntityUtils.toString(httpResponse.getEntity());
                JSONObject jsonObject = JSONObject.parseObject(entity);
                if (jsonObject.get(ACCESSTOKEN)!=null){
                    result = jsonObject.getString("access_token");
                }else {
                    result = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 推送信息接口
     * @param touser
     * @param formId
     * @param fillData
     * @return
     */
    @Override
    public String sendTemplate(String touser, String formId, String[] fillData) {
        String tepUrl = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="
                + this.getAccessToken();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(tepUrl);
        // 装配post请求参数
        JSONObject json = new JSONObject();
        json.put("touser", touser);
        json.put("template_id", templateId);
        json.put("form_id", formId);
//        json.put("emphasis_keyword", "keyword1.DATA");
        JSONObject dataJson = new JSONObject();
        for (int i = 0; i < fillData.length; i++) {
            JSONObject sonDateJson = new JSONObject();
            sonDateJson.put("value", fillData[i]);
            dataJson.put("keyword" + (i + 1), sonDateJson);
        }
        json.put("data", dataJson);
        String resultStr = "发送失败";
        try {
            StringEntity myEntity = new StringEntity(json.toJSONString(), ContentType.APPLICATION_JSON);

            // 设置post求情参数
            httpPost.setEntity(myEntity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == TWOHUNDRED) {
                deleteFormIdData(formId);
                // 发送成功
                String resutlEntity = EntityUtils.toString(httpResponse.getEntity());

                JSONObject resultTemplateDate = JSONObject.parseObject(resutlEntity);
                if (resultTemplateDate.get(TEMPLATEIDOVER)!=null) {
                    resultStr = "template_id不正确";
                }
                if (resultTemplateDate.get(FORMIDOVER)!=null) {
                    resultStr = "form_id不正确，或者过期";
                }
                if (resultTemplateDate.get(FORMIDUSED)!=null) {
                    resultStr = "form_id已被使用";
                }
                if (resultTemplateDate.get(PAGESTATUS)!=null) {
                    resultStr = "page不正确";
                }
                if (resultTemplateDate.get(OVERMAX)!=null) {
                    resultStr = "接口调用超过限额（目前默认每个帐号日调用限额为100万）";
                }
                resultStr = "ok";
                return resultStr;
            } else {
                // 发送失败
                return resultStr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    // 释放资源
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultStr;
    }

    @Override
    public void deleteFormIdData(String formId) {
        Criteria criteria = Criteria.where("formId").in(formId);
        if (criteria != null) {
            Query query = new Query(criteria);
            if (query != null && mongoTemplate.findOne(query, UserFormIdData.class,COLLECTION) != null){
                WriteResult result = mongoTemplate.remove(mongoTemplate.findOne(query, UserFormIdData.class,"userFormIdData"));
                logger.info(formId+"删除formId的结果是"+result.getN());
            }
        }
    }
}
