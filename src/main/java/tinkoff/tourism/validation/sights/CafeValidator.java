package tinkoff.tourism.validation.sights;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tinkoff.tourism.model.sights.Cafe;


public class CafeValidator implements ConstraintValidator<CafeConstraint, Cafe> {

    @Override
    public boolean isValid(Cafe cafe, ConstraintValidatorContext constraintValidatorContext) {
        return cafe != null &&
                cafe.getFoodType() != null && !cafe.getFoodType().isBlank();
    }
}
