import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    // Test adding a contact
    @Test
    public void testAddContact() {
        service.addContact("1", "Sam", "Blanton", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact("1", "Jane", "Doe", "0987654321", "321 Main St"));
    }

    // Test deleting a contact
    @Test
    public void testDeleteContact() {
        service.addContact("2", "Alice", "Smith", "2345678901", "456 Elm St");
        service.deleteContact("2");
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("2"));
    }

    // Test updating a contact's first name
    @Test
    public void testUpdateFirstName() {
        service.addContact("3", "Bob", "Jones", "3456789012", "789 Pine St");
        service.updateFirstName("3", "Robert");
        assertEquals("Robert", service.getContact("3").getFirstName());
    }

    // Test updating a contact's last name
    @Test
    public void testUpdateLastName() {
        service.addContact("4", "Carol", "Brown", "4567890123", "012 Maple St");
        service.updateLastName("4", "Johnson");
        assertEquals("Johnson", service.getContact("4").getLastName());
    }

    // Test updating a contact's phone number
    @Test
    public void testUpdatePhone() {
        service.addContact("5", "David", "White", "5678901234", "345 Cedar St");
        service.updatePhone("5", "6789012345");
        assertEquals("6789012345", service.getContact("5").getPhone());
    }

    // Test updating a contact's address
    @Test
    public void testUpdateAddress() {
        service.addContact("6", "Eve", "Green", "6789012345", "678 Spruce St");
        service.updateAddress("6", "890 Birch St");
        assertEquals("890 Birch St", service.getContact("6").getAddress());
    }


}

