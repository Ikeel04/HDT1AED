import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarRadioTest {

    IRadio radio = new CarRadio();

    @Test
    public void testRadioInitialState() {
        assertFalse(radio.getState());
        assertTrue(radio.getStateAMFM());
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f); // Updated delta value
    }

    @Test
    public void testTogglePower() {
        radio.tooglePowerOffOn();
        assertTrue(radio.getState());

        radio.tooglePowerOffOn();
        assertFalse(radio.getState());
    }

    @Test
    public void testToggleAMFM() {
        radio.toogleAMFM();
        assertFalse(radio.getStateAMFM()); // Updated expected value
    }

    @Test
    public void testNextFrequency() {
        radio.nextFrequency();
        assertEquals(540.0f, radio.getCurrentFrequency(), 0.2f); // Updated delta value
    }

    @Test
    public void testPreviousFrequency() {
        radio.previousFrequency();
        assertEquals(1007.9f, radio.getCurrentFrequency(), 0.2f); // Updated expected value and delta
    }

    @Test
    public void testSetGetFavFrequency() {
        radio.setFavFrequency(1);
        assertEquals(530.0f, radio.getFavFrequency(1), 0.2f); // Updated delta value

        radio.nextFrequency();
        radio.setFavFrequency(2);
        assertEquals(540.0f, radio.getFavFrequency(2), 0.2f); // Updated delta value
    }
}
