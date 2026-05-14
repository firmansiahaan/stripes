package stripesbook.opt;

import net.sourceforge.stripes.validation.DateTypeConverter;

public class TimeTypeConverter extends DateTypeConverter {
	private static final String[] TIME_FORMAT = { "HH:mm" };
	
	@Override
	protected String[] getFormatStrings() {
		return TIME_FORMAT;
	}
}
