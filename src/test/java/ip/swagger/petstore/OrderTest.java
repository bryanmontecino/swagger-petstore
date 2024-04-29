package ip.swagger.petstore;
import io.swagger.petstore.model.Order;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testOrderSettersAndGetters() {
        Order order = new Order();
        order.setId(1L);
        order.setPetId(1L);
        order.setQuantity(5);
        order.setShipDate(new Date());
        order.setStatus("placed");

        assertEquals(1L, order.getId());
        assertEquals(1L, order.getPetId());
        assertEquals(5, order.getQuantity());
        assertEquals("placed", order.getStatus());
        assertNotNull(order.getShipDate());
    }
}
