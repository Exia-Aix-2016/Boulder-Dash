package Hud;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Mandel on 21/06/2017.
 */
public class Hud extends JPanel{

    private ArrayList<JPanel> elements;


    public Hud(){
        this.elements = new ArrayList<>();
    }
    @Override
    public void paintComponent(Graphics g) {

        //g.setColor(Color.YELLOW);
        //g.fillRect(0, 0, this.getWidth(), 100);

    }
}
