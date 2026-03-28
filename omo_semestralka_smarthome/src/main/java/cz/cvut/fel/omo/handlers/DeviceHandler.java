package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;
import cz.cvut.fel.omo.model.devices.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * This class represents handler for device.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class DeviceHandler extends AbstractHandler {

    private static final Logger LOG = LoggerFactory.getLogger(DeviceHandler.class);

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

        Random rand = new Random();
        setNextHandler(new PersonHandler());

        switch (event.getResponsibleDevice().getName()) {



            case "Dishwasher", "PC", "VacuumCleaner", "WashingMachine" -> {
                event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                        event.getResponsibleDevice().getDescriptionOfAction() + ".");
                break;
            }
            case "Fridge" -> {

                Fridge fridge = (Fridge) event.getResponsibleDevice();

                int randIndex = rand.nextInt(fridge.getContent().size());

                String randomFoodFromFridge = fridge.getContent().get(randIndex);

                if (event.getPet() != null) {
                    event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                            event.getResponsibleDevice().getDescriptionOfAction() + " " + randomFoodFromFridge + " " +
                            "to feed pet " + event.getPet().getName() + ".");
                }
                else if (event.getChild() != null) {
                    event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                            event.getResponsibleDevice().getDescriptionOfAction() + " " + randomFoodFromFridge + " " +
                            "to feed child " + event.getChild().getName() + ".");

                } else {

                    event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                            event.getResponsibleDevice().getDescriptionOfAction() + " " + randomFoodFromFridge +
                            " to eat.");

                }
                fridge.removeFood(randomFoodFromFridge);
                break;
            }

            case "Light" -> {

                Light light = (Light) event.getResponsibleDevice();

                Light.Colour[] values = Light.Colour.values();
                int length = values.length;
                int randIndex = rand.nextInt(length);

                String randomColourOfLight = values[randIndex].toString();

                event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                        event.getResponsibleDevice().getDescriptionOfAction() + " of colour - " + randomColourOfLight +
                        ".");
                break;
            }

            case "CoffeeMaker" -> {

                CoffeeMaker coffeeMaker = (CoffeeMaker) event.getResponsibleDevice();

                CoffeeMaker.TypeOfCoffee[] values = CoffeeMaker.TypeOfCoffee.values();
                int length = values.length;
                int randIndex = rand.nextInt(length);

                String randomTypeOfCoffee = values[randIndex].toString();

                event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                        event.getResponsibleDevice().getDescriptionOfAction() + " - " + randomTypeOfCoffee + ".");
                break;
            }

            case "TV" -> {

                TV tv = (TV) event.getResponsibleDevice();

                int randIndex = rand.nextInt(tv.getProgrammes().size());

                String randomTVProgram = tv.getProgrammes().get(randIndex);

                event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                        event.getResponsibleDevice().getDescriptionOfAction() + " program - " + randomTVProgram + ".");
                break;
            }

            case "Radio" -> {

                Radio radio = (Radio) event.getResponsibleDevice();

                Radio.Genre[] values = Radio.Genre.values();
                int length = values.length;
                int randIndex = rand.nextInt(length);

                String randomGenreOfMusic = values[randIndex].toString();

                event.setWhatToDo("Use device " + event.getResponsibleDevice().getName() + " " +
                        event.getResponsibleDevice().getDescriptionOfAction() + " of genre - " + randomGenreOfMusic +
                        ".");
                break;
            }
        }
    }
}
