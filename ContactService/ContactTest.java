import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // Test successful creation of a contact
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "Sam", "Blanton", "1234567890", "123 Main St");
        assertNotNull(contact);
    }

    // Test contact ID constraints
    @Test
    public void testContactIdConstraints() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Sam", "Blanton", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test firstName constraints
    @Test
    public void testFirstNameConstraints() {
        Contact contact = new Contact("1234567890", "Sam", "Blanton", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("LongFirstName"));
    }

    // Test lastName constraints
    @Test
    public void testLastNameConstraints() {
        Contact contact = new Contact("1234567890", "Sam", "Blanton", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LongLastName"));
    }

    // Test phone constraints
    @Test
    public void testPhoneConstraints() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "1234", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "abcdefghij", "123 Main St"));
    }

    // Test address constraints
    @Test
    public void testAddressConstraints() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("Long Address exceeding the thirty character limit"));
    }
}