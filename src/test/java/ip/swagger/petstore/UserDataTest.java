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
        User newUser = new User(1L, "new-user", "New", "User", "newuser@example.com", "password", "555-0123", 1);
        userData.addUser(newUser);
        assertNotNull(userData.findUserByName("new-user"));
    }

    @Test
    void testDeleteUser() {
        userData.addUser(new User(2L, "delete user", "Delete", "User", "delete@example.com", "password", "555-0124", 1));
        userData.deleteUser("delete user");
        assertNull(userData.findUserByName("delete user"));
    }
}
