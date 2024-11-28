package com.star.anno;


import com.star.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StateValidation.class})

public @interface State{
    String message() default "state参数只能为已发布或草稿";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
