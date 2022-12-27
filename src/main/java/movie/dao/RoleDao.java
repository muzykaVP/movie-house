package movie.dao;

import java.util.Optional;
import movie.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(String roleName);
}
