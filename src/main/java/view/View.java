package view;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer{

    private Model model;

    private Menu menu;

    public View(Model model){
        this.model = model;
        this.model.addObserver(this);

        this.menu = new Menu();

        System.out.println("configure frame");
        this.configureFrame();
    }

    private void configureFrame(){

        //this.getContentPane().setSize();

        this.setSize(800, 800);
        this.setTitle("Boulder Dash");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Dimension size = this.getSize();
        this.menu.setSize(size);

        this.setContentPane(this.menu);


        System.out.println("Ouverture de la fenetre");
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
