package stripesbook.dao;

import stripesbook.model.Role;

public interface RoleDao extends Dao<Role,Integer> {
    public Role findByName(String name);
}
