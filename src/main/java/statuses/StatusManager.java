package statuses;

import java.util.ArrayList;

import mainGarden.Plant;
import simulation.SimulatorReport;
import utils.*;

import org.json.simple.JSONArray;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;

public class StatusManager implements IObserver,IConstants {
    private ArrayList<Plant> garden;
    private JSONArray plantasInfo;
    private String plantasUrl;
    public StatusManager(){
        JSONParser parser = new JSONParser();
        try
        {
            this.plantasUrl = "src/main/java/statuses/PlantaJson.json";
            Object obj = parser.parse(new FileReader(this.plantasUrl));

            JSONObject jsonObj = (JSONObject)obj;
            this.plantasInfo = (JSONArray) jsonObj.get("Plantas");

        }catch(IOException ex) {
            ex.printStackTrace();
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }
        garden = new ArrayList<Plant>();

        int i1 = 1;
        int i2 = 2;
        int i3 = 3;
        garden.add(new Plant((JSONObject) this.plantasInfo.get(i1-1)));
        garden.add(new Plant((JSONObject) this.plantasInfo.get(i2-1)));
        garden.add(new Plant((JSONObject) this.plantasInfo.get(i3-1)));
    }

    public void agregarPlanta(int pTipo){
        garden.add(new Plant((JSONObject) this.plantasInfo.get(pTipo-1)));
    }
    public void evaluate(int pCurrentDays){

        for(Plant currentPlant : garden){
            currentPlant.evaluate(pCurrentDays);
        }
    }

    //Update de la temperatura
    public void updateTemperature(int pCantDays, int pTemperature){
        for(Plant currentPlant : garden){
            currentPlant.setAguaClima(pTemperature);
        }
    }

    public void updateWater(int pCantDays, int pAgua){
        for(Plant currentPlant : garden){
           currentPlant.setAguaClima(pAgua);
        }
    }

    public void updateAbono(int pCantDays, int pAbono){
        for(Plant currentPlant : garden){
            currentPlant.setAbonoClima(pAbono);
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        SimulatorReport simReport = (SimulatorReport)arg;
        if(simReport.action.compareTo(ACTUALIZAR_DIAS) == 0){
            evaluate(simReport.days);
        }
        if(simReport.action.compareTo(ACTUALIZAR_CLIMA) == 0){
            updateTemperature(simReport.days, simReport.temperature);
            updateWater(simReport.days, simReport.rain);
        }
    }
}
