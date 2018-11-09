package cn.com.leadu.fms.system.validator.sysrole.validator;

import cn.com.leadu.fms.system.service.SysRoleService;
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
 * @ClassName: SysRoleDeleteValidator
 * @Description:
 * @date 2018/1/22
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= SysRoleSaveValidator.SysRoleSaveValidatorImpl.class)
public @interface SysRoleSaveValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysRoleSaveValidatorImpl implements ConstraintValidator<SysRoleSaveValidator,String> {

        @Autowired
        private SysRoleService sysRoleService;
        @Override
        public void initialize(SysRoleSaveValidator SysRoleSaveValidator) {

        }

        @Override
        public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
            return sysRoleService.findSysRoleByRole(username) == null;
        }


    }


}
