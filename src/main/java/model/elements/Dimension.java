package com.github.ExiaAixA1.model.element;

/**
 * Allow to set a height and width to a com.github.ExiaAixA1.model
 * */
public class Dimension {

    private int width;
    private int height;

    /**
     * Constructor Dimension
     * @param height define heigh of com.github.ExiaAixA1.model
     * @param width  define width of com.github.ExiaAixA1.model
     * */
    public Dimension(final int width, final int height){
        this.width = width;
        this.height = height;
    }


    //Mutateur

    /**
     * Define Height
     * @param height Height of com.github.ExiaAixA1.model
     * */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * Define widht
     * @param widht widht of com.github.ExiaAixA1.model
     * */
    public void setWight(int width) {
        this.width = width;
    }

    //Assesseur


    /**
     * @return Height of com.github.ExiaAixA1.model
     * */
    public int getHeight() {
        return height;
    }
    /**
     * @return width of com.github.ExiaAixA1.model
     * */
    public int getWight() {
        return width;
    }
}
