package com.br.controleLoja.validation.constraints;

import com.br.controleLoja.validation.ExemploValidacaoValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExemploValidacaoValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExemploValidacao {

    String message() default "Validação inválida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
