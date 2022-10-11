package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import garden.controllers.GardenMainFrameController;
public class GardenMainFrame extends JFrame{//Se hereda de JFrame
    private static final long serialVersionUID = 1L;
    private GardenMainFrameController controller;//El controlador del MVC

    //this variable and the override of the pudate method are to implement jav
    //private image offScreen;
    public GardenMainFrame(String pTitle, GardenMainFrameController pController){
        super(pTitle);//Se llama al constructor de JFrame pasando por parametro el titulo
        this.controller = pController;//frame ve al controller
        this.controller.setWindow(this);//controller ve al frame
        //Configuracion de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(0,0,1080,780);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setBackground(Color.white);//Color lib importada
        //this.initComponents();
        this.setVisible(true);
    }

    private void initComponents(){
    }
}
