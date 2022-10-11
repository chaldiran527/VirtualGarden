package mainGarden;

import simulation.Simulator;
import statuses.SeasonManager;
import statuses.StatusManager;

public class Program {

    public static void main(String[] args){
        StatusManager manager = new StatusManager();//Observable
        Simulator sim = new Simulator(manager);//Observer
        SeasonManager clima = new SeasonManager();

        sim.addObserver(manager);
        sim.addObserver(clima);

        Thread simThread = new Thread(sim);

        simThread.start();
        sim.updateWeather(50, 10);

    }
}
