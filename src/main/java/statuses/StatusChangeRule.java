package statuses;

import org.json.simple.JSONObject;

public class StatusChangeRule {
    private int minLife;
    private int maxLife;
    private int minDays;
    private int maxDays;
    private int minWater;
    private int maxWater;
    private String nombreEstado;
    private int minFertilizer;
    private int maxFertilizer;
    private int abonoN;
    private int abonoP;
    private int aguaN;
    private int aguaP;
    private PlantStatus currentState; // si estoy en este estado y se cumple los valores en el rango de arriba paso sl siguiente estado
    private PlantStatus nextState;

    public StatusChangeRule(JSONObject pInfo){

        this.minLife = (int) (long) pInfo.get("minVida");
        this.minLife = (int) (long) pInfo.get("maxVida");
        this.minDays = (int) (long) pInfo.get("minDias");
        this.maxDays = (int) (long) pInfo.get("maxDias");
        this.minFertilizer = (int) (long) pInfo.get("minAbono");
        this.maxFertilizer = (int) (long) pInfo.get("maxAbono");
        this.nombreEstado = (String) pInfo.get("nombreEstado");
        this.minWater = (int) (long) pInfo.get("minAgua");
        this.maxWater = (int) (long) pInfo.get("maxAgua");
        this.aguaN = (int) (long) pInfo.get("efectoAN");
        this.aguaP = (int) (long) pInfo.get("efectoAP");
        this.abonoN = (int) (long) pInfo.get("efectoFN");
        this.abonoP = (int) (long) pInfo.get("efectoFP");
    }

    public String getNombreEstado(){
        return this.nombreEstado;
    }

    public int getMinWater() {
        return this.minWater;
    }

    public int getMaxWater() {
        return this.maxWater;
    }

    public int getAbonoN() {
        return this.abonoN;
    }

    public int getAbonoP() {
        return this.abonoP;
    }

    public int getAguaN() {
        return this.aguaN;
    }

    public int getAguaP() {
        return this.aguaP;
    }


    public void setMinFertilizer(int pminFertilizer){
        this.minFertilizer = pminFertilizer;
    }

    public void setMaxFertilizer(int pmaxFertilizer){
        this.maxFertilizer = pmaxFertilizer;
    }
    public void setMinWater(int pminWater){
        this.minWater = pminWater;
    }

    public void setMaxWater(int pmaxWater){
        this.maxWater = pmaxWater;
    }

    public int getMinFertilizer(){
        return this.minFertilizer;
    }

    public int getMaxFertilizer(){
        return this.maxFertilizer;
    }
    public int getMinLife() {
        return minLife;
    }
    public void setMinLife(int minLife) {
        this.minLife = minLife;
    }
    public int getMaxLife() {
        return maxLife;
    }
    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }
    public int getMinDays() {
        return minDays;
    }
    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }
    public int getMaxDays() {
        return maxDays;
    }
    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
    public PlantStatus getCurrentState() {
        return currentState;
    }
    public void setCurrentState(PlantStatus currentState) {
        this.currentState = currentState;
    }
    public PlantStatus getNextState() {
        return nextState;
    }
    public void setNextState(PlantStatus nextState) {
        this.nextState = nextState;
    }


}
