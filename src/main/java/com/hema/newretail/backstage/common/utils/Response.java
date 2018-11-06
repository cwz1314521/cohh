package com.hema.newretail.backstage.common.utils;

import com.hema.newretail.backstage.enums.ResultCode;
import io.swagger.annotations.Api;

import java.util.HashMap;
import java.util.Map;

public class Response {

    private Boolean success;
    private Object msg;
    private Object info;
    private String errorCode;

    public static Response success() {
        return success(null);
    }

    public static Response success(Object data) {
        return success(data, 0L, 0, 0);
    }
    public static Response failure(String message) {
        Response response = new Response();
        response.setSuccess(false);
        response.setMsg(message);
        response.setErrorCode("505");
        return response;
    }

    public static Response success(Object data, Long totalCount, Integer pageSize, Integer pageNum) {
        Response response = new Response();
        response.setSuccess(true);
        response.setMsg("操作成功");
        /*分页条件显示*/
        if (null != totalCount && totalCount > 0) {
            Map<String, Object> info = new HashMap<>(4);
            info.put("totalCount", totalCount);
            info.put("listItems", data);
            info.put("pageSize", pageSize);
            info.put("pageNum", pageNum);
            response.setInfo(info);
        } else { // 不分页
            response.setInfo(data);
        }
        return response;
    }

    public static Response failure() {
        return failure(ResultCode.FAIL);
    }

    public static Response failure(ResultCode code) {
        Response response = new Response();
        response.setSuccess(false);
        response.setMsg(code.getMessage());
        response.setErrorCode(code.getCode());
        return response;
    }

    public static Response failureValid(Object msgObj) {
        Response response = new Response();
        response.setSuccess(false);
        response.setInfo(msgObj);
        response.setMsg(ResultCode.FAIL_VALIDATOR.getMessage());
        response.setErrorCode(ResultCode.FAIL_VALIDATOR.getCode());
        return response;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
