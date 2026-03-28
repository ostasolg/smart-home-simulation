package cz.cvut.fel.omo.model.house;

import cz.cvut.fel.omo.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents Floor.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Floor {

    private final int floorNumber;
    private List<Room> rooms;
    private double currentWaterConsumption;
    private double currentElectricityConsumption;

    /**
     * Creates new floor with given number.
     * @param floorNumber int
     **/
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        rooms = new ArrayList<>();

        currentElectricityConsumption = 0;
        currentWaterConsumption = 0;
    }

    /**
     * This method accepts visitor.
     * @param visitor Visitor
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    /**
     * @return int returns number of floor.
     */
    public int getFloorNumber() {
        return floorNumber;
    }


    /**
     * This method sets rooms.
     * @param rooms List<Room>
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * This method returns rooms.
     * @return List<Room>  rooms
     */
    public List<Room> getRooms(){
        return rooms;
    }


    /**
     * This method adds room.
     * @param room Room
     */
    public void addRoom(Room room){
        rooms.add(room);
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
