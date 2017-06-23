package world.elements;


import world.elements.entity.StateType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Allow to manage the state entity each entity has a StateManager
 * @see StateType
 * @see world.elements.entity.State
 * */
public class SpriteManager {


    private StateSprite rest;
    private StateSprite up;
    private StateSprite down;
    private StateSprite left;
    private StateSprite right;

    public SpriteManager(String[] rest, String[] up, String[] down, String[] left, String[] right){
        this.rest = new StateSprite(rest);
        this.up = new StateSprite(up);
        this.down = new StateSprite(down);
        this.right = new StateSprite(right);
        this.left = new StateSprite(left);
    }

    public SpriteManager(String[] rest){
        this(rest, new String[]{}, new String[]{}, new String[]{}, new String[]{});
    }

    public SpriteManager(String rest){
        this(new String[]{rest}, new String[]{}, new String[]{}, new String[]{}, new String[]{});
    }

    public SpriteManager(String rest, String up, String down, String left, String right){
        this(new String[]{rest}, new String[]{up}, new String[]{down}, new String[]{left}, new String[]{right});
    }


    /**
     * @return the image of entity's state
     * */
    public Image getImage(){
        return this.rest.getImage();
    }

    /**
     * @return the image with an StateType
     * @see StateType
     * */
    public Image getImage(StateType state){
        switch (state){

            case UP:
                return this.up.isEmpty() ? this.rest.getImage() : this.up.getImage();
            case DOWN:
                return this.down.isEmpty() ? this.rest.getImage() : this.down.getImage();
            case LEFT:
                return this.left.isEmpty() ? this.rest.getImage() : this.left.getImage();
            case RIGHT:
                return this.right.isEmpty() ? this.rest.getImage() : this.right.getImage();
            case WAITING:
                return this.rest.getImage();
        }
        return null;
    }

    /**
     * Each state has a Sprite for each entity
     * */
    private class StateSprite {

        private ArrayList<Image> images = new ArrayList<>();
        private Iterator<Image> iterator;

        StateSprite(String[] imageNames){
            try {
                for (String imageName: imageNames){
                    this.images.add(ImageIO.read(this.getClass().getResource(imageName)));
                }
            } catch (Exception e){
                System.err.println(e);
                System.exit(1);
            }
            this.iterator = this.images.iterator();
        }

        /**
         * @return Image
         * @see Image
         * */
        Image getImage(){

            if (!this.iterator.hasNext()){
                this.iterator = this.images.iterator();
            }

            return this.iterator.next();
        }

        boolean isEmpty(){
            return this.images.isEmpty();
        }

    }

}
