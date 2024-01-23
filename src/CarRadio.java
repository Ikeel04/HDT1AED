public class CarRadio implements IRadio {

    private boolean state;
    private boolean AMFMState;
    private float[] favFrequencies;
    private float currentFrequency;
    private final float AM_MIN_FREQUENCY = 530.0f;
    private final float AM_MAX_FREQUENCY = 1610.0f;
    private final float FM_MIN_FREQUENCY = 87.9f;
    private final float FM_MAX_FREQUENCY = 107.9f;

    public CarRadio() {
        state = false;
        AMFMState = true; // Default to AM mode
        currentFrequency = AM_MIN_FREQUENCY; // Default frequency
        favFrequencies = new float[12]; // Buttons amount
    }

    @Override
    public boolean getState() {
        return state;
    }

    @Override
    public void tooglePowerOffOn() {
        state = !state;
    }

    @Override
    public boolean getStateAMFM() {
        return AMFMState;
    }

    @Override
    public void nextFrequency() {
        currentFrequency += (AMFMState && currentFrequency < AM_MAX_FREQUENCY) ? 10.0f : 0.2f;
        if (AMFMState && currentFrequency > FM_MAX_FREQUENCY) {
            currentFrequency = AM_MIN_FREQUENCY;
        }
    }

    @Override
    public void previousFrequency() {
        currentFrequency -= (AMFMState && currentFrequency > AM_MIN_FREQUENCY) ? 10.0f : 0.2f;
        if (AMFMState && currentFrequency < AM_MIN_FREQUENCY) {
            currentFrequency = FM_MAX_FREQUENCY;
        }
    }

    @Override
    public float getCurrentFrequency() {
        return currentFrequency;
    }

    @Override
    public void setFavFrequency(int button) {
        favFrequencies[button - 1] = currentFrequency;
    }

    @Override
    public float getFavFrequency(int button) {
        return (button >= 1 && button <= 12) ? favFrequencies[button - 1] : 0.0f;
    }

    @Override
    public void toogleAMFM() {
        AMFMState = !AMFMState;
    }
}
