package view;

import model.Model;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer{

    private Model model;

    public View(Model model){
        this.model = model;
        this.model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
