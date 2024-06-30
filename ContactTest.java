/************************
 * Name: Aaron Bias
 * Course: CS-320: Software Test, Automation
 * Date: June 16, 2024
*************************/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

	// This will test that a valid contact is created
    @Test
    public void testContactCreationValid() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        assertEquals("0123456789", contact.getContactID());
        assertEquals("Abraham", contact.getFirstName());
        assertEquals("Lincoln", contact.getLastName());
        assertEquals("4053134141", contact.getPhone());
        assertEquals("1600 Pennsylvania Avenue NW", contact.getAddress());
    }
    
    // This will test that invalid ID creation (null or length is greater than 10)
    @Test
    public void testContactCreationInvalidID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid contact ID", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01234567890", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    // This will test the creation of a invalid first name in the contacts (null and length greater than 10) 
    @Test
    public void testContactCreationInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", null, "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid first name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "AbrahamJames", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    // This will test the creation of a invalid last name in the contacts (null and length greater than 10)
    @Test
    public void testContactCreationInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", null, "4053134141", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid last name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", "JamesLincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }
    
    // This will test the creation of a invalid phone number (null and length != 10 and non-numeric)
    @Test
    public void testContactCreationInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", "Lincoln", null, "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid phone number", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", "Lincoln", "405313414", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid phone number", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", "Lincoln", "40531341411", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid phone number", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", "Lincoln", "abcdefghij", "1600 Pennsylvania Avenue NW");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    // This will test the creation of a invalid address (null and length no longer than 30)
    @Test
    public void testContactCreationInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", "Lincoln", "4053134141", null);
        });
        assertEquals("Invalid address", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "0123456789012345678901234567890");
        });
        assertEquals("Invalid address", exception.getMessage());
    }

    // This will test the updating of first names with valid and invalid values (more than 10 characters)
    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        contact.setFirstName("James");
        assertEquals("James", contact.getFirstName());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("JamesJamesJames");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }
    
    // This will test the updating of last names with valid and invalid values (more than 10 characters)
    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        contact.setLastName("James");
        assertEquals("James", contact.getLastName());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("JamesJamesJames");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }
    
    // This will test the updating of the phone number with valid and invalid values
    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        contact.setPhone("4053134142");
        assertEquals("4053134142", contact.getPhone());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("40531341421");
        });
        assertEquals("Invalid phone number", exception.getMessage());
    }

    // This will test the updating of the address with valid and invalid values
    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("0123456789", "Abraham", "Lincoln", "4053134141", "1600 Pennsylvania Avenue NW");
        contact.setAddress("2 Lincoln Memorial Cir NW");
        assertEquals("2 Lincoln Memorial Cir NW", contact.getAddress());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("2 Lincoln Memorial Cir NW2 Lincoln Memorial Cir NW");
        });
        assertEquals("Invalid address", exception.getMessage());
    }
}