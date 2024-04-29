package ip.swagger.petstore;
import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import io.swagger.petstore.controller.UserController;
import io.swagger.petstore.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private UserController controller;

    @BeforeEach
    void setUp() {
        controller = new UserController(); // Ensure UserController can be instantiated
    }

    @Test
    void testCreateUser() {
        User newUser = new User(1L, "newuser", "New", "User", "newuser@example.com", "password", "555-0123", 1);
        ResponseContext result = controller.createUser(new RequestContext(), newUser);
        assertEquals(Response.Status.OK.getStatusCode(), result.getStatus());
        assertNotNull(result.getEntity());
    }

    @Test
    void testDeleteUser() {
        ResponseContext result = controller.deleteUser(new RequestContext(), "newuser");
        assertEquals(Response.Status.OK.getStatusCode(), result.getStatus());
    }
}
