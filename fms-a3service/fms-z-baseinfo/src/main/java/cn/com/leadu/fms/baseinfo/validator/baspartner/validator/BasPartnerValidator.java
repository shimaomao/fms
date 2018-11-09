package cn.com.leadu.fms.baseinfo.validator.baspartner.validator;

import cn.com.leadu.fms.baseinfo.service.BasPartnerService;
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
@Constraint(validatedBy=BasPartnerValidator.BasPartnerValidatorImpl.class)
public @interface BasPartnerValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class BasPartnerValidatorImpl implements ConstraintValidator<BasPartnerValidator,String> {

        @Autowired
        private BasPartnerService basPartnerService;

        @Override
        public void initialize(BasPartnerValidator basPartnerValidator) {

        }

        @Override
        public boolean isValid(String partnerCode, ConstraintValidatorContext constraintValidatorContext) {
            return basPartnerService.findBasPartnerByPartnerCode(partnerCode) == null;
        }

    }
}
