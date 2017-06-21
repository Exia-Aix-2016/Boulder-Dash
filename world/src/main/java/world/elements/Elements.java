package world.elements;

import world.Permeability;
import world.Position;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;

public abstract class Elements extends JComponent implements IContact{

    private Position position;
    private String sprite;
    private Permeability permeability;

    private BufferedImage image;

    private String backgroudSprite;
    private BufferedImage backgroud;

    public Elements(Position position, final Dimension dimension, final String sprite,  Permeability permeability){
        this.sprite = sprite;
        this.permeability = permeability;
        this.position = position;

        this.setPreferredSize(dimension);
        this.setSize(dimension);

        this.updateBounds();

        try {
            this.image = ImageIO.read(new File(this.sprite));
        } catch (IOException ex) {
        }

        this.setOpaque(false);
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
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(this.getBackground());
        Rectangle rec = this.getBounds();
        g.fillRect(0, 0, rec.width, rec.height);
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);



    }



}
