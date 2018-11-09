package cn.com.leadu.fms.prebiz.validator.crmperson.validator;

import cn.com.leadu.fms.prebiz.service.CrmPersonService;
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
 * @author ningyangyang
 * @ClassName: CrmPersCertifNoValidator
 * @Description:
 * @date 2018/1/12
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CrmPersCertifNoValidator.CrmPersCertifNoValidatorImpl.class)
public @interface CrmPersCertifNoValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class CrmPersCertifNoValidatorImpl implements ConstraintValidator<CrmPersCertifNoValidator,String> {

        @Autowired
        private CrmPersonService crmPersonService;

        @Override
        public void initialize(CrmPersCertifNoValidator crmPersCertifNoValidator) {

        }

        @Override
        public boolean isValid(String certifNo, ConstraintValidatorContext constraintValidatorContext) {
            return crmPersonService.findCrmPerByCertifNo(certifNo) == null;
        }

    }

}
