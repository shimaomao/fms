package cn.com.leadu.fms.system.validator.sysgroup.validator;

import cn.com.leadu.fms.system.service.SysGroupService;
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
 * @ClassName: SysGroupValidator
 * @Description:
 * @date 2018/3/12.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SysGroupValidator.SysGroupValidatorImpl.class)
public @interface SysGroupValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysGroupValidatorImpl implements ConstraintValidator<SysGroupValidator,String> {

        @Autowired
        private SysGroupService sysGroupService;

        @Override
        public void initialize(SysGroupValidator sysGroupValidator) {

        }

        @Override
        public boolean isValid(String groupCode, ConstraintValidatorContext constraintValidatorContext) {
            return sysGroupService.findSysGroupByGroup(groupCode) == null;
        }

    }
}
