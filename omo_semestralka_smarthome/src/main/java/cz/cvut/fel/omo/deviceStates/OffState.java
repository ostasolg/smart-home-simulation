package cz.cvut.fel.omo.deviceStates;

import cz.cvut.fel.omo.model.devices.Device;

/**
 * This class handles Off state.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class OffState implements DeviceState {



    /**
     * turns on device, changes state to IDLE.
     */
    @Override
    public void turnOn(Device device) {
        device.setDeviceState(new IdleState());
    }

    /**
     * This method does nothing for OffState.
     */
    @Override
    public void startUsing(Device device) {
        return;
    }

    /**
     * This method does nothing for OffState.
     */
    @Override
    public void stopUsing(Device device) {
        return;
    }

    /**
     * This method does nothing for OffState.
     */
    @Override
    public void turnOff(Device device) {
        return;
    }


    /**
     * This method does nothing for OffState.
     */
    @Override
    public void getBroken(Device device) {
        return;
    }


    /**
     * This method fixes device.
     */
    @Override
    public void getFixed(Device device) {
        device.readManual();
        device.setCondition(100);
    }

    /**
     * Returns string representation.
     */
    @Override
    public String toString() {
        return "OFF";
    }
}
