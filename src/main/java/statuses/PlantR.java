package statuses;

//import PlantasEstados.ReglaCambioEstado;
import org.json.simple.JSONArray;

import org.json.simple.*;

import java.util.ArrayList;

public class PlantR{
    private String nombrePlantaR;
    private int vitalidadPlanta;//vida
    private int velocidadCrecimiento;
    private int idEstado;
    private String fotoUrl;
    private int plantType;
    private int efecto;
    private String EstadoActual;
    private String plantasUrl;
    private JSONArray plantas;
    private JSONArray estados;
    private StatusChangeRule reglas;//[]
    private ArrayList<StatusChangeRule> reglasPlanta;


    public int getVitalidadPlantaR(){
        return this.vitalidadPlanta;
    }

    public int getVelocidadCrecimiento(){
        return this.velocidadCrecimiento;
    }

    public int getIdEstado(){
        return this.idEstado;
    }
    public PlantR(JSONArray pInfoEstados){
        this.idEstado = 0;
        this.estados = pInfoEstados;
        this.EstadoActual = (String) ((JSONObject) (this.estados.get(idEstado)) ).get("nombreEstado");
        this.reglasPlanta = new ArrayList<StatusChangeRule>();
        for(int i = 0; i < pInfoEstados.size();i++) {
            this.reglasPlanta.add(new StatusChangeRule((JSONObject) pInfoEstados.get(i)));
        }

    }

    public ArrayList getReglasPlanta(){
        return this.reglasPlanta;
    }

    public void setPlantaTipo(int pType){//Se cambian los atributos de la planta de acuerdo a su tipo
        pType -= 1;
        for(int i = 0; i < this.plantas.size(); i++){
            if(i == pType)
            {
                JSONObject infoPlanta = (JSONObject) this.plantas.get(pType);
                this.nombrePlantaR = (String) infoPlanta.get("nombrePlanta");
                this.vitalidadPlanta = (int) (long) infoPlanta.get("Vitalidad");
                this.velocidadCrecimiento = (int) (long) infoPlanta.get("velocidadCrecimiento");
                this.estados = (JSONArray) infoPlanta.get("Estados");
            }
        }
    }

    public void setEstadoActual(int pType){//Se envia el indice correspondiente del estado
        this.idEstado = pType;
        this.EstadoActual = (String) ((JSONObject) (this.estados.get(pType)) ).get("nombreEstado");
    }


    public String getInfoEstado(){
        return this.EstadoActual;
    }

    public String getNombrePlantaR() {
        return nombrePlantaR;
    }



}
