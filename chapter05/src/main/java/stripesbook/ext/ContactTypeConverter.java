/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/
package stripesbook.ext;

import java.util.Collection;
import java.util.Locale;

import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;
import stripesbook.dao.ContactDao;
import stripesbook.dao.mock.MockContactDao;
import stripesbook.model.Contact;

public class ContactTypeConverter implements TypeConverter<Contact> {
    private ContactDao contactDao = MockContactDao.getInstance();

    public Contact convert(String string,
        Class<? extends Contact> type,
        Collection<ValidationError> errors)
    {
        try {
        	Contact c = new Contact();
        	c.setId(Integer.parseInt(string));
            return contactDao.read(c);
        }
        catch (Exception exc) {
            errors.add(new SimpleError(
                "The contact ID {1} is not valid."));
            return null;
        }
    }
    public void setLocale(Locale locale) { }
}
