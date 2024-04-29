package ip.swagger.petstore;
import io.swagger.petstore.data.OrderData;
import io.swagger.petstore.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;
import java.util.Map;

class OrderDataTest {
    private OrderData orderData;

    @BeforeEach
    void setUp() {
        orderData = new OrderData(); // Setup OrderData for each test
    }

    @Test
    void testAddOrder() {
        Order newOrder = OrderData.createOrder(4, 2, 30, new Date(), "placed", false);
        orderData.addOrder(newOrder);
        assertEquals(newOrder, orderData.getOrderById(4));
    }

    @Test
    void testGetOrderById() {
        assertNotNull(orderData.getOrderById(1));
        assertNull(orderData.getOrderById(999)); // Assuming 999 is an invalid ID
    }

    @Test
    void testDeleteOrderById() {
        orderData.deleteOrderById(1L);
        assertNull(orderData.getOrderById(1)); // Ensure the order is deleted
    }

    @Test
    void testGetCountByStatus() {
        Map<String, Integer> countByStatus = orderData.getCountByStatus();
        assertTrue(countByStatus.containsKey("placed"));
        assertTrue(countByStatus.containsKey("approved"));
        assertTrue(countByStatus.containsKey("delivered"));
        assertEquals(100, countByStatus.get("placed"));
        assertEquals(50, countByStatus.get("approved"));
        assertEquals(50, countByStatus.get("delivered"));
    }
}
