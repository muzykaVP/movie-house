package movie.security;

import movie.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
