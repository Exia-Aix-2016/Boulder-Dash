package world.elements;

import engine.IEngine;
import world.IComponent;
import world.Permeability;
import world.Position;
import world.reaction.Reaction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
/**
 * TODO
 * */
public abstract class Elements extends JComponent implements IComponent, IAction {

    protected IEngine engine;
    protected String sprite;
    protected Permeability permeability;
    protected Position position;

    private BufferedImage image;

    protected Collection<Reaction> reactions = new ArrayList<>();
    /**
     * TODO
     * */
    public Elements(Position position, final Dimension dimension, final String sprite,  Permeability permeability){
        this.sprite = sprite;
        this.permeability = permeability;
        this.position = position;

        this.setPreferredSize(dimension);
        this.setSize(dimension);

        this.updateBounds();

        try {
            this.image = ImageIO.read((this.getClass().getResource(this.sprite)));
        } catch (IOException ex) {
        }
    }
    /**
     * TODO
     * */
    public Permeability getPermeability() {
        return permeability;
    }
    /**
     * TODO
     * */
    public Position getPosition() {
        return position;
    }
    /**
     * TODO
     * */
    public void setPosition(Position position) {
        this.position = position;
        this.updateBounds();
    }

    /**
     * TODO
     * */
    private void updateBounds(){
        Rectangle bounds = new Rectangle(this.position.getX(), this.position.getY(), this.getSize().width, this.getSize().height);
        this.setBounds(bounds);
    }

    @Override
    public boolean isReaction(Object from) {
        for (Reaction reaction: this.reactions){
            if (reaction.isReaction(from)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void performReaction(Object from, int ticks) {
        for (Reaction reaction: this.reactions){
            if (reaction.isReaction(from)){
                reaction.perform(from, ticks);
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(this.getBackground());
        Rectangle rec = this.getBounds();
        g.fillRect(0, 0, rec.width, rec.height);
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);

    }

    @Override
    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void explode() {

    }
}
