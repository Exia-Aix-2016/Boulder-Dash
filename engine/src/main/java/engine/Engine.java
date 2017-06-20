package engine;

import world.IWorld;

import javax.swing.*;
import java.util.Collection;

public class Engine extends JPanel{

    IWorld world;

    public Engine(){
        this.setLayout(null);
    }

    public void loadWorld(IWorld world){
        this.world = world;

        this.loadComponents();

        this.revalidate();
        this.repaint();
    }

    private void loadComponents(){
        Collection<JComponent> components = world.getComponents();

        for (JComponent component: components){
            System.out.println(component);
            this.add(component);
        }
    }
}
