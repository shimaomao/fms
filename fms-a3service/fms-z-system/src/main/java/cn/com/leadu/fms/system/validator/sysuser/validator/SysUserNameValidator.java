package cn.com.leadu.fms.system.validator.sysuser.validator;

import cn.com.leadu.fms.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qiaomengnan
 * @ClassName: SysUserNameValidator
 * @Description:
 * @date 2018/1/12
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SysUserNameValidator.SysUserNameValidatorImpl.class)
public @interface SysUserNameValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysUserNameValidatorImpl implements ConstraintValidator<SysUserNameValidator,String> {

        @Autowired
        private SysUserService sysUserService;

        @Override
        public void initialize(SysUserNameValidator sysUserNameValidator) {

        }

        @Override
        public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
            return sysUserService.findSysUserByUsername(username) == null;
        }

    }

}
