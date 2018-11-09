package cn.com.leadu.fms.system.validator.sysgrouplevel.validator;

import cn.com.leadu.fms.system.service.SysGroupLevelService;
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
 * @author wangxue
 * @ClassName: SysGroupLevelValidator
 * @Description:
 * @date 2018/3/8
 */

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SysGroupLevelValidator.SysGroupLevelValidatorImpl.class)
public @interface SysGroupLevelValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysGroupLevelValidatorImpl implements ConstraintValidator<SysGroupLevelValidator,String> {

        @Autowired
        private SysGroupLevelService sysGroupLevelService;

        @Override
        public void initialize(SysGroupLevelValidator sysUserNameValidator) {

        }

        @Override
        public boolean isValid(String groupLev, ConstraintValidatorContext constraintValidatorContext) {
            return sysGroupLevelService.findSysGroupLevelByGroupLev(groupLev) == null;
        }

    }
}
