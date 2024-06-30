/************************
 * Name: Aaron Bias
 * Course: CS-320: Software Test, Automation
 * Date: June 16, 2024
 * Description: ContactService will maintain a list of contacts without a user interface. It has the ability to update, add and delete information such as first name, last name,
 * phone number, and address.
************************/
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// Hashmap that will store contacts using their ID as the key
    private Map<String, Contact> contacts;

    // Constructor for the contacts HashMap
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Adds contacts to the contacts map while checking for duplicate ID
    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            return false; // Contact with the same ID already exists
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    // Deletes contacts by ID, returns false if ID does not exist
    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true;
        }
        return false;
    }

    // Updates the fields of a existing contact and will return true if successful (in line with requirements). If ID isn't found, return false
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            return false;
        }

        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        }
        if (phone != null && phone.length() == 10 && phone.matches("\\d+")) {
            contact.setPhone(phone);
        }
        if (address != null && address.length() <= 30) {
            contact.setAddress(address);
        }
        return true;
    }

    // Return contact by ID, if not found will return null
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
