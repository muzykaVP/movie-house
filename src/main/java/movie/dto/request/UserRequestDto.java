package movie.dto.request;

import javax.validation.constraints.Size;
import lombok.Getter;
import movie.lib.FieldsValueMatch;
import movie.lib.ValidEmail;
import movie.lib.ValidPassword;

@Getter
@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)

@ValidPassword
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 8, max = 40)
    private String password;
    private String repeatPassword;
}
