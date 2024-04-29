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
    private RequestContext mockRequest;

    @BeforeEach
    void setUp() {
        controller = new UserController();
        mockRequest = new ManualRequestContext();
    }

    @Test
    void testCreateUser() {
        User newUser = new User();
        newUser.setId(1L);
        newUser.setUsername("newuser");
        newUser.setFirstName("New");
        newUser.setLastName("User");
        newUser.setEmail("newuser@example.com");
        newUser.setPassword("password");
        newUser.setPhone("555-0123");
        newUser.setUserStatus(1);

        // Test createUser method
        ResponseContext result = controller.createUser(mockRequest, newUser);
        assertEquals(Response.Status.OK.getStatusCode(), result.getStatus(), "Expected HTTP status 200 OK");
        assertNotNull(result.getEntity(), "Entity should not be null after creation");
    }

    @Test
    void testDeleteUser() {
        // Test deleteUser method
        ResponseContext result = controller.deleteUser(mockRequest, "newuser");
        assertEquals(Response.Status.OK.getStatusCode(), result.getStatus(), "Expected HTTP status 200 OK");
    }
}
