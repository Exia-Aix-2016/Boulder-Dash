package Hud;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Info extends JLabel {

    private int info;


    public Info(final String name){
        this.init(0, name);
    }
    public Info(final String name, final int info){
        this.init(info, name);
    }

    private void init(final int info, final String name){
        this.info = info;
        this.setName(name);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.refresh();
    }


    private void refresh(){
        this.setText(this.getName() + " : " + this.info);
    }
    public void increment(){
        this.info++;
        this.refresh();
    }
    public void decrement(){
        this.info--;
        this.refresh();
    }

    public void set(int info) {
        this.info = info;
        this.refresh();
    }

    public int get() {
        return this.info;

    }
}
