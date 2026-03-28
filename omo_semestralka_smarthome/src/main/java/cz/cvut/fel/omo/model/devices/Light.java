package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.details.Consumption;

/**
 * This class represents Light.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Light extends Device {

    /**
     * Creates new Light with given name ,consumption and state.
     * @param name name of the device
     * @param consumption consumption of the device
     * @param deviceState state of device
     */
    public Light(String name, Consumption consumption, DeviceState deviceState, String descriptionOfAction) {
        super(deviceState, consumption, name, descriptionOfAction);
    }

    /**
     * Enum for colours of light.
     */
    public enum Colour {
        WHITE("WHITE"), RED("RED"), BLUE("BLUE"), GREEN("GREEN");

        private final String name;

        Colour(String name) {
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