package cn.com.leadu.fms.extend.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qiaomengnan
 * @ClassName: AuthUserInfo
 * @Description: 用于获取当前登录的用户
 * @date 2018/1/7
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthUserInfo {
    String value() default "";
}
/*
* controller 中使用
*
* @RequestMapping(value = "/list", method = RequestMethod.POST)
  public ResponseEntity<RestResponse<PageInfo>>
  getActsalUserList(@AuthUserInfo UserInfo userInfo,@Valid @RequestBody ActsalUserListVO actsalUserListVO) {

  }
* */