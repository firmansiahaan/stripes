/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/
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
