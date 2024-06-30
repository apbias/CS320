/************************
 * Name: Aaron Bias
 * Course: CS-320: Software Test, Automation
 * Date: June 16, 2024
*************************/

public class Contact {
    private final String contactID; // Unique ID for contact info , can't be longer than 10 characters
    private String firstName; // First Name, can't be null or longer than 10 characters
    private String lastName; // Last Name, can't be null or longer than 10 characters
    private String phone; // Phone Number, must be numerical and 10 digits long and not null
    private String address; // Address, no longer than 30 characters and not null

    // Constructor that will initialize the contact object with validation parameters 
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
    	
    	// Set and Validate ID
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        this.contactID = contactID;
        // Set and Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
        
        // Set and Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
        
        // Set and Validate phone number
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
        
        // Set and Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;        
    }
    
    // Getters

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phone;
    } 
    
    public String getAddress() {
        return address;
    }
    
    
    // Setters with validation checks

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}