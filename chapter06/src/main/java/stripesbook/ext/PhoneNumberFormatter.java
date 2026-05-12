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
import net.sourceforge.stripes.exception.StripesRuntimeException;
import net.sourceforge.stripes.format.Formatter;
import stripesbook.model.PhoneNumber;

public class PhoneNumberFormatter implements Formatter<PhoneNumber> {
    private String formatType = "dashes";

    public void setFormatType(String formatType) {
        this.formatType = formatType;
    }
    public void setLocale(Locale locale) { }
    public void setFormatPattern(String formatPattern) { }
    public void init() { }

    public String format(PhoneNumber phoneNumber) {
        String format = null;
        if ("dashes".equalsIgnoreCase(formatType)) {
            format = "%s-%s-%s";
        }
        else if ("parens".equalsIgnoreCase(formatType)) {
            format = "(%s) %s-%s";
        }
        else {
            throw new StripesRuntimeException(String.format(
                "Invalid phone number formatType: %s. Valid values "
                + "are 'dashes' and 'parens'.", formatType));
        }
        return String.format(format, phoneNumber.getAreaCode(),
            phoneNumber.getPrefix(), phoneNumber.getSuffix());
    }
}
