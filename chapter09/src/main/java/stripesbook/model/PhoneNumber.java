package stripesbook.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

	private int areaCode;
    private int prefix;
    private int suffix;

    private static final Pattern pattern = Pattern.compile(
    		"\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})" );
    
    public PhoneNumber() {
    }
    public PhoneNumber(int areaCode, int prefix, int suffix) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    // Stripes will use this for String -> PhoneNumber type conversion
    public PhoneNumber(String input) {
    	if (input != null) {
    		Matcher matcher = pattern.matcher(input);
    	
	    	if (matcher.matches()) {
	    		areaCode = Integer.parseInt(matcher.group(1));
	    		prefix = Integer.parseInt(matcher.group(2));
	    		suffix = Integer.parseInt(matcher.group(3));
	    	}
	    	else {
	    		// This exception will only get logged
	    		throw new IllegalArgumentException(input + " is not a valid phone number." );
	    	}
    	}
    }
    
    public int getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }
    public int getPrefix() {
        return prefix;
    }
    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }
    public int getSuffix() {
        return suffix;
    }
    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }
    
    // Stripes will use this for PhoneNumber -> String formatting
    public String toString() {
    	// Only one format can be supported
    	return String.format("%s-%s-%s" , areaCode, prefix, suffix);
    }
    
}
