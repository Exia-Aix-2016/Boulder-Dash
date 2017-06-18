package controller.element;


import controller.TickListener;
import model.elements.Element;

public abstract class ElementController implements TickListener, Runnable {

    private Element element;

    ElementController(Element element){
        this.element = element;
    }

}
