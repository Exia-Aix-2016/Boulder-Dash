package engine.rendering;

import engine.Engine;
import world.IWorld;

import javax.swing.*;
import java.util.Collection;

public class RenderingEngine {

    private Engine engine;
    private JPanel panel;

    public RenderingEngine(Engine engine){
        engine = engine;
        panel = new JPanel();
    }

    public void loadWorld(IWorld world){
        Collection<JComponent> components = world.getComponents();

        for (JComponent component: components){
            panel.add(component);
        }
    }
}
