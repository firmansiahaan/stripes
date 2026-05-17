package stripesbook.dao.impl.stripersist;

import org.springframework.stereotype.Repository;

import stripesbook.dao.RoleDao;
import stripesbook.model.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role,Integer>
    implements RoleDao
{
    public Role findByName(String name) {
        return findBy("name", name);
    }
}
