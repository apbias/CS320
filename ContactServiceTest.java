/************************
 * Name: Aaron Bias
 * Course: CS-320: Software Test, Automation
 * Date: June 16, 2024
*************************/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    // This will setup a new ContactService before each test
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }
    
    // This will test that the added contact is valid
    @Test
    public void testAddContact() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        assertTrue(contactService.addContact(contact));
        assertNotNull(contactService.getContact("0123456789"));
    }

    // This will test duplicate IDs 
    @Test
    public void testAddContactDuplicateID() {
        Contact contact1 = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        Contact contact2 = new Contact("0123456789", "Hillary", "Clinton", "1567891456", "1600 Pennsylvania Avenue NW");

        assertTrue(contactService.addContact(contact1));
        assertFalse(contactService.addContact(contact2)); // Duplicate ID
    }
    
    // This will test the deletion function of contacts
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("0123456789"));
        assertNull(contactService.getContact("0123456789"));
    }

    // This will test the deletion function of a nonexistent contact
    @Test
    public void testDeleteNonexistentContact() {
        assertFalse(contactService.deleteContact("invalidID"));
    }
    
    // This will test the updating of existing contacts
    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("0123456789", "Hillary", "Clinton", "1567891456", "1600 Pennsylvania Avenue NW"));

        Contact updatedContact = contactService.getContact("0123456789");
        assertEquals("Hillary", updatedContact.getFirstName());
        assertEquals("Clinton", updatedContact.getLastName());
        assertEquals("1567891456", updatedContact.getPhone());
        assertEquals("1600 Pennsylvania Avenue NW", updatedContact.getAddress());
    }

    // This will test the updating of a non existing contact
    @Test
    public void testUpdateNonexistentContact() {
        assertFalse(contactService.updateContact("invalidID", "Hillary", "Clinton", "1567891456", "1600 Pennsylvania Avenue NW"));
    }
}