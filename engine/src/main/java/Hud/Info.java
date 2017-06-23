package Hud;

import javax.swing.*;
import java.awt.*;

/**
 * The information is a element which give to player indication for its progression in game
 */
public class Info extends JLabel {

    private int info;
    /**
     * Info contructor
     * @param name Give the name which will be display
     * */
    public Info(final String name){
        this.init(0, name);
    }
    /**
     * Info Contructor
     * @param name Give the name which will be display
     * @param info the info whicj will be display
     * */
    public Info(final String name, final int info){
        this.init(info, name);
    }

    /**
     * allow to factorize the Constructor
     * */
    private void init(final int info, final String name){
        this.info = info;
        this.setName(name);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.refresh();
    }


    /**
     * Allow to refresh the display information
     * */
    private void refresh(){
        this.setText(this.getName() + " : " + this.info);
    }
    public void increment(){
        this.info++;
        this.refresh();
    }
    /**
     * Decrement the information
     * */
    public void decrement(){
        this.info--;
        this.refresh();
    }
    /**
     * Set a information
     * @param info information you want set
     * */
    public void set(int info) {
        this.info = info;
        this.refresh();
    }
    /**
     * add information It will be added with old information
     * @param info the information you want add
     * */
    public void add(int info){
        this.info += info;
        this.refresh();
    }
    /**
     * @return the information
     * */
    public int get() {
        return this.info;

    }
}
