package com.bsm.exception;

public enum CustomizeCode implements IcustomizeErrorCode {

    //系统相关
    INTERNAL_ERROR(1001, "内部系统错误"),

    QUESTION_NOT_FOUND(2001, "更新失败，数据库不存在"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "当前操作需要登录,请先登录"),
    SYS_ERROE(2004, "服务冒烟了，稍后重试"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008, "用户信息不一致"),
    NOTIFICATION_NOT_FAIL(2009, "没有该信息"),
    CAPTCHA_CHECK_FAIL(2010, "验证码不正确"),

    //用户名相关
    USER_PASSWROD_LOGIN_ERROR(3000, "用户名或者密码错误"),
    USER_REGISTER_ERROR(3000, "用户注册失败"),

    //保存结果
    SAVE_FAIL(5000, "保存失败"),

    //参数相关
    PARAME_ERROR(6000, "参数错误"),
    UPLOAD_PARAME_EMPTY(6001, "不能上传空文件"),

    //查询结果
    SEARCH_RESULT_NOT_FOUND(7001, "查无此记录"),

    //上传相关
    UPLOAD_FILE_FAIL(8001, "上传文件失败"),
    ;




    private String message;
    private Integer code;

    CustomizeCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }
}
