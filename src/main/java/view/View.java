package view;

import model.Model;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer{

    private Model model;

    public View(Model model){
        this.model = model;
        this.model.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
