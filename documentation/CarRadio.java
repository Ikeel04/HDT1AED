public class CarRadio implements IRadio {

    /**
     *
     */
    private boolean state;
    /**
     *
     */
    private boolean AMFMState;
    /**
     *
     */
    private float[] favFrequencies;
    /**
     *
     */
    private float currentFrequency;
    /**
     *
     */
    private final float AM_MIN_FREQUENCY = 530.0f;
    /**
     *
     */
    private final float AM_MAX_FREQUENCY = 1610.0f;
    /**
     *
     */
    private final float FM_MIN_FREQUENCY = 87.9f;
    /**
     *
     */
    private final float FM_MAX_FREQUENCY = 107.9f;

    /**
     * 
     */
    public CarRadio() {
        state = false;
        AMFMState = true; // Default to AM mode
        currentFrequency = AM_MIN_FREQUENCY; // Default frequency
        favFrequencies = new float[12]; // Buttons amount
    }

    /**
     * Obtiene el estado del objeto.
     *
     * @return         	el estado del objeto
     */
    @Override
    public boolean getState() {
        return state;
    }

    /**
     * Alterna el estado de encendido/apagado del objeto.
     *
     */
    @Override
    public void tooglePowerOffOn() {
        state = !state;
    }

    /**
     * Obtiene el estado de la radio AM/FM.
     *
     * @return          el estado de la radio AM/FM
     */

    @Override
    public boolean getStateAMFM() {
        return AMFMState;
    }

    /**
     * Método para actualizar la frecuencia en función del estado actual de AM/FM.
     *
     * @param  None
     * @return         	None
     */
    @Override
    public void nextFrequency() {
        if (AMFMState) {
            currentFrequency += 10.0f;
            if (currentFrequency > AM_MAX_FREQUENCY) {
                currentFrequency = AM_MIN_FREQUENCY;
            }
        } else {
            currentFrequency += 0.2f;
            if (currentFrequency > FM_MAX_FREQUENCY) {
                currentFrequency = FM_MIN_FREQUENCY;
            }
        }
    }

    /**
     * Disminuye la frecuencia actual basándose en el estado AMFM, y maneja el rebobinado
     * alrededor de las frecuencias mínimas y máximas tanto para las bandas AM como FM.
     */

    @Override
    public void previousFrequency() {
        if (AMFMState) {
            currentFrequency -= 10.0f;
            if (currentFrequency < AM_MIN_FREQUENCY) {
                currentFrequency = AM_MAX_FREQUENCY;
            }
        } else {
            currentFrequency -= 0.2f;
            if (currentFrequency < FM_MIN_FREQUENCY) {
                currentFrequency = FM_MAX_FREQUENCY;
            }
        }
    }

    /**
     * Obtiene la frecuencia actual.
     *
     * @return         	la frecuencia actual
     */
    @Override
    public float getCurrentFrequency() {
        return currentFrequency;
    }

    /**
     * Establece la frecuencia favorita para un botón dado.
     *
     * @param  button  el número de botón para el cual se está estableciendo la frecuencia favorita
     * @return        void
     */
    @Override
    public void setFavFrequency(int button) {
        favFrequencies[button - 1] = currentFrequency;
    }

    /**
     * Obtiene la frecuencia favorita para el botón dado.
     *
     * @param  button   el número de botón
     * @return          la frecuencia favorita para el botón, o 0.0f si el botón está fuera de rango
     */
    @Override
    public float getFavFrequency(int button) {
        return (button >= 1 && button <= 12) ? favFrequencies[button - 1] : 0.0f;
    }

    /**
     * Alterna el estado de AM/FM.
     */
    @Override
    public void toogleAMFM() {
        AMFMState = !AMFMState;
    }
}
