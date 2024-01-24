import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdditionalCarRadioTest {

    /**
     *
     */
    IRadio radio = new CarRadio();

    /**
     * Prueba para el estado inicial de la radio.
     */
    @Test
    public void testRadioInitialState() {
        assertFalse(radio.getState());
        assertTrue(radio.getStateAMFM());
        assertEquals(530.0f, radio.getCurrentFrequency(), 0.2f);
    }

    /**
     * Prueba la función de alternar encendido.
     *
     */    
    @Test
    public void testTogglePower() {
        radio.tooglePowerOffOn();
        assertTrue(radio.getState());
        radio.tooglePowerOffOn();
        assertFalse(radio.getState());
    }

    /**
     * Prueba la función toggleAMFM.
     *
     * @param  none
     * @return         	none
     */
    @Test
    public void testToggleAMFM() {
        radio.toogleAMFM();
        assertEquals(false, radio.getStateAMFM());
    }

    /**
     * Prueba el método nextFrequency de la radio.
     *
     * @param  void   Sin parámetros
     * @return       Sin valor de retorno
     */    
    @Test
    public void testNextFrequency() {
        radio.nextFrequency();
        assertEquals(540.0f, radio.getCurrentFrequency(), 0.2f);
    }

    /**
     * Prueba la función de frecuencia anterior.
     *
     * @param  void   Sin parámetros
     * @return       Sin valor de retorno
     */    
    @Test
    public void testPreviousFrequency() {
        radio.previousFrequency();
        assertEquals(1610.0f, radio.getCurrentFrequency(), 0.2f);
    }

    /**
     * Prueba para establecer y obtener la frecuencia favorita en la radio.
     */    
    @Test
    public void testSetGetFavFrequency() {
        radio.setFavFrequency(1);
        assertEquals(530.0f, radio.getFavFrequency(1), 0.2f);

        radio.nextFrequency();
        radio.setFavFrequency(2);
        assertEquals(540.0f, radio.getFavFrequency(2), 0.2f);
    }
}
