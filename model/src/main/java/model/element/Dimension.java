package model.element;

/**
 * Allow to set a height and width to a model
 * */
public class Dimension {

    private int width;
    private int height;

    /**
     * Constructor Dimension
     * @param height define heigh of model
     * @param width  define width of model
     * */
    public Dimension(final int width, final int height){
        this.width = width;
        this.height = height;
    }


    //Mutateur

    /**
     * Define Height
     * @param height Height of model
     * */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * Define widht
     * @param widht widht of model
     * */
    public void setWight(int width) {
        this.width = width;
    }

    //Assesseur


    /**
     * @return Height of model
     * */
    public int getHeight() {
        return height;
    }
    /**
     * @return width of model
     * */
    public int getWight() {
        return width;
    }
}
