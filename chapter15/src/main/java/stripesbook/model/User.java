package stripesbook.model;

import java.util.List;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean activated;
    
    @ManyToMany
    private List<Role> roles;

    @OneToMany(mappedBy="user")
    private Set<Alias> aliases;

    @OneToMany(mappedBy="user")
    private List<Folder> folders;


    @OneToMany(mappedBy="user")
    private Set<Contact> contacts;

    /* Getters and setters... */

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
    
    public boolean isActivated() {
		return activated;
	}
    
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public Set<Alias> getAliases() {
        return aliases;
    }
    
    public void setAliases(Set<Alias> aliases) {
        this.aliases = aliases;
    }
    
    public List<Folder> getFolders() {
        return folders;
    }
    
    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
    
    public Set<Contact> getContacts() {
        return contacts;
    }
    
    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
    
    @Override
    public boolean equals(Object obj) {
        try { return id.equals(((User) obj).getId()); }
        catch (Exception exc) { return false; }
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);        
    }

    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode());
    }

}