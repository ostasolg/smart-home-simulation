package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.AbstractEntity;
import cz.cvut.fel.omo.model.details.Consumption;
import cz.cvut.fel.omo.model.details.Manual;
import cz.cvut.fel.omo.model.house.Room;
import cz.cvut.fel.omo.utils.Constants;
import cz.cvut.fel.omo.visitors.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents abstract class for device.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public abstract class Device extends AbstractEntity implements DeviceOperationsApi {

    private static final Logger LOG = LoggerFactory.getLogger(Device.class);


    protected boolean isFree;
    protected Room room;
    protected DeviceState deviceState;
    protected int condition;
    protected int waterSummaryConsumption;
    protected int electricitySummaryConsumption;
    protected final Consumption consumption;
    protected final String name;
    protected final String descriptionOfAction;
    protected Manual manual;


    /**
     * Creates new Device with given name ,consumption and state.
     * @param deviceState state of device
     * @param consumption consumption of the device
     * @param name name of the device
     * @param descriptionOfAction description of action made on the device
     */
    protected Device(DeviceState deviceState, Consumption consumption, String name, String descriptionOfAction) {
        this.name = name;
        this.deviceState = deviceState;
        this.consumption = consumption;
        this.descriptionOfAction = descriptionOfAction;
        this.condition = 100;
        this.waterSummaryConsumption = 0;
        this.electricitySummaryConsumption = 0;
    }


    /**
     * This method accepts visitor.
     * @param visitor Visitor
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    /**
     * This method reads manual.
     */
    @Override
    public void readManual() {
        getManual();
    }

    /**
     * This method turns on device.
     */
    @Override
    public void turnOn() {
        LOG.info("Device {} in room {} was turned on and now is in Standby - mode.", this.getName(),
                this.getRoom().getName());
        deviceState.turnOn(this);
    }

    /**
     * This method starts using device.
     */
    @Override
    public void startUsing() {
        LOG.info("Device {} in room {} is being used right now.", this.getName(), this.getRoom().getName());
        deviceState.startUsing(this);
    }

    /**
     * This method stops using device.
     */
    @Override
    public void stopUsing() {
        LOG.info("Device {} in room {} stopped being used and is in Standby - mode.", this.getName(),
                this.getRoom().getName());
        deviceState.stopUsing(this);
    }

    /**
     * This method turns off device.
     */
    @Override
    public void turnOff() {
        LOG.info("Device {} in room {} was turned off.", this.getName(), this.getRoom().getName());
        deviceState.turnOff(this);
    }

    /**
     * This method gets device broken.
     */
    @Override
    public void getBroken() {
        LOG.info("Device {} in room {} was broken.", this.getName(), this.getRoom().getName());
        deviceState.getBroken(this);
    }

    /**
     * This method gets device fixed.
     */
    @Override
    public void getFixed() {
        LOG.info("Device {} in room {} was fixed.", this.getName(), this.getRoom().getName());
        deviceState.getFixed(this);
    }


    /**
     * This method returns manual.
     * @return manual Manual
     */
    public Manual getManual() {
        if (manual == null) {
            manual = new Manual();
            manual.setManual(Constants.RANDOM_STRING_FOR_DEVICE_MANUAL);
        }
        return manual;
    }

    public Room getRoom() {
        return room;
    }

    public String getName(){ return name; }

    public void setRoom(Room room) {
        this.room = room;
    }

    public DeviceState getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }


    public Consumption getConsumption() {
        return consumption;
    }

    public int getWaterSummaryConsumption() {
        return waterSummaryConsumption;
    }

    public int getElectricitySummaryConsumption() {
        return electricitySummaryConsumption;
    }

    public void setWaterSummaryConsumption(int waterSummaryConsumption) {
        this.waterSummaryConsumption = waterSummaryConsumption;
    }

    public void setElectricitySummaryConsumption(int electricitySummaryConsumption) {
        this.electricitySummaryConsumption = electricitySummaryConsumption;
    }

    public String getDescriptionOfAction() {
        return descriptionOfAction;
    }


    /**
     * This method returns true if device is free.
     * @return boolean isFree
     */
    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
