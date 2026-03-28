package cz.cvut.fel.omo.model.house;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.devices.Sensor;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;


/**
 * This class represents Room.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Room {

    private List<Device> devices;
    private List<Equipment> equipments;
    private List<Sensor> sensors;
    private List<Window> windows;
    private final String name;
    private Floor floor;

    private double currentWaterConsumption;
    private double currentElectricityConsumption;

    /**
     * Creates new Romm with given name.
     * @param name String
     **/
    public Room(String name) {
        this.name = name;
        devices = new ArrayList<>();
        equipments = new ArrayList<>();
        sensors = new ArrayList<>();
        windows = new ArrayList<>();
    }


    /**
     * This method accepts visitor.
     * @param visitor Visitor
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }


    /**
     * This method adds window.
     * @param window Window
     */
    public void addWindow(Window window) {windows.add(window);}



    public List<Window> getWindows() {
        return windows;
    }

    /**
     * This method adds sensor.
     * @param sensor Sensor
     */
    public void addSensor(Sensor sensor){
        sensors.add(sensor);
    }



    public List<Sensor> getSensors(){
        return sensors;
    }

    /**
     * This method adds device.
     * @param device Device
     */
    public void addDevice(Device device){
        devices.add(device);
    }


    /**
     * This method returns devices.
     * @return List<Device> devices
     */
    public List<Device> getDevices(){
        return devices;
    }

    /**
     * This method returns name of room.
     * @return String name
     */
    public String getName() { return name; }

    /**
     * This method sets floor.
     * @param  floor Floor
     */
    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    /**
     * This method returns floor.
     * @return Floor floor
     */
    public Floor getFloor() {
        return floor;
    }


    /**
     * This method returns current water consumption.
     *
     * @return double
     */
    public double getCurrentWaterConsumption() {
        return currentWaterConsumption;
    }


    /**
     * This method sets current water consumption.
     *
     * @param currentWaterConsumption double
     */
    public void setCurrentWaterConsumption(double currentWaterConsumption) {
        this.currentWaterConsumption = currentWaterConsumption;
    }


    /**
     * This method returns current electricity consumption.
     *
     * @return double
     */
    public double getCurrentElectricityConsumption() {
        return currentElectricityConsumption;
    }


    /**
     * This method sets current electricity consumption.
     *
     * @param currentElectricityConsumption double
     */
    public void setCurrentElectricityConsumption(double currentElectricityConsumption) {
        this.currentElectricityConsumption = currentElectricityConsumption;
    }

}
