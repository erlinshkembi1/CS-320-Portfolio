import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @Before
    public void setUp() {
        service = new ContactService();

        contact = new Contact(
                "10001",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");
    }

    @Test
    public void testAddContact() {
        service.addContact(contact);

        assertEquals(1, service.getContactCount());
        assertNotNull(service.getContact("10001"));
        assertEquals("John",
                service.getContact("10001").getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicateContactId() {
        service.addContact(contact);

        Contact duplicate = new Contact(
                "10001",
                "David",
                "Jones",
                "0987654321",
                "456 Oak Street");

        service.addContact(duplicate);
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact);

        service.deleteContact("10001");

        assertEquals(0, service.getContactCount());
        assertNull(service.getContact("10001"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteContactNotFound() {
        service.deleteContact("99999");
    }

    @Test
    public void testUpdateContact() {
        service.addContact(contact);

        service.updateContact(
                "10001",
                "David",
                "Jones",
                "0987654321",
                "456 Oak Street");

        Contact updatedContact = service.getContact("10001");

        assertEquals("David", updatedContact.getFirstName());
        assertEquals("Jones", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak Street", updatedContact.getAddress());

        // The contact ID cannot be updated.
        assertEquals("10001", updatedContact.getContactId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateContactNotFound() {
        service.updateContact(
                "99999",
                "David",
                "Jones",
                "0987654321",
                "456 Oak Street");
    }
}