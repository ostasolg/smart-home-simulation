package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;
import cz.cvut.fel.omo.visitors.EventVisitor;

/**
 * This class represents handler for sensor.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class SensorHandler extends AbstractHandler {




    /**
     * Handles event.
     * @param event Event Represents event to be handled
     */
    @Override
    public void handleEvent(Event event) {

        if (event != null) {
            processEvent(event);
        }

        if (nextHandler != null) {
            nextHandler.handleEvent(event);
        }
    }

    /**
     * Processes event.
     * @param event Event Represents event to be processed
     */
    @Override
    public void processEvent (Event event) {

        PersonHandler personHandler = new PersonHandler();
        personHandler.setNextHandler(new WindowHandler());
        setNextHandler(personHandler);

        event.getResponsibleDevice().accept(new EventVisitor());
    }
}
