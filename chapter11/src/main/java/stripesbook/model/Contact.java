package stripesbook.model;

import java.util.Date;

public class Contact extends ModelBase {

	private String firstName;
    private String lastName;
    private String email;
    private PhoneNumber phoneNumber;
    private Date birthDate;
    private Gender gender;

    /* Getters and setters... */

    public String getFirstName() {
        return firstName;
    }
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

}
