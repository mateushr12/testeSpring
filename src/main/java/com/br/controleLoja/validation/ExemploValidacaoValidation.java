package com.br.controleLoja.validation;

import com.br.controleLoja.validation.constraints.ExemploValidacao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExemploValidacaoValidation implements ConstraintValidator<ExemploValidacao, String> {

    @Override
    public void initialize(ExemploValidacao constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !s.isEmpty();
    }
}
