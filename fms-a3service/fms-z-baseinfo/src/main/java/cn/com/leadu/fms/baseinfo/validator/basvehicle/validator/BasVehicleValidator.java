package cn.com.leadu.fms.baseinfo.validator.basvehicle.validator;

import cn.com.leadu.fms.baseinfo.service.BasVehicleService;
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
 * @ClassName: BasVehicleValidator
 * @Description:
 * @date 2018/4/3.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= BasVehicleValidator.BasVehicleValidatorImpl.class)
public @interface BasVehicleValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class BasVehicleValidatorImpl implements ConstraintValidator<BasVehicleValidator,String> {

        @Autowired
        private BasVehicleService basVehicleService;

        @Override
        public void initialize(BasVehicleValidator basVehicleValidator) {

        }

        @Override
        public boolean isValid(String vehicleCode, ConstraintValidatorContext constraintValidatorContext) {
            return basVehicleService.findBasVehicleByVehicleCode(vehicleCode) == null;
        }

    }
}
