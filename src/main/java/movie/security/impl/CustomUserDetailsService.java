package movie.security.impl;

import java.util.Optional;
import movie.model.User;
import movie.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(email);
        UserBuilder userBuilder;
        if (userOptional.isPresent()) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.password(userOptional.get().getPassword());
            userBuilder.roles(userOptional.get().getAuthorities().stream()
                    .map(role -> role.getName().name())
                    .toArray(String[]::new));
            return userBuilder.build();
        }
        throw new UsernameNotFoundException("User not found.");
    }
}
