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
