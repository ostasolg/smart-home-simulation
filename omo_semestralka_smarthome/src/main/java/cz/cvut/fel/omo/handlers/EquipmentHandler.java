package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents handler for equipment.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class EquipmentHandler extends AbstractHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EquipmentHandler.class);


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
        setNextHandler(personHandler);

        if (event.getResponsibleEquipment().getName().equals("Ski")) {
            event.setWhatToDo("take car and go skiing.");
        }
        if (event.getResponsibleEquipment().getName().equals("Bike")) {
            event.setWhatToDo("go cycling.");
        }
    }

}
