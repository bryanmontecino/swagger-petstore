package ip.swagger.petstore;

import io.swagger.petstore.model.ApiResponse;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseFuzzTest {
    @Test
    void fuzzApiResponse() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int code = rand.nextInt(1000); // Random status code
            String message = Long.toHexString(Double.doubleToLongBits(rand.nextDouble()));

            ApiResponse response = new ApiResponse(code, message);
            assertNotNull(response.getMessage(), "Message should not be null");
            assertTrue(response.getType().matches("error | warning | info | ok | too busy | unknown"),
                    "Type should be one of the predefined types or 'unknown'");
        }
    }
}
