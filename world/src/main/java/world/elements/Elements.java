package world.elements;

import engine.IEngine;
import world.IComponent;
import world.Position;
import world.reaction.Reaction;
import world.reaction.Sides;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
/**
 * TODO
 * */
public abstract class Elements extends JComponent implements IComponent, IAction {

    protected IEngine engine;
    protected Position position;

    private Image image;

    protected SpriteManager spriteManager;

    protected Collection<Reaction> reactions = new ArrayList<>();
    /**
     * TODO
     * */
    public Elements(Position position, final Dimension dimension, SpriteManager spriteManager){
        this.position = position;

        this.setPreferredSize(dimension);
        this.setSize(dimension);

        this.updateBounds();

        this.spriteManager = spriteManager;

        this.setImage(this.spriteManager.getImage());
    }

    public void setImage(Image image) {
        this.image = image;
        this.revalidate();
        this.repaint();
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
    public boolean isReaction(Object from, Sides side) {
        for (Reaction reaction: this.reactions){
            if (reaction.isReaction(from, side)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean performReaction(Object from, Sides side, int ticks) {
        for (Reaction reaction: this.reactions){
            if (reaction.isReaction(from, side)){
                return reaction.perform(from, side, ticks);
            }
        }
        return false;
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
    public void explode() {

    }
}
