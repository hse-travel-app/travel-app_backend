package tinkoff.tourism.validation.sights;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tinkoff.tourism.model.sights.Museum;


public class MuseumValidator implements ConstraintValidator<MuseumConstraint, Museum> {

    @Override
    public boolean isValid(Museum museum, ConstraintValidatorContext constraintValidatorContext) {
        return museum != null && museum.getDiscountForChildren() != null;
    }
}
