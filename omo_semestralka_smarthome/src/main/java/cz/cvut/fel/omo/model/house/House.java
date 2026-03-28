package cz.cvut.fel.omo.model.house;

import cz.cvut.fel.omo.model.AbstractEntity;
import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents House.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class House extends AbstractEntity {

    private List<Floor> floors;
    private List<Equipment> equipments;
    private List<Person> family;
    private List<Pet> pets;
    private List<Device> devices;

    private double currentWaterConsumption;
    private double currentElectricityConsumption;



    /**
     * Constructor of class House.
     */
    public House() {
        this.floors = new ArrayList<>();
        this.equipments = new ArrayList<>();
        this.family = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.devices = new ArrayList<>();

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
     * This method adds floor.
     * @param floor Floor
     */
    public void addFloor(Floor floor){
        floors.add(floor);
    }

    /**
     * This method adds device.
     * @param device Device
     */
    public void addDevice(Device device) {
        devices.add(device);
    }

    /**
     * This method adds equipment.
     * @param equipment Equipment
     */
    public void addEquipment(Equipment equipment){
        equipments.add(equipment);
    }




    /**
     * This method adds person to family.
     * @param person Person
     */
    public void addMemberOfFamily(Person person){ family.add(person); }


    /**
     * This method adds pet.
     * @param pet Pet
     */
    public void addPet(Pet pet) { pets.add(pet); }

    /**
     * @return List<Equipment> returns of equipments.
     */
    public List<Equipment> getEquipments(){
        return equipments;
    }

    /**
     * @return List<Floor>  returns of floors.
     */
    public List<Floor> getFloors() {
        return floors;
    }

    /**
     * @return List<Person>  returns of family members.
     */
    public List<Person> getFamily() {
        return family;
    }

    /**
     * @return List<Pet> returns  of pets.
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     * @return List<Device>  returns  of devices.
     */
    public List<Device> getDevices() {
        return devices;
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
     * This method sets current electricity consumption.
     *
     * @param currentElectricityConsumption double
     */
    public void setCurrentElectricityConsumption(double currentElectricityConsumption) {
        this.currentElectricityConsumption = currentElectricityConsumption;
    }
}
