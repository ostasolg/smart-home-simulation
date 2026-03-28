package cz.cvut.fel.omo.deviceStates;

import cz.cvut.fel.omo.model.devices.Device;

/**
 * This class handles Idle state.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class IdleState implements DeviceState {



    /**
     * This method does nothing for IdleState.
     */
    @Override
    public void turnOn(Device device) {
        return;
    }

    /**
     * Starts using of device, changes state to Active.
     */

    @Override
    public void startUsing(Device device) {
        device.setDeviceState(new ActiveState());
    }

    /**
     * This method does nothing for IdleState.
     */
    @Override
    public void stopUsing(Device device) {
        return;
    }

    /**
     * Turns off device, changes state to Off.
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
        return "IDLE";
    }
}
