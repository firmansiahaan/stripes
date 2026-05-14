package stripesbook.dao;

import stripesbook.model.User;

public interface UserDao extends Dao<User,Integer> {
    public User findByUsername(String username);
}
