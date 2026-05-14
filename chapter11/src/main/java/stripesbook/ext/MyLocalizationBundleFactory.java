package stripesbook.ext;

import java.util.Locale;

import java.util.ResourceBundle;
import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.localization.LocalizationBundleFactory;


public class MyLocalizationBundleFactory
    implements LocalizationBundleFactory
{
    public ResourceBundle getFormFieldBundle(Locale locale) {
        return new MyResourceBundle(locale);
    }
    public ResourceBundle getErrorMessageBundle(Locale locale) {
        return new MyResourceBundle(locale);
    }
    public void init(Configuration configuration) { }
}