package stripesbook.model;

public class Attachment extends ModelBase {
    private String fileName;
    private long size;
    private String contentType;
    
    /* getters and setters... */
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }
    
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}