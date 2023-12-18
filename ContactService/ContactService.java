import java.util.HashMap;
import java.util.Map;

public class ContactService {
 
    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Add a new contact if the ID is unique
    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contactId, new Contact(contactId, firstName, lastName, phone, address));
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Update the first name of a contact
    public void updateFirstName(String contactId, String newFirstName) {
        getContact(contactId).setFirstName(newFirstName);
    }

    // Update the last name of a contact
    public void updateLastName(String contactId, String newLastName) {
        getContact(contactId).setLastName(newLastName);
    }

    // Update the phone number of a contact
    public void updatePhone(String contactId, String newPhone) {
        getContact(contactId).setPhone(newPhone);
    }

    // Update the address of a contact
    public void updateAddress(String contactId, String newAddress) {
        getContact(contactId).setAddress(newAddress);
    }

    // Public method to get a contact by ID
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        return contacts.get(contactId);
    }
}
