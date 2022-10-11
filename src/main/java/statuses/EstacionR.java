package statuses;
import utils.*;

import org.json.simple.JSONArray;
import java.io.IOException;
import org.json.simple.*;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.time.LocalDate;
import org.json.simple.parser.*;
import java.io.FileReader;
import java.util.ArrayList;


public class EstacionR {

    private int solMin;
    private int solMax;
    private int lluviaMin;
    private int lluviaMax;
    private int duracion;
    private int cantLluvia;
    private String estacionesUrl;
    private JSONObject estacionInfo;
    private String nombreEstacion;
    private LocalDate fecha_incio;
    private LocalDate fecha_fin;

    public JSONObject getEstacionInfo() {
        return estacionInfo;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public LocalDate getFecha_incio() {
        return fecha_incio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public EstacionR(JSONObject pEstacionInfo){
        this.estacionInfo = pEstacionInfo;
        this.solMin =(int)(long) pEstacionInfo.get("solmin");
        this.solMax =(int)(long) pEstacionInfo.get("solmax");
        this.lluviaMin =(int)(long) pEstacionInfo.get("lluviamin");
        this.lluviaMax =(int)(long) pEstacionInfo.get("lluviamax");
        //this.cantLluvia =(int)(long) pEstacionInfo.get("cantidadLluvia");
        this.nombreEstacion = (String) pEstacionInfo.get("nombreEstacion");
        this.duracion = (int) (long) pEstacionInfo.get("duracion");
        this.fecha_incio = LocalDate.parse((String) pEstacionInfo.get("fecha_inicio"));
        this.fecha_fin = LocalDate.parse((String) pEstacionInfo.get("fecha_fin"));

    }

    public int getSolMin() {
        return solMin;
    }

    public int getSolMax() {
        return solMax;
    }

    public int getLluviaMin() {
        return lluviaMin;
    }

    public int getLluviaMax() {
        return lluviaMax;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getCantLluvia() {
        return cantLluvia;
    }

    public String getEstacionesUrl() {
        return estacionesUrl;
    }





}
