import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarRadioExtendedTest {

    IRadio radio = new CarRadio();

    @Test
    public void testRadioTurnOnOff() {
        assertFalse(radio.getState());
        radio.tooglePowerOffOn();
        assertTrue(radio.getState());
        radio.tooglePowerOffOn();
        assertFalse(radio.getState());
    }

    @Test
    public void testToggleAMFMMode() {
        assertTrue(radio.getStateAMFM());
        radio.toogleAMFM();
        assertFalse(radio.getStateAMFM());
        radio.toogleAMFM();
        assertTrue(radio.getStateAMFM());
    }

    @Test
    public void testNextAndPreviousFrequency() {
        // Starting in AM mode
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f);

        // Test next frequency in AM
        radio.nextFrequency();
        assertEquals(540.0f, radio.getCurrentFrequency(), 0.2f);

        // Switch to FM mode
        radio.toogleAMFM();
        assertTrue(radio.getStateAMFM());

        // Test next frequency in FM
        radio.nextFrequency();
        assertEquals(88.1f, radio.getCurrentFrequency(), 0.2f);

        // Test previous frequency in FM
        radio.previousFrequency();
        assertEquals(87.9f, radio.getCurrentFrequency(), 0.2f);
    }

    @Test
    public void testSetAndGetFavFrequency() {
        // Save frequency in button 1
        radio.setFavFrequency(1);
        assertEquals(530.0f, radio.getFavFrequency(1), 0.2f);

        // Switch to FM mode and save frequency in button 2
        radio.toogleAMFM();
        radio.setFavFrequency(2);
        assertEquals(87.9f, radio.getFavFrequency(2), 0.2f);
    }

    @Test
    public void testTogglePowerWithFavoriteFrequency() {
        assertFalse(radio.getState());

        // Save frequency in button 3
        radio.setFavFrequency(3);
        assertEquals(530.0f, radio.getFavFrequency(3), 0.2f);

        // Turn on the radio and check if the saved frequency is still there
        radio.tooglePowerOffOn();
        assertTrue(radio.getState());
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f);
    }
}
