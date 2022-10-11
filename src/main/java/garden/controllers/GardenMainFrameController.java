package garden.controllers;

import gui.GardenMainFrame;
import simulation.Simulator;
import statuses.StatusManager;

public class GardenMainFrameController {
    private GardenMainFrame controlledFrame;
    private Simulator simulador;
    private StatusManager status;
    private Simulator sim;
    /*Construcotr to link this controller to its window frame*/

    public GardenMainFrameController(StatusManager pStatus, Simulator pSim)
    {

    }

    public void setWindow(GardenMainFrame pFrame){
        this.controlledFrame = pFrame;
    }

    public void agregarPlanta(int pTipo){
        this.status.agregarPlanta(pTipo);
    }
}
