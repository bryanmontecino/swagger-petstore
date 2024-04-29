package ip.swagger.petstore;
import io.swagger.petstore.model.Pet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    @Test
    void testPetSettersAndGetters() {
        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Fido");
        pet.setStatus("available");

        assertEquals(1L, pet.getId());
        assertEquals("Fido", pet.getName());
        assertEquals("available", pet.getStatus());
    }
}
