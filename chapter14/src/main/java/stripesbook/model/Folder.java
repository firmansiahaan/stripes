package stripesbook.model;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Folder {
    public static final String INBOX = "Inbox";
    public static final String SENT  = "Sent";
    public static final String REF   = "Reference";
    public static final String TRASH = "Trash";

    public static final String[] DEFAULT_FOLDER_NAMES = {
        INBOX, SENT, REF, TRASH,
    };
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    @ManyToOne
    private User user;

    private String name;

    @OneToMany(mappedBy="folder")
    private Set<Message> messages;

    public Folder() {
    }
    public Folder(String name, User user) {
        this.name = name;
        this.user = user;
    }

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
    
    public Set<Message> getMessages() {
        return messages;
    }
    
    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object obj) {
        try { return id.equals(((Folder) obj).getId()); }
        catch (Exception exc) { return false; }
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode());
    }
}