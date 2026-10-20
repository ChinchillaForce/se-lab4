package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void torpedoCount_DecreasesAfterFiring() {
        TorpedoStore store = new TorpedoStore(5);
        store.fire(1);
        assertEquals(4, store.getTorpedoCount(), "Torpedo count should decrease after firing");
    }

    @Test
    void fire_throwsException_WhenFiringMoreThanAvailable() {
        TorpedoStore store = new TorpedoStore(2);
        try {
            store.fire(3);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }

    }

    @Test 
    void fire_doesNotThrowException_WhenFiringLessThanAvailable() {
        TorpedoStore store = new TorpedoStore(2);
        try{
            store.fire(1);
        } catch (IllegalArgumentException e) {
            // This should not happen
            assertFalse(true, "Exception should not be thrown when firing less than available");
        }
    }
    
    @Test 
    void fire_allAvailableTorpedos() {
        TorpedoStore store = new TorpedoStore(3);
        boolean result = store.fire(3);
        assertEquals(true, result, "Firing all available torpedos should succeed");
        assertEquals(true, store.isEmpty(), "Torpedo count should be zero after firing all");
    }
}
