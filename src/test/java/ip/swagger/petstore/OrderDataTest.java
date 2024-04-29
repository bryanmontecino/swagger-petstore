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
        // Reset and reinitialize orders for a clean test environment
        orderData = new OrderData();
        OrderData.orders.clear();  // Assuming 'orders' list is accessible, make it public or provide a method to clear it
        // Re-add orders
        OrderData.orders.add(OrderData.createOrder(1, 1, 100, new Date(), "placed", true));
        OrderData.orders.add(OrderData.createOrder(2, 1, 50, new Date(), "approved", true));
        OrderData.orders.add(OrderData.createOrder(3, 1, 50, new Date(), "delivered", true));
    }

    @Test
    void testAddOrder() {
        Order newOrder = OrderData.createOrder(4, 2, 30, new Date(), "placed", false);
        orderData.addOrder(newOrder);
        assertEquals(newOrder, orderData.getOrderById(4));
    }

    @Test
    void testGetOrderById() {
        assertNotNull(orderData.getOrderById(1), "Order with ID 1 should not be null");
        assertNull(orderData.getOrderById(999), "Order with ID 999 should be null"); // Assuming 999 is an invalid ID
    }

    @Test
    void testDeleteOrderById() {
        assertNotNull(orderData.getOrderById(1), "Order with ID 1 should exist before deletion");
        orderData.deleteOrderById(1L);
        assertNull(orderData.getOrderById(1), "Order with ID 1 should have been deleted");
    }

    @Test
    void testGetCountByStatus() {
        Map<String, Integer> countByStatus = orderData.getCountByStatus();
        assertNotNull(countByStatus, "Count by status should not be null");
        assertEquals(100, countByStatus.getOrDefault("placed", 0), "There should be 100 units of 'placed' status");
        assertEquals(50, countByStatus.getOrDefault("approved", 0), "There should be 50 units of 'approved' status");
        assertEquals(50, countByStatus.getOrDefault("delivered", 0), "There should be 50 units of 'delivered' status");
    }
}
