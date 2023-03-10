package movie.dao.impl;

import java.util.Optional;
import movie.dao.AbstractDao;
import movie.dao.RoleDao;
import movie.exception.DataProcessingException;
import movie.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> getByName
                    = session.createQuery("FROM Role WHERE name = :name", Role.class);
            getByName.setParameter("name", Role.RoleName.valueOf(roleName));
            return getByName.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Not found role " + roleName, e);
        }
    }
}
