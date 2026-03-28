package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.details.Consumption;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents tv.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class  TV extends Device {

    private List<String> programmes;

    /**
     * Creates new TV with given name ,consumption and state.
     * @param name name of the device
     * @param consumption consumption of the device
     * @param deviceState state of device
     */
    public TV(String name, Consumption consumption, DeviceState deviceState, String descriptionOfAction) {
        super(deviceState, consumption, name, descriptionOfAction);
        programmes = new ArrayList<>();
    }

    public List<String> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(List<String> programs) {
        this.programmes = programs;
    }

}
