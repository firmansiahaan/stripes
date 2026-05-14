package stripesbook.dao.mock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import stripesbook.dao.ContactDao;
import stripesbook.model.Contact;
import stripesbook.model.Gender;
import stripesbook.model.PhoneNumber;

public class MockContactDao extends MockDao<Contact> implements ContactDao {

	private static final int FIRST_NAME   =  0;
    private static final int LAST_NAME    =  1;
    private static final int EMAIL        =  2;
    private static final int PHONE_NUMBER =  3;
    private static final int BIRTH_DATE   =  4;
    private static final int GENDER       =  5;

    private static final String[] RAW_DATA = {
        "Sophie,Hunter,sh@stripesbook.org,555-555-8440,1981-08-08,Female",
        "Daniel,Greene,dg@stripesbook.org,555-555-7763,1986-06-03,Male",
        "Jen,Ballou,jb@stripesbook.org,555-555-6495,1982-08-30,Female",
        "Sammy,Blair,sb@stripesbook.org,555-555-9592,1981-06-02,Male",
        "Betty,Stocker,bs@stripesbook.org,555-555-8316,1987-05-22,Female",
        "Lou,Thompson,lt@stripesbook.org,555-555-2765,1980-08-29,Male",
        "Lexi,Hawk,lh@stripesbook.org,555-555-7211,1982-05-01,Female",
        "George,Wells,gw@stripesbook.org,555-555-7689,1987-05-15,Male",
        "Donna,McCallum,dm@stripesbook.org,555-555-3432,1979-12-28,Female",
        "Jason,Wilson,jw@stripesbook.org,555-555-4032,1978-04-03,Male",
    };

    private static final DateFormat dateFormat =
        new SimpleDateFormat("yyyy-MM-dd");

    private MockContactDao() {
        try {
            for (String string : RAW_DATA) {
                save(createContactFromString(string));
            }
        }
        catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    private static MockContactDao instance = new MockContactDao();
    public static MockContactDao getInstance() { return instance; }

    private PhoneNumber getPhoneNumber(String string) {
        return new PhoneNumber(
            Integer.parseInt(string.substring(0, 3)),
            Integer.parseInt(string.substring(4, 7)),
    		Integer.parseInt(string.substring(8))
        );
    }

    private Contact createContactFromString(String string)
        throws Exception
    {
        String[] fields = string.split(",");

        Contact contact = new Contact();

        contact.setFirstName(fields[FIRST_NAME]);
        contact.setLastName(fields[LAST_NAME]);
        contact.setEmail(fields[EMAIL]);
        contact.setPhoneNumber(getPhoneNumber(fields[PHONE_NUMBER]));
        contact.setBirthDate(dateFormat.parse(fields[BIRTH_DATE]));
        contact.setGender(Gender.valueOf(fields[GENDER]));

        return contact;
    }

    public Contact findByEmail(String email) {
        Contact result = null;
        for (Contact contact : read()) {
        	String currentContactEmail = contact.getEmail();
        	if (currentContactEmail != null && email != null) {
	            if (email.equals(currentContactEmail)) {
	                result = contact;
	                break;
	            }
        	}
        }
        return result;
    }

    @Override
    protected Contact copyObject(Contact contact) {
        Contact copy = new Contact();
        copy.setId(contact.getId());
        copy.setFirstName(contact.getFirstName());
        copy.setLastName(contact.getLastName());
        copy.setEmail(contact.getEmail());
        copy.setPhoneNumber(contact.getPhoneNumber());
        copy.setBirthDate(contact.getBirthDate());
        copy.setGender(contact.getGender());
        return copy;
    }
	
}
