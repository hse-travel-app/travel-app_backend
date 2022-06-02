package tinkoff.tourism.validation.sights;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import tinkoff.tourism.model.sights.Street;


public class StreetValidator implements ConstraintValidator<StreetConstraint, Street> {

    @Override
    public boolean isValid(Street street, ConstraintValidatorContext constraintValidatorContext) {
        return street != null &&
                street.getHistory() != null && !street.getHistory().isBlank();
    }
}
