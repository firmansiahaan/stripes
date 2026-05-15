package stripesbook.ext;

import java.util.Locale;
import net.sourceforge.stripes.format.Formatter;
import stripesbook.model.Contact;


public class ContactFormatter implements Formatter<Contact> {
    public String format(Contact contact) {
        return String.valueOf(contact.getId());
    }
    public void init() { }
    public void setLocale(Locale locale) { }
    public void setFormatType(String type) { }
    public void setFormatPattern(String pattern) { }
}

