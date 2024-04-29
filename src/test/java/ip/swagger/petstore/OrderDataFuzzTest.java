package ip.swagger.petstore;

import io.swagger.petstore.data.OrderData;
import io.swagger.petstore.model.Order;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class OrderDataFuzzTest {
    @Test
    void fuzzAddAndGetOrder() {
        OrderData orderData = new OrderData();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            order.setId(rand.nextInt(10000));
            order.setPetId(rand.nextInt(10000));
            order.setQuantity(rand.nextInt(100));
            order.setShipDate(new Date(rand.nextLong()));
            order.setStatus("placed");
            order.setComplete(rand.nextBoolean());

            orderData.addOrder(order);
            assertNotNull(orderData.getOrderById(order.getId()), "Order should be retrievable by ID");
        }
    }
}
