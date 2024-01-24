public interface IRadio{
    
    /**
     * @return
     */
    public boolean getState(); //Retornamos el valor de si esta encendido o no

    /**
     * 
     */
    public void tooglePowerOffOn(); //Apagar y encender

    /**
     * 
     */
    public void toogleAMFM(); //FM o AM

    /**
     * @return
     */
    public boolean getStateAMFM(); //Obtener si esta en FM o AM

    /**
     * 
     */
    public void nextFrequency(); //Siguiente frecuencia

    /**
     * 
     */
    public void previousFrequency();//frecuencia previa

    /**
     * @return
     */
    public float getCurrentFrequency();//Obtener la frecuencia actual

    /**
     * @param button
     */
    public void setFavFrequency(int button); //Guarda frecuencia

    /**
     * @param button
     * @return
     */
    public float getFavFrequency(int button); //Llama frecuencia
}