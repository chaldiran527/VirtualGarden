package mainGarden;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import statuses.PlantStatus;
import statuses.StatusChangeRule;
import utils.IConstants;
import statuses.PlantR;


import java.util.*;


public class Plant implements IConstants {
    private String name;
    private int type;
    private PlantStatus currentState;
    private String estado;
    private int life;
    private int nivelAgua;
    private int nivelAbono;
    private int ageDays;
    private int idEstado;
//    private ArrayList<StatusChangeRule> reglas[];
    private ArrayList<StatusChangeRule> reglas;
    private JSONObject infoPlanta;
    private JSONArray infoEstados;
    private JSONObject infoEstadoActual;
    private int aguaClima;
    private int abonoClima;

    private PlantR reglasPlanta;
    public Plant(JSONObject pInfo){
        this.infoPlanta = pInfo;
        this.infoEstados = (JSONArray) pInfo.get("Estados");
        this.nivelAgua = 0;
        this.nivelAbono = 0;
        reglasPlanta = new PlantR(this.infoEstados);


        this.name = (String) pInfo.get("nombrePlanta");
        this.life = (int) (long) pInfo.get("Vitalidad");
        this.estado = reglasPlanta.getInfoEstado();
        this.reglas = reglasPlanta.getReglasPlanta();
        this.idEstado = 0;

    }





    public void agregarAbono(){
        if(this.nivelAbono >= this.reglas.get(idEstado).getMinFertilizer() && this.nivelAbono <= this.reglas.get(idEstado).getMaxFertilizer())
        {
            this.life += this.reglas.get(idEstado).getAbonoP();
        }
        else
        {
            this.life += this.reglas.get(idEstado).getAbonoN();
        }
    }

    public void setAguaClima(int pAgua){
        this.nivelAgua += pAgua;
    }

    public void setAbonoClima(int pAbono){
        this.nivelAbono += pAbono;
    }

    public void updateTemperature(int pTemperature){
    }

    public int getAguaClima() {
        return this.aguaClima;
    }

    public int getAbonoClima() {
        return this.abonoClima;
    }

    public void agregarAgua(){
        StatusChangeRule regla = this.reglas.get(idEstado);
        if(this.reglas.get(idEstado).getMinWater() <= this.nivelAgua && this.reglas.get(idEstado).getMaxWater() >= this.nivelAgua){
            this.life += regla.getAguaP();
        }
        else{
            this.life += regla.getAguaN();
        }
        this.nivelAgua -= (1+getAguaClima());
    }
    public void evaluate(int currentDays){
        this.ageDays++;
        agregarAbono();
        agregarAgua();
        System.out.println("Evaluando: "+this);
        if(this.reglas.get(idEstado).getMaxDays() <= this.ageDays && this.life >= this.reglas.get(idEstado).getMinLife())
        {
            if(this.idEstado<3){
                this.idEstado++;
                this.estado = this.reglas.get(idEstado).getNombreEstado();
            }

        }
        if(this.life < 0)
        {
            this.idEstado =3;
            this.estado = this.reglas.get(idEstado).getNombreEstado();
        }
    }

    public String toString()
    {

        return "Planta " + this.name + ". Estado: " + this.estado+ ". Vitalidad: " + this.life + ".";
    }


}
