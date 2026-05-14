package stripesbook.model;

import java.util.ArrayList;
import java.util.List;

public class Folder extends ModelBase {
    private String name;
    private int numberOfMessages;
    private List<Message> messages = new ArrayList<Message>();

    public static final String INBOX = "Inbox";
    public static final String SENT  = "Sent";
    public static final String REF   = "Reference";
    public static final String TRASH = "Trash";

    public static final String[] DEFAULT_FOLDER_NAMES = {
        INBOX, SENT, REF, TRASH,
    };
    
    public Folder() {
    }
    public Folder(String name) {
        setName(name);
    }
    
    /* getters and setters... */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getNumberOfMessages() {
		return numberOfMessages;
	}
    
	public void setNumberOfMessages(int numberOfMessages) {
		this.numberOfMessages = numberOfMessages;
	}
	@Override
    public String toString() {
        return name;
    }
}

