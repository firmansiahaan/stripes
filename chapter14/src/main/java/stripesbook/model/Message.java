package stripesbook.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    @ManyToOne
    private Folder folder;

    @Column(name="FROM_COL")
    private String from;

    @Column(name="TO_COL")
    private String to;
    private String cc;
    private String bcc;
    private String subject;
    private String text;
    private Date date;

    @OneToMany(mappedBy="message")
    private List<Attachment> attachments=new ArrayList<Attachment>();

    public Folder getFolder() {
        return folder;
    }
    
    public void setFolder(Folder folder) {
        this.folder = folder;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public String getTo() {
        return to;
    }
    
    public void setTo(String to) {
        this.to = to;
    }
    
    public String getCc() {
        return cc;
    }
    
    public void setCc(String cc) {
        this.cc = cc;
    }
    
    public String getBcc() {
        return bcc;
    }
    
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public List<Attachment> getAttachments() {
        return attachments;
    }
    
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public boolean equals(Object obj) {
        try { return id.equals(((Message) obj).getId()); }
        catch (Exception exc) { return false; }
    }
    
    @Override
    public int hashCode() {
        return 31 + ((id == null) ? 0 : id.hashCode());
    }
}