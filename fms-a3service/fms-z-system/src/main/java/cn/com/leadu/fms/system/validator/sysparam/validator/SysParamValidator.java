package cn.com.leadu.fms.system.validator.sysparam.validator;

import cn.com.leadu.fms.system.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=SysParamValidator.SysParamValidatorImpl.class)
public @interface SysParamValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysParamValidatorImpl implements ConstraintValidator<SysParamValidator,String> {

        @Autowired
        private SysParamService sysParamService;

        @Override
        public void initialize(SysParamValidator sysParamValidator) {

        }

        @Override
        public boolean isValid(String paramKey, ConstraintValidatorContext constraintValidatorContext) {
            return sysParamService.findSysParamByParamKey(paramKey) == null;
        }

    }
}

