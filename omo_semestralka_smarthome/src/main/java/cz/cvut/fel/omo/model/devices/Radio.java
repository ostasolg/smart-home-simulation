package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.details.Consumption;

/**
 * This class represents radio.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Radio extends Device {

    /**
     * Creates new Radio with given name ,consumption and state.
     * @param name name of the device
     * @param consumption consumption of the device
     * @param deviceState state of device
     */
    public Radio(String name, Consumption consumption, DeviceState deviceState, String descriptionOfAction) {
        super(deviceState, consumption, name, descriptionOfAction);
    }

    /**
     * Enum for styles of music.
     */
    public enum Genre {
        ROCK("ROCK"), JAZZ("JAZZ"), BLUES("BLUES"), HIPHOP("HIPHOP"), FOLK("FOLK"),
        POP("POP"), RAP("RAP"), COUNTRY("COUNTRY");

        private final String name;

        /**
         * Constructs genre type.
         */
        Genre(String name) {
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
