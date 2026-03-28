package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.details.Consumption;

/**
 * This class represents vacuum cleaner.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class VacuumCleaner extends Device {

    /**
     * Creates new Vacuum Cleaner with given name ,consumption and state.
     * @param name name of the device
     * @param consumption consumption of the device
     * @param deviceState state of device
     */
    public VacuumCleaner(String name, Consumption consumption, DeviceState deviceState, String descriptionOfAction) {
        super(deviceState, consumption, name, descriptionOfAction);
    }
}
