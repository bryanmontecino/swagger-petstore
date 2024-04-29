package ip.swagger.petstore;
import io.swagger.petstore.data.UserData;
import io.swagger.petstore.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDataTest {
    private UserData userData;

    @BeforeEach
    void setUp() {
        userData = new UserData();
    }

    @Test
    void testAddAndFindUser() {
        // Ensure newUser has non-null fields, especially 'username'
        User newUser = new User();
        newUser.setId(1L);
        newUser.setUsername("new-user");
        newUser.setFirstName("New");
        newUser.setLastName("User");
        newUser.setEmail("newuser@example.com");
        newUser.setPassword("password");
        newUser.setPhone("555-0123");
        newUser.setUserStatus(1);

        userData.addUser(newUser);
        assertNotNull(userData.findUserByName("new-user"), "User should be found by username");
    }

    @Test
    void testDeleteUser() {
        // Adding user to ensure the username to be deleted is present
        User userToDelete = new User();
        userToDelete.setId(2L);
        userToDelete.setUsername("delete user");
        userToDelete.setFirstName("Delete");
        userToDelete.setLastName("User");
        userToDelete.setEmail("delete@example.com");
        userToDelete.setPassword("password");
        userToDelete.setPhone("555-0124");
        userToDelete.setUserStatus(1);

        userData.addUser(userToDelete);
        // First, assert user is added correctly
        assertNotNull(userData.findUserByName("delete user"), "User should exist before deletion");

        userData.deleteUser("delete user");
        assertNull(userData.findUserByName("delete user"), "User should not be found after deletion");
    }
}
