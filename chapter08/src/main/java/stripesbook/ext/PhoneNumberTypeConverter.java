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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.stripes.validation.ScopedLocalizableError;
import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;
import stripesbook.model.PhoneNumber;

public class PhoneNumberTypeConverter
    implements TypeConverter<PhoneNumber>
{
    private static final Pattern pattern = Pattern.compile(
        "\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})");

    public PhoneNumber convert(String input,
        Class<? extends PhoneNumber> type,
        Collection<ValidationError> errors)
    {
        PhoneNumber result = null;
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            result = new PhoneNumber(
                Integer.parseInt(matcher.group(1)), 
                Integer.parseInt(matcher.group(2)), 
                Integer.parseInt(matcher.group(3)));
        }
        else {
            errors.add(
                new ScopedLocalizableError("converter.phoneNumber", "invalid"));
        }
        return result;
    }
    public void setLocale(Locale locale) { }
}
