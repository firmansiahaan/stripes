package stripesbook.test.plainmock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.stripes.localization.LocalePicker;
import stripesbook.ext.MyLocalePicker;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Locale;

public class MyLocalePickerTest {
	private LocalePicker localePicker;
	private HttpServletRequest req;
	private HttpSession session;
	
	@Before
	public void setup() {
		new MyLocalePicker();
		req = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		stub(req.getSession()).toReturn(session);
	}
	
	@Test
	public void testLocaleFrInRequest() {
		stub(req.getParameter(MyLocalePicker.LOCALE)).toReturn( "fr" );
		Locale locale = localePicker.pickLocale(req);
		assertEquals(Locale.FRENCH, locale);
	}
	
	@Test
	public void testLocaleFrInSession() {
		stub(session.getAttribute(MyLocalePicker.LOCALE)).toReturn("fr");
		Locale locale = localePicker.pickLocale(req);
		assertEquals(Locale.FRENCH, locale);
	}
	
	@Test
	public void testLocaleInRequestOverridesSession() {
		stub(session.getAttribute(MyLocalePicker.LOCALE)).toReturn("fr");
		stub(req.getParameter(MyLocalePicker.LOCALE)).toReturn("en");
		Locale locale = localePicker.pickLocale(req);
		assertEquals(Locale.ENGLISH, locale);
	}
}