package stripesbook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    private String name;

    public Role() { }
    
    public Role(String name) {
    	this.name = name;
    }
    
    /* Getters and setters... */    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        try { return id.equals(((Role) obj).getId()); }
        catch (Exception exc) { return false; }
    }
    
    @Override
    public String toString() {
        return String.format("%s", name);        
    }

    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode());
    }

}