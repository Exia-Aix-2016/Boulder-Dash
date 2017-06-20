package world.elements;

import world.Permeability;
import world.Position;

import javax.swing.*;
import java.awt.*;

public abstract class Elements extends JComponent {

    private Position position;
    private String sprite;
    private Permeability permeability;

    public Elements(Position position, final Dimension dimension, final String sprite,  Permeability permeability){
        this.sprite = sprite;
        this.permeability = permeability;
        this.position = position;

        this.setPreferredSize(dimension);
        this.setSize(dimension);

        this.updateBounds();
    }

    public Permeability getPermeability() {
        return permeability;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.updateBounds();
    }

    private void updateBounds(){
        Rectangle bounds = new Rectangle(this.position.getX(), this.position.getY(), this.getSize().width, this.getSize().height);
        this.setBounds(bounds);
        System.out.println("define bounds");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(this.getBackground());

        Rectangle rec = this.getBounds();
        System.out.println("draw " + rec + g.getColor());

        g.fillRect(0, 0, rec.width, rec.height);
    }
}
