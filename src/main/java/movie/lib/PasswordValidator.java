package movie.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import movie.dto.request.UserRequestDto;

public class PasswordValidator implements ConstraintValidator<ValidPassword, UserRequestDto> {
    private static final int PASSWORD_MIN_LENGTH = 4;
    private static final int PASSWORD_MAX_LENGTH = 30;

    @Override
    public boolean isValid(
            UserRequestDto userRequestDto,
            ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid;
        isValid = userRequestDto.getPassword().length() > PASSWORD_MIN_LENGTH;
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(
                            "Password must be longer than " + PASSWORD_MIN_LENGTH)
                    .addConstraintViolation();
            return isValid;
        }
        isValid = userRequestDto.getPassword().length() < PASSWORD_MAX_LENGTH;
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(
                            "Password must be shorter than " + PASSWORD_MAX_LENGTH)
                    .addConstraintViolation();
            return isValid;
        }
        isValid = userRequestDto.getPassword() != null
                || userRequestDto.getRepeatPassword() != null;
        return isValid;
    }
}
