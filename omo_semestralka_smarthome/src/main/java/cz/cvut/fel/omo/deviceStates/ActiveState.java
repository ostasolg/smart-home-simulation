package cz.cvut.fel.omo.deviceStates;

import cz.cvut.fel.omo.model.devices.Device;

/**
 * This class handles Active state.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class ActiveState implements DeviceState {

    /**
     * This method does nothing for ActiveState.
     */
    @Override
    public void turnOn(Device device) {
        return;
    }

    /**
     * This method does nothing for ActiveState.
     */
    @Override
    public void startUsing(Device device) {
        return;
    }

    /**
     * stops using of device, changes state to IDLE.
     */
    @Override
    public void stopUsing(Device device) {
        device.setDeviceState(new IdleState());
    }

    /**
     * turns off device, changes state to Off.
     */
    @Override
    public void turnOff(Device device) {
        device.setDeviceState(new OffState());
    }


    /**
     * This method breaks device.
     */
    @Override
    public void getBroken(Device device) {
        device.setDeviceState(new OffState());
    }

    /**
     * This method fixes device.
     */
    @Override
    public void getFixed(Device device) {
        return;
    }

    /**
     * Returns string representation.
     */
    @Override
    public String toString() {
        return "ACTIVE";
    }
}
