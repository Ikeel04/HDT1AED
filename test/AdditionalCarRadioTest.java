import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdditionalCarRadioTest {

    IRadio radio = new CarRadio();

    @Test
    public void testRadioInitialState() {
        assertFalse(radio.getState());
        assertTrue(radio.getStateAMFM());
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f);
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
        assertEquals(false, radio.getStateAMFM());
    }

    @Test
    public void testNextFrequency() {
        radio.nextFrequency();
        assertEquals(560.0f, radio.getCurrentFrequency(), 0.2f);
    }

    @Test
    public void testPreviousFrequency() {
        radio.previousFrequency();
        assertEquals(550.0f, radio.getCurrentFrequency(), 0.2f);
    }

    @Test
    public void testSetGetFavFrequency() {
        radio.setFavFrequency(1);
        assertEquals(530.0f, radio.getFavFrequency(1), 0.2f);

        radio.nextFrequency();
        radio.setFavFrequency(2);
        assertEquals(560.0f, radio.getFavFrequency(2), 0.2f);
    }
}
