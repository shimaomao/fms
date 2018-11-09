/*
 * Project Name : fb-microservice-biz
 * File Name : ResponseFailEnum.java
 * Date : 17-10-30 上午10:58
 * Author : qiaohao
 * Copyright (c) 2017, Feng Bang Leasing(Shang Hai)Co.,Ltd. All Rights Re
 * served.
 */

package cn.com.leadu.fms.extend.response;

/**
 * @ClassName: ResponseEnum
 * @Description: 响应状态枚举
 * @author qiaohao
 * @date 2017/10/30
 */
public enum ResponseFailEnums implements ResponseType{

    OAUTH2_ERROR("00010000","oauth2_error","oauth2鉴权异常"),
    TOKEN_INVALID("00010001","token_invalid","无效的token"),
    RESOURCE_ACCESS_ERROR("00020000","resource_access_error","资源访问异常"),
    PARAM_CHECK_ERROR("00030000","param_check_error","参数校验异常"),
    BIZ_CHECK_ERROR("00040000","biz_check_error","业务校验异常"),
    SYS_EXCEPTION_ERROR("00050000","sys_exception","系统异常"),
    VERIFYCODE_ERROR("00090801","verify_code_senderror","验证码发送异常"),
    SERVER_ERROR("00080001","server_init","服务器状态异常"),
    FILE_UPLOAD_ERROR("0009001","file_upload_error","文件上传异常")
    ;


    ResponseFailEnums(String code, String mark, String message) {
        this.code = code;
        this.message = message;
        this.mark = mark;
    }

    private String code;

    private String message;

    private String mark;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getMark(){return mark;}
}
