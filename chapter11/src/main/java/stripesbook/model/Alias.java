package stripesbook.model;

public class Alias {
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    private User user;
    private String name;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode());
    }

}