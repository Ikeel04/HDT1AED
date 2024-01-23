public class CarRadio implements IRadio {

    private boolean state;
    private boolean AMFMState;
    private float[] favFrequencies;
    private float currentAM;
    private float currentFM;

    public CarRadio() {
        state = false;
        AMFMState = true; // Default to AM mode
        currentAM = 530.0f; // AM default value
        currentFM = 87.9f; // FM default value
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
        if (AMFMState == false && currentFM < 107.9f) {
            currentFM += 0.2f;

        } else if (AMFMState == false && currentFM >= 107.9f) {
            currentFM = 87.9f;
        }

        if (AMFMState == true && currentAM < 1610.0f) {
            currentAM += 10.0f;
        } else if (AMFMState == true && currentAM >= 1610.0f) {
            currentAM = 530.0f;
        }
    }

    @Override
    public void previousFrequency() {
        if (AMFMState == false && currentFM < 107.9f) {
            currentFM -= 0.2f;

        } else if (AMFMState == false && currentFM >= 107.9f) {
            currentFM = 87.9f;
        }

        if (AMFMState == true && currentAM < 530.0f) {
            currentAM -= 10f;
        } else if (AMFMState == true && currentAM >= 530.0f) {
            currentAM = 1610.0f;
        }
    }

    @Override
    public float getCurrentFrequency() {
        if (AMFMState = true) {
            return currentAM;
        } else {
            return currentFM;
        }
    }

    @Override
    public void setFavFrequency(int button) {
        if (AMFMState == true)
            favFrequencies[button - 1] = currentAM;
        else
            favFrequencies[button - 1] = currentFM;
    }

    @Override
    public float getFavFrequency(int button) {
        if (button >= 1 && button <= 12) {
            return favFrequencies[button - 1];
        } else {
            return 0.0f;
        }
    }

    @Override
    public void toogleAMFM() {
        AMFMState = !AMFMState;
    }
}
