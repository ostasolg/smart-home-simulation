package cz.cvut.fel.omo.factory;

import cz.cvut.fel.omo.deviceStates.ActiveState;
import cz.cvut.fel.omo.deviceStates.IdleState;
import cz.cvut.fel.omo.deviceStates.OffState;
import cz.cvut.fel.omo.model.details.Consumption;
import cz.cvut.fel.omo.model.devices.*;

import java.util.List;
/**
 * This class is factory for devices.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class DeviceFactory {

    /**
     * Creates CofeeMaker with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public CoffeeMaker createCoffeeMaker(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new CoffeeMaker("CoffeeMaker", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE,
                waterPerIDLE), new IdleState(), "to make coffee");


    }
    /**
     * Creates Dishwasher with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public Dishwasher createDishwasher(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new Dishwasher("Dishwasher", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE,
                waterPerIDLE), new OffState(), "to wash the dishes");
    }

    /**
     * Creates Fridge with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public Fridge createFridge(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        Fridge fridge = new Fridge("Fridge", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE,
                waterPerIDLE), new ActiveState(), "to take food");

       List<String> foodForFridge = List.of("Eggs", "Juice", "Yoghurt", "Milk", "Soup", "Vegetables", "Apple", "Sausages",
                "Meat", "Fish", "Ice cream", "French fries", "Meat", "Fish", "Banana", "Pudding");

       for (var food : foodForFridge) {
           fridge.addFood(food);
       }

        return fridge;
    }

    /**
     * Creates Light with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public Light createLight(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new Light("Light", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE, waterPerIDLE),
                new OffState(), "to get light");
    }

    /**
     * Creates PC with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public PC createPC(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new PC("PC", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE, waterPerIDLE),
                new OffState(), "to be on PC");

    }

    /**
     * Creates Radio with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public Radio createRadio(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new Radio("Radio", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE, waterPerIDLE),
                new IdleState(), "to listen to music");

    }

    /**
     * Creates TV with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public TV createTV(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        TV tv = new TV("TV", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE, waterPerIDLE),
                new IdleState(), "to watch TV");
        tv.setProgrammes(List.of("Comedy", "Thriller", "Horror", "Documentary", "Musicals", "News", "Drama"));
        return tv;
    }

    /**
     * Creates VacuumCleaner with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public VacuumCleaner createVacuumCleaner(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new VacuumCleaner("VacuumCleaner", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE,
                waterPerIDLE), new OffState(), "to clean");

    }

    /**
     * Creates Washing Machine with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public WashingMachine createWashingMachine(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new WashingMachine("WashingMachine", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE,
                waterPerIDLE), new OffState(), "to wash clothes");
    }

    /**
     * Creates Sensor with given parameters.
     * @param elPerACTIVE Represents consumption of electricity in Active state
     * @param elPerIDLE Represents consumption of electricity in Idle state
     * @param waterPerACTIVE Represents consumption of water in Active state
     * @param waterPerIDLE Represents consumption of water in Idle state
     */
    public Sensor createSensor(int elPerACTIVE, int elPerIDLE, int waterPerACTIVE, int waterPerIDLE) {
        return new Sensor("Sensor", new Consumption(elPerACTIVE, elPerIDLE, waterPerACTIVE, waterPerIDLE),
                new IdleState(), "to check the weather");
    }
}
