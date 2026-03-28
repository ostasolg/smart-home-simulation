package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;

/**
 * This class is an abstract class for handling events.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public abstract class AbstractHandler {

    protected AbstractHandler nextHandler;



    /**
     * Handles event.
     * @param event Event Represents event to be handled
     */
    public void handleEvent(Event event) {

    }

    /**
     * Processes event.
     * @param event Event Represents event to be processed
     */
    public void processEvent (Event event) {

    }

    /**
     * This method sets next handler.
     * @param nextHandler represents handler
     */
    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
