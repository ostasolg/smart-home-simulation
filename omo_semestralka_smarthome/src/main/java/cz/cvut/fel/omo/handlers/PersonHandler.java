package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;
import cz.cvut.fel.omo.model.family.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents handler for person.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class PersonHandler extends AbstractHandler {

    private static final Logger LOG = LoggerFactory.getLogger(PersonHandler.class);


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

        if (event.getResponsibleEquipment() == null && event.getResponsibleDevice() != null) {
            person.setRoom(event.getResponsibleDevice().getRoom());
        }

        if (event.getChild() != null || event.getPet() != null) {

            if (event.getChild() != null) {
                LOG.info("{} did actions: be fed by " + person.getName() + ".", event.getChild().getName());
            }
            if (event.getPet() != null) {
                LOG.info("{} did actions: be fed by " + person.getName() + ".", event.getPet().getName());
            }
        }
        LOG.info("{} did actions: " + event.getWhatToDo(), person.getName());
    }
}
