package world.elements;

import world.Dimension;
import world.Position;
import world.Permeability;

import javax.swing.*;

public abstract class Elements extends JComponent {
    private Position position;
    private Dimension dimension;
    private String sprite;
    private Permeability permeability;

    public Elements(Position position, Permeability permeability){
        this.position = position;
        this.dimension = dimension;
        this.sprite = sprite;
        this.permeability = permeability;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Permeability getPermeability() {
        return permeability;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
