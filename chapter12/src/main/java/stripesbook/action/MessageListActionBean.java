package stripesbook.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.Validate;
import stripesbook.model.Attachment;
import stripesbook.model.Folder;
import stripesbook.model.Message;

public class MessageListActionBean extends BaseActionBean {
    private static final String LIST="/WEB-INF/jsp/message_list.jsp";

    @DefaultHandler
    public Resolution list() {
        return new ForwardResolution(LIST);
    }
    public Resolution delete() {
        Folder folder = getContext().getCurrentFolder();

        if (Folder.TRASH.equals(folder.getName())) {
            for (Message message : selectedMessages) {
                for (Attachment attachment : message.getAttachments()) {
                    attachmentDao.deleteFile(attachment);
                }
                messageDao.delete(message);
            }
        }
        else {
            Folder trash =
                folderDao.findByName(Folder.TRASH, getUser());
            for (Message message : selectedMessages) {
                messageDao.addMessageToFolder(message, trash);
            }
        }
        messageDao.commit();
        return new RedirectResolution(getClass());
    }
    public Resolution moveToFolder() {
        for (Message message : selectedMessages) {
            messageDao.addMessageToFolder(message, selectedFolder);
        }
        messageDao.commit();
        return new RedirectResolution(getClass());
    }
    @Validate(required=true, on={"delete", "moveToFolder"})
    private List<Message> selectedMessages;
    public List<Message> getSelectedMessages() {
        return selectedMessages;
    }
    public void setSelectedMessages(List<Message> selectedMessages) {
        this.selectedMessages = selectedMessages;
    }
    @Validate(required=true, on="moveToFolder")
    private Folder selectedFolder;
    public Folder getSelectedFolder() {
        return selectedFolder;
    }
    public void setSelectedFolder(Folder selectedFolder) {
        this.selectedFolder = selectedFolder;
    }
}
