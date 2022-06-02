package tinkoff.tourism.validation.sights;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tinkoff.tourism.model.sights.Bar;


public class BarValidator implements ConstraintValidator<BarConstraint, Bar> {

    @Override
    public boolean isValid(Bar bar, ConstraintValidatorContext constraintValidatorContext) {
        return bar != null && bar.getForAdults() != null;
    }
}
