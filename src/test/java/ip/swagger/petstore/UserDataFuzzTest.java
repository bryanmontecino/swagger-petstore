package ip.swagger.petstore;

import io.swagger.petstore.data.UserData;
import io.swagger.petstore.model.User;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class UserDataFuzzTest {
    @Test
    void fuzzAddAndFindUser() {
        UserData userData = new UserData();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setUsername("User" + rand.nextInt(10000));
            user.setEmail("test" + i + "@example.com");
            user.setPassword("pass" + rand.nextInt(10000));

            userData.addUser(user);
            assertNotNull(userData.findUserByName(user.getUsername()),
                    "User should be retrievable by username");
        }
    }
}
