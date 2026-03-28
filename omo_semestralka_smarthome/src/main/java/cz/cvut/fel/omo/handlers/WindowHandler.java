package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;

/**
 * This class represents handler for window.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class WindowHandler extends AbstractHandler {

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

        if (event.getWhatToDo().contains("Open all windows.")) {
            event.getHouse().getFloors().forEach(floor -> floor.getRooms().forEach(room ->
                    room.getWindows().forEach(window -> window.setOpened(true))));
        }

        if (event.getWhatToDo().contains("Close all windows.")) {
            event.getHouse().getFloors().forEach(floor -> floor.getRooms().forEach(room ->
                    room.getWindows().forEach(window -> window.setOpened(false))));
        }

        if (event.getWhatToDo().contains("Roll up all blinds.")) {
            event.getHouse().getFloors().forEach(floor -> floor.getRooms().forEach(room ->
                    room.getWindows().forEach(window -> window.getBlinds().setAreRolledUp(true))));
        }

        if (event.getWhatToDo().contains("Pull down all blinds.")) {
            event.getHouse().getFloors().forEach(floor -> floor.getRooms().forEach(room ->
                    room.getWindows().forEach(window -> window.getBlinds().setAreRolledUp(false))));
        }
    }
}
