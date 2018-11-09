package cn.com.leadu.fms.baseinfo.validator.basfiletype.validator;

import cn.com.leadu.fms.baseinfo.service.BasFileTypeService;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeSaveVo;
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
@Constraint(validatedBy=BasFileTypeValidator.BasFileTypeValidatorImpl.class)
public @interface BasFileTypeValidator {

    String value() default "";

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class BasFileTypeValidatorImpl implements ConstraintValidator<BasFileTypeValidator,String> {

        @Autowired
        private BasFileTypeService basFileTypeService;

        @Override
        public void initialize(BasFileTypeValidator basFileTypeValidator) {

        }

        @Override
        public boolean isValid(String fileType, ConstraintValidatorContext constraintValidatorContext) {
            return basFileTypeService.findBasFileTypeByFileType(fileType) == null;
        }

    }
}


