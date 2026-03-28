package cz.cvut.fel.omo.observers;

import cz.cvut.fel.omo.model.devices.Device;

/**
 * This class represents condition observer.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class ConditionObserver extends Observer {


    /**
     * Constructor for ConditionObserver.
     * @param device Device
     */
    public ConditionObserver(Device device) {
        super(device);
    }

    /**
     * This method updates device instance.
     */
    @Override
    public void update() {
        entity = (Device) entity;

        if (((Device) entity).getCondition() <= 0) {
            ((Device) entity).getBroken();
        }
    }
}
