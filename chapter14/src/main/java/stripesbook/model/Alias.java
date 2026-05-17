package stripesbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Alias {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    @ManyToOne
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
    public boolean equals(Object obj) {
        try { return id.equals(((Alias) obj).getId()); }
        catch (Exception exc) { return false; }
    }
    
    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode());
    }

}