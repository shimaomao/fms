package cn.com.leadu.fms.postbiz.validator.overduecondition.validator;

import cn.com.leadu.fms.postbiz.service.OverdueConditionService;
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
@Constraint(validatedBy=OverdueConditionValidator.OverdueConditionValidatorImpl.class)
public @interface OverdueConditionValidator {
    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class OverdueConditionValidatorImpl implements ConstraintValidator<OverdueConditionValidator,String> {

        @Autowired
        private OverdueConditionService overdueConditionService;

        @Override
        public void initialize(OverdueConditionValidator OverdueConditionValidator) {

        }

        @Override
        public boolean isValid(String overdueCondCd, ConstraintValidatorContext constraintValidatorContext) {
            return overdueConditionService.findOverdueConditionByOverdueCondCd(overdueCondCd) == null;
        }

    }
}
