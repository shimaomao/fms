package cn.com.leadu.fms.oauth2.common.constant.enums;

/**
 * Created by qiaohao on 2017/11/16.
 */
public enum Oauth2RedisKeyEnums {

    FMS_OAUTH2_USER_REGISTER_MESSAGE("fms:oauth2:user_register_message:","用户短信redis前缀"),
    FMS_OAUTH2_USER_REGISTER_CODE("fms:oauth2:user_register_code:","用户登录验证码前缀");

    private String prefix;

    private String desc;

    Oauth2RedisKeyEnums(String prefix, String desc) {
        this.prefix = prefix;
        this.desc = desc;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDesc(){
        return this.desc;
    }

}
