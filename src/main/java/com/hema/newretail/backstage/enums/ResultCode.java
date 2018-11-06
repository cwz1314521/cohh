package com.hema.newretail.backstage.enums;

/**
 * @author zhs
 */
public enum ResultCode {

    //项目：01 hema-newetaril
    //功能：001 订单,002 支付,003 制作, 004 标准饮品
    //模块：001 微信小程序,002 运营后台
    //分类：001 常规错误,002校验错误
    //具体：xxxx

    //失败
    FAIL("01001001001001", "操作失败"),
    FAIL_VALIDATOR("01001001001002", "参数校验错误"),
    //未认证（签名错误）
    UNAUTHORIZED("01001001001401", "无登录信息"),
    //没有相关的操作权限
    UNACCESSED("01001001001403", "无操作权限"),
    //接口不存在
    NOT_FOUND("01001001001404", "接口不存在"),
    //服务器内部错误
    INTERNAL_SERVER_ERROR("01001001001500", "服务器错误"),

    VALIDATION_ERROR_PARAM_CODE_EMPTY("010010010020001", "参数为空"),
    VALIDATION_ERROR_PARAM_VERIFYCODE_EMPTY("010010010020002", "参数[verifycode]为空"),
    VALIDATION_ERROR_PARAM_VERIFYCODE_ERROR("010010010020003", "输入的验证码不正确"),
    VALIDATION_ERROR_PARAM_OUTTRADENO_EMPTY("010010020020001", "参数[outTradeNo]获取失败"),
    VALIDATION_ERROR_PARAM_ORDER_GEN_ERROR("010010020020002", "订单生成失败"),
    VALIDATION_ERROR_PARAM_ALIPAY_RETURN_QUERY_ERROR("010010020020003", "查询失败"),
    VALIDATION_ERROR_PARAM_ALIPAY_REFUND_ERROR("010010020020004", "退款失败"),
    VALIDATION_ERROR_OBJECT_ISNULL("010010010020005", "对象为空"),
    VALIDATION_ERROR_NOT_MACHINE_CONNECT("010010030010001", "无该机器连接"),
    VALIDATION_ERROR_PARAM_CUP_GREATER_ONE("010010030010002", "杯数必须大于1"),
    VALIDATION_ERROR_PARAM_CUP_NUM_INVALID("010010030010003", "杯数与id不符"),
    VALIDATION_ERROR_MAKE_COMMAND_ISNULL("010010030010004", "制作指令为空"),
    /**********************************************************
     * 运营后台
     *********************************************************/
    VALIDATION_ERROR_PARAM_EMPTY("010020010020001", "参数为空"),

    VALIDATION_ERROR_MENU_NAME_NOT_NULL("010040020020001", "饮品名称已存在"),
    VALIDATION_ERROR_DATA_EXIST("010040020020002", "记录已存在"),


    ERROE_IMAGE_INFO("999", "请上传正确比例图片");

    /**
     * 项目，模块，功能，分类，具体编码
     */
    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
