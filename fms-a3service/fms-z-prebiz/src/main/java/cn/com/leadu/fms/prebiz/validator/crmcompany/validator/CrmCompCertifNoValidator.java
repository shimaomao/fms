package cn.com.leadu.fms.prebiz.validator.crmcompany.validator;

import cn.com.leadu.fms.prebiz.service.CrmCompanyService;
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
 * @ClassName: CrmCompCertifNoValidator
 * @Description:
 * @date 2018/1/12
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CrmCompCertifNoValidator.CrmCompCertifNoValidatorImpl.class)
public @interface CrmCompCertifNoValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class CrmCompCertifNoValidatorImpl implements ConstraintValidator<CrmCompCertifNoValidator,String> {

        @Autowired
        private CrmCompanyService crmCompanyService;

        @Override
        public void initialize(CrmCompCertifNoValidator crmCompCertifNoValidator) {

        }

        @Override
        public boolean isValid(String socialCertifNo, ConstraintValidatorContext constraintValidatorContext) {
            return crmCompanyService.findCrmCompByCertifNo(socialCertifNo) == null;
        }

    }

}
