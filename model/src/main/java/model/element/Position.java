package model.element;

public class Position {
    private int x;
    private int y;

    /**
     * add JavaDoc
     * */
    public Position(final int x, final int y){
        this.setX(x);
        this.setY(y);
    }

    //Mutateur
    /**
     * Set y position
     * @param y coordonate y.
     * */
    public void setY(int y) {
            this.y = y;
    }
    /**
     * Set x position
     * @param x coordonate x.
     * */
    public void setX(int x) {
            this.x = x;
    }

    //Assesseur

    /**
     * add JavaDoc
     * */
    public int getX() {
        return x;
    }
    /**
     * add JavaDoc
     * */
    public int getY() {
        return y;
    }
}
