public class CarRadio implements IRadio {

    private boolean state;
    private boolean AMFMState;
    private float currentFrequency;
    private float[] favFrequencies;

    public CarRadio() {
        state = false;
        AMFMState = true; // Default to AM mode
        currentFrequency = 530.0f; // Default to the minimum AM frequency
        favFrequencies = new float[12];
    }

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public void tooglePowerOffOn() {
        state = !state;
        if (!state) {
            // Radio is turned off, reset to default values
            AMFMState = true;
            currentFrequency = 530.0f;
        }
    }

    @Override
    public boolean getStateAMFM() {
        return AMFMState;
    }

    @Override
    public void nextFrequency() {
        currentFrequency += AMFMState ? 0.2f : 10.0f;
        if (AMFMState && currentFrequency > 107.9f) {
            currentFrequency = 87.9f;
        } else if (!AMFMState && currentFrequency > 1610.0f) {
            currentFrequency = 530.0f;
        }
    }

    @Override
    public void previousFrequency() {
        currentFrequency -= AMFMState ? 0.2f : 10.0f;
        if (AMFMState && currentFrequency < 87.9f) {
            currentFrequency = 107.9f;
        } else if (!AMFMState && currentFrequency < 530.0f) {
            currentFrequency = 1610.0f;
        }
    }

    @Override
    public float getCurrentFrequency() {
        return currentFrequency;
    }

    @Override
    public void setFavFrequency(int button) {
        if (button >= 1 && button <= 12) {
            favFrequencies[button - 1] = currentFrequency;
            // Ajustar la frecuencia guardada en modo AM
            if (!AMFMState) {
                favFrequencies[button - 1] -= 0.2f;
            }
        }
    }

    @Override
    public float getFavFrequency(int button) {
        if (button >= 1 && button <= 12) {
            return favFrequencies[button - 1];
        } else {
            // Devolver algún valor predeterminado si el botón no está en el rango válido
            return 0.0f;
        }
    }

    @Override
    public void toogleAMFM() {
        AMFMState = !AMFMState;
        currentFrequency = AMFMState ? 87.9f : 530.0f;
    }
}
