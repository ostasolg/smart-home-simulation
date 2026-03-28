package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.details.Consumption;

/**
 * This class represents coffee maker.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class CoffeeMaker extends Device {

    /**
     * Creates new CofeeMaker with given name ,consumption and state.
     * @param name name of the device
     * @param consumption consumption of the device
     * @param deviceState state of device
     */
    public CoffeeMaker(String name, Consumption consumption, DeviceState deviceState, String descriptionOfAction) {
        super(deviceState, consumption, name, descriptionOfAction);
    }

    /**
     * Enum for types of coffee.
     */
    public enum TypeOfCoffee {
        LATTE("LATTE"), CAPPUCCINO("CAPPUCCINO"), AMERICANO("AMERICANO"), ESPRESSO("ESPRESSO");

        private final String name;

        TypeOfCoffee(String name) {
            this.name = name;
        }

        /**
         * Returns String representation.
         */
        @Override
        public String toString() {
            return name;
        }
    }
}
