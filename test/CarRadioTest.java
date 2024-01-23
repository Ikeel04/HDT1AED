import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarRadioTest {

    @org.junit.Test
    public void testRadioInitialState() {
        CarRadio radio = new CarRadio();

        assertFalse(radio.getState());
        assertTrue(radio.getStateAMFM());
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f);
    }

    @org.junit.Test
    public void testTogglePower() {
        CarRadio radio = new CarRadio();

        radio.tooglePowerOffOn();
        assertTrue(radio.getState());

        radio.tooglePowerOffOn();
        assertFalse(radio.getState());
    }

    @org.junit.Test
    public void testToggleAMFM() {
        CarRadio radio = new CarRadio();
        radio.toogleAMFM();
        assertFalse(radio.getStateAMFM());
        assertEquals(87.9f, radio.getCurrentFrequency(), 0.2f);
        radio.toogleAMFM();
        assertTrue(radio.getStateAMFM());
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f);
    }

    

    @org.junit.Test
    public void testNextPreviousFrequency() {
        CarRadio radio = new CarRadio();
    
        radio.nextFrequency();
        assertEquals(540.0f, radio.getCurrentFrequency(), 0.2f);
    
        radio.previousFrequency();
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f);
    }
    

    @org.junit.Test
    public void testSetGetFavFrequency() {
        CarRadio radio = new CarRadio();
    
        radio.setFavFrequency(1);
        assertEquals(530.0f, radio.getFavFrequency(1), 0.2f);
    
        radio.nextFrequency();
        radio.setFavFrequency(2);
        assertEquals(540.0f, radio.getFavFrequency(2), 0.2f);
    }
}
    
