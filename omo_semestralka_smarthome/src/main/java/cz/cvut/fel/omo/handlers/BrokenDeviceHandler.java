package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;

/**
 * This class represents handler for broken device.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class BrokenDeviceHandler extends AbstractHandler{


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
        event.getResponsibleDevice().getFixed();

        if (event.getResponsibleDevice().getName().equals("Sensor") ||
                event.getResponsibleDevice().getName().equals("TV") ||
                event.getResponsibleDevice().getName().equals("Radio") ||
                event.getResponsibleDevice().getName().equals("CoffeeMaker")) {

            event.getResponsibleDevice().turnOn();
        }

        if (event.getResponsibleDevice().getName().equals("Fridge")) {

            event.getResponsibleDevice().turnOn();
            event.getResponsibleDevice().startUsing();
        }
    }
}
