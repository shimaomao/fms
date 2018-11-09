package cn.com.leadu.fms.postbiz.validator.carcollectcomp.validator;

import cn.com.leadu.fms.postbiz.service.CarCollectCompService;
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
 * Created by 65604 on 2018/5/22.
 */

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CarCollectCompValidator.CarCollectCompValidatorImpl.class)
public @interface CarCollectCompValidator {
    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class CarCollectCompValidatorImpl implements ConstraintValidator<CarCollectCompValidator,String> {

        @Autowired
        private CarCollectCompService carCollectCompService;

        @Override
        public void initialize(CarCollectCompValidator carCollectCompValidator) {

        }

        @Override
        public boolean isValid(String carCollectCompCode, ConstraintValidatorContext constraintValidatorContext) {
            return carCollectCompService.findCarCollectCompByCarCollectCompCode(carCollectCompCode) == null;
        }

    }
}
