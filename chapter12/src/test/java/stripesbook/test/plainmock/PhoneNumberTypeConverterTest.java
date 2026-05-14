package stripesbook.test.plainmock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;
import stripesbook.model.PhoneNumber;
import stripesbook.ext.PhoneNumberTypeConverterFormatter;

public class PhoneNumberTypeConverterTest {

	private TypeConverter<PhoneNumber> typeConverter;
	private Collection<ValidationError> errors;
	
	@Before
	public void setup() {
		typeConverter = new PhoneNumberTypeConverterFormatter();
		errors = new ArrayList<ValidationError>();
	}
	
	@Test
	public void testValidPhoneNumber() {
		
		PhoneNumber phoneNumber = typeConverter.convert("(555) 444.6667" , PhoneNumber.class, errors);
				
		assertEquals(0, errors.size());
		assertEquals("555" , phoneNumber.getAreaCode());
		assertEquals("444" , phoneNumber.getPrefix());
		assertEquals("6667" , phoneNumber.getSuffix());
				
	}
	
	@Test
	public void testInvalidPhoneNumber() {
		
		PhoneNumber phoneNumber = typeConverter.convert(" 55 444.667 " , PhoneNumber.class, errors);
		assertNull(phoneNumber);
		assertEquals(1, errors.size());
		
	}
}
