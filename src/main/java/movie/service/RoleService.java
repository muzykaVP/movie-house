package movie.service;

import movie.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
