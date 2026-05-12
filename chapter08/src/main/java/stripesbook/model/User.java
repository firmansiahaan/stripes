package stripesbook.model;

import java.util.List;

public class User extends ModelBase {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private List<String> aliases;

    /* getters and setters... */

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<String> getAliases() {
        return aliases;
    }
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

}

