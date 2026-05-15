package stripesbook.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
    private String areaCode;
    private String prefix;
    private String suffix;

    public PhoneNumber() {
    }
    public PhoneNumber(String areaCode, String prefix, String suffix) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public String getSuffix() {
        return suffix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
