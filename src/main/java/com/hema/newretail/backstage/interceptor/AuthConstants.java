package com.hema.newretail.backstage.interceptor;

/**
 * unified-auth-com.hema.unified.auth.common
 *
 * @author ZhangHaiSheng
 * @date 2018-09-06 15:07
 */
public class AuthConstants {

    /**
     * redis数据库序号
     * <p>
     * 运营库
     */
    public static final int REDIS_DB_INDEX = 15;

    /**
     * access_token的有效时间，单位秒
     */
    public static final int ACCESS_TOKEN_EXPIRED_DATE = 200 * 60;
    /**
     * session的有效时间，单位秒，与认证服务的access_token的有效期保持一致
     */
    public static final int SESSION_EXPIRED_DATE = 200 * 60;
    /**
     * refresh_access_token的有效时间，单位秒
     */
    public static final int REFRESH_ACCESS_TOKEN_EXPIRED_DATE = 365 * 24 * 60 * 60;

    public static final String SESSION = "session:";
    public static final String SESSION_ID = "session_id";
    public static final String ACCESS_TOKEN = "access_token:";
    public static final String ACCESS_TOKEN_ID = "access_token";
    public static final String USER_INFO = "userinfo";
    public static final String ACCESS_TOKEN_EXPIRE_IN = "access_token_expire_in";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String REFRESH_TOKEN_EXPIRE_IN = "refresh_token_expire_in";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String CODE = "code";
    public static final String GRANT_TYPE = "grant_type";
    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
    public static final String SCOPE = "scope";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer";
    public static final String BASIC = "Basic";
    public static final String JSON_CONTENT = "application/json";
    public static final String XML_CONTENT = "application/xml";
    public static final String URL_ENCODED_CONTENT = "application/x-www-form-urlencoded";

    public static final int HTTP_OK = 200;
}
