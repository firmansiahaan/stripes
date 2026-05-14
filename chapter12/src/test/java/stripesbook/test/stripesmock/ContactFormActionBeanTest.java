package stripesbook.test.stripesmock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sourceforge.stripes.controller	.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockHttpSession;
import net.sourceforge.stripes.mock.MockRoundtrip;
import net.sourceforge.stripes.mock.MockServletContext;
import stripesbook.action.ContactFormActionBean;
import stripesbook.model.PhoneNumber;

public class ContactFormActionBeanTest {

	private static MockServletContext mockServletContext;
	private static MockHttpSession mockSession;

	@BeforeClass
	public static void setup() throws Exception {
		
		mockServletContext = new MockServletContext("webmail" );
		Map<String,String> params = new HashMap<String,String>();
		params.put("ActionResolver.Packages" , "stripesbook.action" );
		params.put("Extension.Packages", "stripesbook.ext," + "org.stripesstuff.stripersist" );
		mockServletContext.addFilter(StripesFilter.class, "StripesFilter" , params);
		mockServletContext.setServlet(DispatcherServlet.class, "DispatcherServlet" , null);
		mockSession = new MockHttpSession(mockServletContext);
		
	}
	
	@Test
	public void testEmailRequired() throws Exception {
		
		MockRoundtrip trip = new MockRoundtrip(mockServletContext,
				ContactFormActionBean.class, mockSession);
		
		trip.execute("save");
		
		ContactFormActionBean bean = trip.getActionBean(ContactFormActionBean.class);
		
		assertEquals(1, bean.getContext().getValidationErrors().size());
		
		assertEquals(MockRoundtrip.DEFAULT_SOURCE_PAGE, trip.getDestination());
	}
	
	@Test
	public void testSaveValid() throws Exception {
		MockRoundtrip trip = new MockRoundtrip(mockServletContext,
		ContactFormActionBean.class, mockSession);
		trip.setParameter("contact.email" ,"test@test.com" );
		trip.setParameter("contact.phoneNumber" ,"654-456-4567" );
		trip.execute("save");
		ContactFormActionBean bean = trip.getActionBean(ContactFormActionBean.class);
		assertEquals(0,bean.getContext().getValidationErrors().size());
		PhoneNumber pn = bean.getContact().getPhoneNumber();
		assertEquals("654" , pn.getAreaCode());
		assertEquals("456" , pn.getPrefix());assertEquals("4567" , pn.getSuffix());
		assertTrue(trip.getDestination().startsWith("/ContactList.action" ));
	}
	
}
