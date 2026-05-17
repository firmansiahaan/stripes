package stripesbook.dao.impl.stripersist;

import org.springframework.stereotype.Repository;

import stripesbook.dao.UserDao;
import stripesbook.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User,Integer>
    implements UserDao
{
    public User findByUsername(String username) {
        return findBy("username", username);
    }
}
