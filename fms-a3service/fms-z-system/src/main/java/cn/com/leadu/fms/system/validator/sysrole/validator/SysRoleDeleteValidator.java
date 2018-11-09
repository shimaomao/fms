package cn.com.leadu.fms.system.validator.sysrole.validator;

import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleDeleteValidator
 * @Description:
 * @date 2018/1/22
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SysRoleDeleteValidator.SysRoleDeleteValidatorImpl.class)
public @interface SysRoleDeleteValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysRoleDeleteValidatorImpl implements ConstraintValidator<SysRoleDeleteValidator,List<String>> {

        @Override
        public void initialize(SysRoleDeleteValidator sysRoleDeleteValidator) {

        }

        @Override
        public boolean isValid(List<String> s, ConstraintValidatorContext constraintValidatorContext) {
            return !s.contains(SysRoleEnums.ADMIN.getId());
        }
    }


}
