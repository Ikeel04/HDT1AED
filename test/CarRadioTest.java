import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarRadioTest {

    /**
     *
     */
    IRadio radio = new CarRadio();

    /**
     * Prueba el estado inicial de la radio.
     *
     */
    @Test
    public void testRadioInitialState() {
        assertFalse(radio.getState());
        assertTrue(radio.getStateAMFM());
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f); // Updated delta value
    }

    /**
     * Prueba para alternar el encendido y apagado de la radio.
     */
    @Test
    public void testTogglePower() {
        radio.tooglePowerOffOn();
        assertTrue(radio.getState());

        radio.tooglePowerOffOn();
        assertFalse(radio.getState());
    }

    /**
     * Una prueba para alternar entre los modos de radio AM y FM.
     */
    @Test
    public void testToggleAMFM() {
        radio.toogleAMFM();
        assertFalse(radio.getStateAMFM()); // Updated expected value
    }

    /**
     * Prueba del método de siguiente frecuencia.
     */
    @Test
    public void testNextFrequency() {
        radio.nextFrequency();
        assertEquals(540.0f, radio.getCurrentFrequency(), 0.2f); // Updated delta value
    }

    /**
     * Prueba la funcionalidad de frecuencia anterior.
     */
    @Test
    public void testPreviousFrequency() {
        radio.previousFrequency();
        assertEquals(1610.0f, radio.getCurrentFrequency(), 0.2f); // Updated expected value and delta
    }

    /**
     * Prueba para establecer y obtener la frecuencia favorita.
     */
    @Test
    public void testSetGetFavFrequency() {
        radio.setFavFrequency(1);
        assertEquals(530.0f, radio.getFavFrequency(1), 0.2f); // Updated delta value

        radio.nextFrequency();
        radio.setFavFrequency(2);
        assertEquals(540.0f, radio.getFavFrequency(2), 0.2f); // Updated delta value
    }
}
