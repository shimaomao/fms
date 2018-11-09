package cn.com.leadu.fms.system.validator.syscodetype.validator;

import cn.com.leadu.fms.system.service.SysCodeTypeService;
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
 * @author huchenghao
 * @ClassName: SysGroupValidator
 * @Description:
 * @date 2018/4/3.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= SysCodeTypeValidator.SysCodeTypeValidatorImpl.class)
public @interface SysCodeTypeValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class SysCodeTypeValidatorImpl implements ConstraintValidator<SysCodeTypeValidator,String> {

        @Autowired
        private SysCodeTypeService sysCodeTypeService;

        @Override
        public void initialize(SysCodeTypeValidator sysCodeTypeValidator) {

        }

        @Override
        public boolean isValid(String codeType, ConstraintValidatorContext constraintValidatorContext) {
            return sysCodeTypeService.findSysCodeTypeByCodeType(codeType) == null;
        }

    }
}
