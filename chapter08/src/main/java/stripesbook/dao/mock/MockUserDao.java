package stripesbook.dao.mock;

import java.util.Arrays;
import stripesbook.dao.UserDao;
import stripesbook.model.User;

public class MockUserDao extends MockDao<User>
    implements UserDao
{
    private MockUserDao() {
        try {
            User user = new User();

            user.setFirstName("Fred");
            user.setLastName("Daoud");
            user.setUsername("freddy");
            user.setPassword("nadia");
            user.setAliases(Arrays.asList("fred"));

            save(user);
        }
        catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
    private static MockUserDao instance = new MockUserDao();
    public static MockUserDao getInstance() { return instance; }

    public User findByUsername(String username) {
        User result = null;
        for (User user : read()) {
            if (username.equals(user.getUsername())) {
                result = user;
                break;
            }
        }
        return result;
    }
}
