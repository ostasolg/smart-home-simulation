package cz.cvut.fel.omo.builders;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.Floor;
import cz.cvut.fel.omo.model.house.House;
import cz.cvut.fel.omo.model.house.Room;
import cz.cvut.fel.omo.model.house.Window;

/**
 * This class builds a new house instance.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class HouseBuilder {


    private House house;


    public HouseBuilder(){
        house = new House();
    }

    /**
     * Build new Room room on floor.
     * @param room room of the house
     * @param floorNumber floorNumber of house
     **/
    public HouseBuilder buildRoom(Room room, int floorNumber) {

        if (!doesFloorExist(floorNumber)) {
            throw new IllegalArgumentException("Floor with number " + floorNumber
                    + " does not exist!");
        }

        if (doesRoomExist(room.getName())) {
            throw new IllegalArgumentException("Room with name " + room.getName() + " already exists!");

        }
        Floor floor = house.getFloors().stream().filter(f -> f.getFloorNumber() == floorNumber).
                findFirst().get();

        floor.addRoom(room);
        room.setFloor(floor);
        return this;
    }

    /**
     * Build new Floor in house.
     * @param floor floor of the house
     **/
    public HouseBuilder buildFloor(Floor floor){

        if (doesFloorExist(floor.getFloorNumber())) {
            throw new IllegalArgumentException("Floor with number " + floor.getFloorNumber() + " already exists!");
        }
        house.addFloor(floor);
        return this;
    }

    /**
     * Build new Window in room.
     * @param roomName name of room
     * @param window window in house
     **/
    public HouseBuilder buildWindow(Window window, String roomName) {

        if (doesRoomExist(roomName)) {

            findRoomByName(roomName).addWindow(window);
            return this;
        }
        throw new IllegalArgumentException("Room with name " + roomName + " does not exist!");
    }



    /**
     * Add person to room.
     * @param person person in house
     * @param roomName name of room
     **/
    public HouseBuilder addPerson(Person person, String roomName){

        if (doesRoomExist(roomName)) {

            person.setRoom(findRoomByName(roomName));

            house.addMemberOfFamily(person);
            return this;

        }
        throw new IllegalArgumentException("Room with name - " + roomName + " - does not exist!");
    }

    /**
     * Add pet to house.
     * @param pet pet in house
     **/
    public HouseBuilder addPet(Pet pet) {
        house.addPet(pet);
        return this;
    }

    /**
     * Add device to room.
     * @param device device in house
     * @param roomName name of room
     **/
    public HouseBuilder addDevice(Device device, String roomName){
        if (doesRoomExist(roomName)) {
            Room room = findRoomByName(roomName);
            device.setRoom(room);
            room.addDevice(device);
            house.addDevice(device);

            return this;
        }
        throw new IllegalArgumentException("Room with name " + roomName + " does not exist!");
    }

    /**
     * Add equipment to house.
     * @param equipment in house
     **/
    public HouseBuilder addEquipment(Equipment equipment) {
        house.addEquipment(equipment);
        return this;
    }

    /**Returns whether the floor exists.
     * @param number int Number of floor in house
     * @return boolean of floor existence
     **/
    public boolean doesFloorExist(int number) {
        if(house.getFloors().stream().map(Floor::getFloorNumber).anyMatch(
                n -> n == number)) {
            return true;
        }
        return false;
    }

    /**Returns whether the room with declared name exists.
     * @param roomName name of room
     * @return boolean of room existence
     **/
    public boolean doesRoomExist(String roomName) {
        if (house.getFloors().stream().anyMatch(floor -> floor.getRooms().stream().anyMatch(
                room -> room.getName().equals(roomName)))) {
            return true;
        }
        return false;
    }

    /**Returns room.
     * @param roomName name of room
     * @return room found by name
     **/
    public Room findRoomByName(String roomName) {
        return house.getFloors().stream().filter(floor -> floor.getRooms().stream().anyMatch(
                r -> r.getName().equals(roomName))).findFirst().map(floor -> floor.getRooms().stream().filter(
                room1 -> room1.getName().equals(roomName)).findFirst().get()).get();
    }

    /**Returns house.
     * @return house
     **/
    public House build(){
        return house;
    }
}
