import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdditionalCarRadioTest {

    IRadio radio = new CarRadio();

    @Test
    public void testPowerToggleWhileChangingFrequency() {
        radio.tooglePowerOffOn();
        assertTrue(radio.getState());

        radio.nextFrequency();
        assertEquals(540.0f, radio.getCurrentFrequency(), 0.2f);

        radio.tooglePowerOffOn();
        assertFalse(radio.getState());
    }

    @Test
    public void testToggleAMFMWhilePowerOff() {
        radio.tooglePowerOffOn();
        assertFalse(radio.getState());

        radio.toogleAMFM();
        assertTrue(radio.getStateAMFM());
    }

    @Test
    public void testToggleAMFMWhileChangingFrequency() {
        radio.nextFrequency();
        assertEquals(540.0f, radio.getCurrentFrequency(), 0.2f);

        radio.toogleAMFM();
        assertFalse(radio.getStateAMFM());
        assertEquals(87.9f, radio.getCurrentFrequency(), 0.2f);
    }

    @Test
    public void testPreviousFrequencyAfterToggleAMFM() {
        radio.toogleAMFM();
        assertFalse(radio.getStateAMFM());

        radio.previousFrequency();
        assertEquals(1610.0f, radio.getCurrentFrequency(), 0.2f);
    }

    @Test
    public void testSetGetFavFrequencyAfterToggleAMFM() {
        radio.toogleAMFM();
        assertFalse(radio.getStateAMFM());

        radio.setFavFrequency(1);
        assertEquals(1610.0f, radio.getFavFrequency(1), 0.2f);
    }

    @Test
    public void testInvalidFavButtonNumber() {
        radio.setFavFrequency(0);
        assertEquals(0.0f, radio.getFavFrequency(0), 0.2f);
    }
}
