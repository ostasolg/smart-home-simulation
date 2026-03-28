package cz.cvut.fel.omo.deviceStates;

import cz.cvut.fel.omo.model.devices.Device;

public interface DeviceState {

    /**
     * This method does nothing for ActiveState.
     */
    public void turnOn(Device device);

    /**
     * This method does nothing for ActiveState.
     */
    public void startUsing(Device device);

    /**
     * stops using of device, changes state to IDLE.
     */
    public void stopUsing(Device device);

    /**
     * turns off device, changes state to Off.
     */
    public void turnOff(Device device);

    /**
     * This method breaks device.
     */
    public void getBroken(Device device);

    /**
     * This method fixes device.
     */
    public void getFixed(Device device);

    /**
     * Returns string representation.
     */
    public String toString();
}
