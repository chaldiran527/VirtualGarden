package statuses;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.IObserver;
import simulation.SimulatorReport;
import utils.*;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SeasonManager implements IObserver, IConstants{

    private ArrayList<EstacionR> estaciones;
    private StatusManager manager;
    private JSONArray estacionesInfo;
    private String estacionesUrl;
    private int diaActual;
    private int idEstacion;
    private int nivelLluvia;
    private int temperatura;


    public SeasonManager() {
        JSONParser parser = new JSONParser();
        try
        {
            this.estacionesUrl = "src/main/java/statuses/Estaciones.json";
            Object obj = parser.parse(new FileReader(this.estacionesUrl));

            JSONObject jsonObj = (JSONObject)obj;
            this.estacionesInfo= (JSONArray) jsonObj.get("Estaciones");

        }catch(IOException ex) {
            ex.printStackTrace();
        }catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.diaActual = 0;
        this.idEstacion = 0;//Indice para el ArrayList estaciones
        this.estaciones = new ArrayList<EstacionR>();
        for(int i = 0; i < this.estacionesInfo.size(); i++){
            this.estaciones.add(new EstacionR((JSONObject) this.estacionesInfo.get(i)));
        }
    }


    @Override
    public void update(Observable pObservable, Object args)
    {
        SimulatorReport simReport = (SimulatorReport)args;
        diaActual = simReport.days;
        if(this.diaActual%3 == 0)
        {
            EstacionR estacion = estaciones.get(idEstacion);
            if(this.diaActual < estacion.getDuracion() && this.diaActual < 3)
            {
                this.idEstacion++;
            }
            System.out.println("Estacion: " + estacion.getNombreEstacion());
            this.nivelLluvia = (int) (Math.random()*(estacion.getLluviaMax() - estacion.getLluviaMin())) + estacion.getLluviaMin();
            System.out.println("Nivel lluvia: " + this.nivelLluvia + " mm.");
            this.temperatura = (int) (Math.random()*(estacion.getSolMax() - estacion.getSolMin())) + estacion.getSolMin();
            updateWeather(nivelLluvia, temperatura);

        }

    }

    public void updateWeather(int pTemperatura, int pLluvia)
    {
        this.temperatura = pTemperatura;
        this.nivelLluvia = pLluvia;

        SimulatorReport report = new SimulatorReport();
        report.action = ACTUALIZAR_CLIMA;
        report.rain = pLluvia;
        report.temperature = pTemperatura;
    }
}
