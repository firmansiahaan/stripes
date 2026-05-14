package stripesbook.ext;

import java.util.Collection;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.stripes.exception.StripesRuntimeException;
import net.sourceforge.stripes.format.Formatter;
import net.sourceforge.stripes.validation.ScopedLocalizableError;
import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;
import stripesbook.model.PhoneNumber;

public class PhoneNumberTypeConverterFormatter implements Formatter<PhoneNumber>, TypeConverter<PhoneNumber> {
	private String formatType = "dashes";
	private static final Pattern pattern = Pattern.compile(
	        "\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})");
	
	@Override
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

    public PhoneNumber convert(String input,
            Class<? extends PhoneNumber> type,
            Collection<ValidationError> errors) {
            PhoneNumber result = null;
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                result = new PhoneNumber(
                    matcher.group(1), matcher.group(2), matcher.group(3));
            }
            else {
                errors.add(
                    new ScopedLocalizableError("converter.phoneNumber", "invalid"));
            }
            return result;
    }
    
}
