package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.details.Consumption;
import cz.cvut.fel.omo.visitors.Visitor;

/**
 * This class represents sensor.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Sensor extends Device{

    private boolean isAlarmActive;

    /**
     * Creates new Sensor with given name ,consumption and state.
     * @param name name of the device
     * @param consumption consumption of the device
     * @param deviceState state of device
     */
    public Sensor(String name, Consumption consumption, DeviceState deviceState, String descriptionOfAction) {
        super(deviceState, consumption, name, descriptionOfAction);
        isAlarmActive = false;
    }


    /**
     * This method accepts visitor.
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }



    /**
     * This method starts using.
     */
    @Override
    public void startUsing() {
        deviceState.startUsing(this);
        isAlarmActive = true;
    }

    /**
     * This method stops using device.
     */
    @Override
    public void stopUsing() {
        deviceState.stopUsing(this);
        isAlarmActive = false;
    }
}
