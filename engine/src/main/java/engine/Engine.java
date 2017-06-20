package engine;

import dao.IMap;
import world.IWorld;

import javax.swing.*;
import java.util.Collection;

public class Engine extends JPanel{
    public void loadWorld(IWorld world){
        Collection<JComponent> components = world.getComponents();

        for (JComponent component: components){
            this.add(component);
        }
    }
}
