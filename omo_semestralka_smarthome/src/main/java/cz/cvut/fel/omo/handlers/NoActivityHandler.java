package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.house.Floor;
import cz.cvut.fel.omo.model.house.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * This class represents handler for no activity.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class NoActivityHandler extends AbstractHandler {

    private static final Logger LOG = LoggerFactory.getLogger(NoActivityHandler.class);


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
        Person person = event.getResponsiblePerson();
        person.setRoom(changeRoom(event));
        LOG.info("{} is waiting in the " + person.getRoom().getName() + ".", person.getName());
    }

    public Room changeRoom(Event event) {

        List<Floor> floors = event.getHouse().getFloors();
        Collections.shuffle(floors);
        Floor floor = floors.get(0);

        List<Room> rooms = floor.getRooms();
        Collections.shuffle(rooms);
        return rooms.get(0);
    }
}
