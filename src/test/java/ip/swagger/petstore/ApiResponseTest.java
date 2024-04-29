package ip.swagger.petstore;
import io.swagger.petstore.model.ApiResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void testApiResponseConstruction() {
        ApiResponse response = new ApiResponse(ApiResponse.OK, "Success");
        assertEquals("ok", response.getType());
        assertEquals("Success", response.getMessage());
    }
}
