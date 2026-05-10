/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/

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

