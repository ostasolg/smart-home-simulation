package cz.cvut.fel.omo.model;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.House;
import cz.cvut.fel.omo.model.weather.Weather;

/**
 * This class represents Event.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Event {

    private String cause;
    private String whatToDo;

    private final Weather weather;
    private final House house;

    private Person responsiblePerson;
    private Device responsibleDevice;
    private Equipment responsibleEquipment;

    private Pet pet;
    private Person child;

    /**
     * Creates new Event.
     * @param weather Weather
     * @param house House
     **/
    public Event(Weather weather, House house) {
        this.weather = weather;
        this.house = house;
    }

    /**
     * Returns cause of event.
     * @return String
     */
    public String getCause() {
        return cause;
    }

    /**
     * Returns reaction to event.
     * @return String
     */
    public String getWhatToDo() {
        return whatToDo;
    }

    /**
     * This method sets what to do.
     * @param whatToDo String
     */
    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    /**
     * Returns weather.
     * @return Weather weather
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * Returns house.
     * @return House house
     */
    public House getHouse() {
        return house;
    }

    /**
     * This method sets cause.
     * @param cause String
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     * Returns person responsible for handlng event.
     * @return Person responsiblePerson
     */
    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    /**
     * This method sets person responsible for handling event.
     * @param responsiblePerson String
     */
    public void setResponsiblePerson(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    /**
     * Returns device used  for handling event.
     * @return Device responsibleDevice
     */
    public Device getResponsibleDevice() {
        return responsibleDevice;
    }

    /**
     * This method sets responsible device.
     * @param responsibleDevice Device
     */
    public void setResponsibleDevice(Device responsibleDevice) {
        this.responsibleDevice = responsibleDevice;
    }


    /**
     * Returns pet.
     * @return Pet pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * This method sets pet.
     * @param pet Pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * Returns child.
     * @return Child child
     */
    public Person getChild() {

        return child;
    }

    /**
     * This method sets child.
     * @param child Person
     */
    public void setChild(Person child) {
        this.child = child;
    }


    public Equipment getResponsibleEquipment() {
        return responsibleEquipment;
    }

    public void setResponsibleEquipment(Equipment responsibleEquipment) {
        this.responsibleEquipment = responsibleEquipment;
    }
}
