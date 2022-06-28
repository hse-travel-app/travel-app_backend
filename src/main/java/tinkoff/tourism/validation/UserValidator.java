package tinkoff.tourism.validation;

import tinkoff.tourism.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UserValidator implements ConstraintValidator<UserConstraint, User> {

    private final Pattern validName = Pattern.compile("^([a-zA-Zа-яА-Я]{2,}\\s[a-zA-Zа-яА-Я]+'?-?[a-zA-Zа-яА-Я]{2,}\\s?([a-zA-Zа-яА-Я]+)?)");
    // Valid names examples: John Doe, John D'oe or Hector Senior-Jser

    private final Pattern validLogin = Pattern.compile("^[a-zA-Z\\d]([._-](?![._-])|[a-zA-Z\\d]){3,64}[a-zA-Z\\d]$");
    // Login must be 5 characters long, consist of English letters and contain no characters other than . - _

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return user != null && validName.matcher(user.getName()).matches() && validLogin.matcher(user.getLogin()).matches();
    }
}
