import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact(
                "12345", "John", "Smith",
                "1234567890", "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdTooLong() {
        new Contact("12345678901", "John", "Smith",
                "1234567890", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testContactIdNull() {
        new Contact(null, "John", "Smith",
                "1234567890", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameTooLong() {
        new Contact("12345", "Christopher", "Smith",
                "1234567890", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFirstNameNull() {
        new Contact("12345", null, "Smith",
                "1234567890", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameTooLong() {
        new Contact("12345", "John", "Longlastname",
                "1234567890", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLastNameNull() {
        new Contact("12345", "John", null,
                "1234567890", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooShort() {
        new Contact("12345", "John", "Smith",
                "123456789", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneTooLong() {
        new Contact("12345", "John", "Smith",
                "12345678901", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneNull() {
        new Contact("12345", "John", "Smith",
                null, "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPhoneOnlyDigits() {
        new Contact("12345", "John", "Smith",
                "12345abcde", "123 Main Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressTooLong() {
        new Contact("12345", "John", "Smith",
                "1234567890",
                "This address is longer than thirty characters");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddressNull() {
        new Contact("12345", "John", "Smith",
                "1234567890", null);
    }

    @Test
    public void testUpdateFields() {
        Contact contact = new Contact(
                "12345", "John", "Smith",
                "1234567890", "123 Main Street");

        contact.setFirstName("David");
        contact.setLastName("Jones");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Street");

        assertEquals("David", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Street", contact.getAddress());

        // Contact ID remains unchanged.
        assertEquals("12345", contact.getContactId());
    }
}