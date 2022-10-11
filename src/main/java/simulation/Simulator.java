package simulation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import statuses.StatusManager;
import utils.*;

public class Simulator extends Observable implements Runnable, IConstants{
    private LocalTime startedTime;
    private boolean running = false;
    private StatusManager plantManager;//Instance
    private int currentRain;
    private int currentTemperature;
    private LocalTime weatherLastUpdate;
    private int dayPass;



    public Simulator(StatusManager pManager){
        this.plantManager = pManager;
    }

    @Override
    public void run() {
        startedTime = LocalTime.now();
        LocalDate currentTime;
        running = true;
        while(running){
            try{
                this.plantManager.evaluate(dayPass);
                System.out.println(dayPass + " dias transcurridos.\n");
                Thread.sleep(CHECK);
                dayPass = (int)ChronoUnit.MILLIS.between(startedTime, LocalTime.now()) / DIAS_MILIS;

                SimulatorReport report = new SimulatorReport();
                report.action = ACTUALIZAR_DIAS;
                report.days = dayPass;
                
                if(dayPass >= DIAS_ANIOS){
                    stop();
                }
                
                this.notifyObservers(report);

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void updateWeather(int pTemp, int pRain){
        this.currentTemperature = pTemp;
        this.currentRain = pRain;
        this.weatherLastUpdate = LocalTime.now();

        SimulatorReport report = new SimulatorReport();
        report.action = ACTUALIZAR_CLIMA;
        report.rain = pRain;
        report.temperature = pTemp;
        report.days = dayPass;

        this.notifyObservers(report);

    }

    public void stop(){
        running = false;
    }

}
