package cz.cvut.fel.omo.controller;

import cz.cvut.fel.omo.handlers.*;
import cz.cvut.fel.omo.model.Event;
import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.devices.Fridge;
import cz.cvut.fel.omo.model.devices.Sensor;
import cz.cvut.fel.omo.model.equipments.Bike;
import cz.cvut.fel.omo.model.equipments.Car;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.equipments.Ski;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.PersonActivity;
import cz.cvut.fel.omo.model.family.PersonState;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.House;
import cz.cvut.fel.omo.model.weather.Weather;
import cz.cvut.fel.omo.runningConfig.RunningConfig;
import cz.cvut.fel.omo.visitors.EventVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class represents House controller.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class HouseController {


    private static final Logger LOG = LoggerFactory.getLogger(HouseController.class);

    private List<Event> events;
    private EventVisitor eventVisitor;
    private House house;
    private Weather weather;

    /**Constructor for class HouseController.
     * @param runningConfig Runningconfif
     **/
    public HouseController(RunningConfig runningConfig) {
        house = runningConfig.createRunningConfigOfHouse();
        weather = runningConfig.createRunningConfigOfWeather();
        events = new ArrayList<>();
        eventVisitor = new EventVisitor();
    }

    /**This method generates weather event.
     **/
    public void generateWeatherEvent() {

        weather.accept(eventVisitor);

        Event event = new Event(weather, house);
        event.setCause("Weather has changed.");
        events.add(event);

    }
    /**This method returns, if weather is good.
     * @return boolean
     * true - good weather
     * false - bad weather
     **/
    public boolean isGoodWeather() {

        return switch (weather.getWeatherState()) {
            case RAINY -> false;
            case FOGGY -> false;
            case WINDY -> true;
            case SUNNY -> true;
        };
    }
    /**Returns free equipment, if it is possible.
     * @return Equipment equipment
     **/
    public Equipment getFreeEquipmentIfExists() {

        Optional<Equipment> bikeEq = house.getEquipments().stream().filter(equipment1 ->
                equipment1.getName().equals("Bike") && equipment1.isFree()).findFirst();

        Optional<Equipment> skiEq = house.getEquipments().stream().filter(equipment1 ->
                equipment1.getName().equals("Ski") && equipment1.isFree()).findFirst();

        Optional<Equipment> carEq = house.getEquipments().stream().filter(eq -> eq.getName().equals("Car") &&
                eq.isFree()).findFirst();

        if (bikeEq.isPresent()) {
            return bikeEq.get();
        }

        if (skiEq.isPresent() && carEq.isPresent() && carEq.get().isFree()) {
            Car car = (Car) carEq.get();
            car.getInCar();
            return skiEq.get();
        }

        return null;
    }

    /**Returns free device, if it is possible.
     * @return Device device
     **/
    public Device getFreeDeviceIfExists() {

        Collections.shuffle(house.getDevices());

        Optional<Device> device = house.getDevices().stream().filter(dev ->
                (!dev.getName().equals("Fridge") && !dev.getName().equals("Sensor") && dev.isFree() &&
                        dev.getCondition() > 0)).findFirst();

        if (device.isPresent()) {
            Device d = (Device) device.get();
            return d;
        }
        return null;
    }


    /**This method tries to generate sport activity.
     * @param  event Event
     **/
    public void doSportActivity( Event event) {

        try {
            findSportActivity(event);
            return;

        } catch (InstanceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            findDeviceActivity(event);
            return;

        } catch (InstanceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        doNoActivity(event);
    }


    /**This method generates no activity (= waiting), if no other activities were available.
     * @param  event Event
     **/
    public void doNoActivity(Event event) {
        NoActivityHandler noActivityHandler = new NoActivityHandler();
        noActivityHandler.handleEvent(event);
    }


    /**This method tries to generate device activity.
     * @param  event Event
     **/
    public void doDeviceActivity(Event event) {

        try {
            findDeviceActivity(event);
            return;

        } catch (InstanceNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            findSportActivity(event);
            return;

        } catch (InstanceNotFoundException e) {
            System.out.println(e.getMessage());
        }
        doNoActivity(event);
    }
    /**This method tries to find sport activity.
     * @param  event Event
     **/
    public void findSportActivity(Event event) throws InstanceNotFoundException {

        if (isGoodWeather()) {

            Equipment equipment = getFreeEquipmentIfExists();

            if (equipment != null && equipment.getName().equals("Bike")) {

                Bike bike = (Bike) equipment;
                bike.accept(eventVisitor);
                event.setResponsibleEquipment(bike);

                EquipmentHandler equipmentHandler = new EquipmentHandler();
                equipmentHandler.handleEvent(event);
                return;
            }

            if (equipment != null && equipment.getName().equals("Ski") &&
                    event.getResponsiblePerson().getPersonState().equals(PersonState.ADULT)) {

                Ski ski = (Ski) equipment;
                ski.accept(eventVisitor);
                event.setResponsibleEquipment(ski);

                EquipmentHandler equipmentHandler = new EquipmentHandler();
                equipmentHandler.handleEvent(event);
                return;
            }
        }

        if (!isGoodWeather()) {
            LOG.info("{} cannot do sport activity because of bad weather state: " + weather.getWeatherState(),
                    event.getResponsiblePerson().getName());
        }

        throw new InstanceNotFoundException("Sport activity was not found, trying to find another activity for" +
                " person.");
    }


    /**This method tries to find device activity.
     * @param  event Event
     **/
    public void findDeviceActivity(Event event) throws InstanceNotFoundException {

        Device device = getFreeDeviceIfExists();

        if (device != null) {

            device.accept(eventVisitor);

            event.getResponsiblePerson().setActivity(PersonActivity.useDevice);
            event.setResponsibleDevice(device);
            DeviceHandler deviceHandler = new DeviceHandler();
            deviceHandler.handleEvent(event);

            return;
        }
        throw new InstanceNotFoundException("Device activity was not found, trying to find another activity for " +
                "person.");
    }




    /**This method generates event for free person.
     * @param  person Person
     **/
    public void generateEventForFreePerson(Person person) {
        person.accept(eventVisitor);

        Event event = new Event(weather, house);
        event.setResponsiblePerson(person);

        switch(person.getActivity()) {

            case doSport:
               doSportActivity(event);
               break;
            case useDevice:
                doDeviceActivity(event);
                break;

            default:
                throw new IllegalArgumentException("Unknown event reason!");
            }

        event.setCause(person.getActivity().toString());
    }

    /**This method generates event for free people.
     **/
    public void generateEventsForFreePeople() {

        List<Person> freePeople = house.getFamily().stream().filter(person -> person.isFree())
                .collect(Collectors.toList());

        freePeople.forEach(person -> generateEventForFreePerson(person));


    }


    /**This method generates event for hungry child.
     * @param  child Person
     **/
    public void generateHungryEventForChild(Person child) {

        child.setHungry(true);
        child.setFree(false);

        Event event = new Event(weather, house);
        event.setChild(child);
        event.setCause("Child is hungry.");
        events.add(event);
        LOG.info("Child {} did actions: become hungry.", child.getName());
    }

    /**This method generates event for hungry pet.
     * @param  pet Pet
     **/
    public void generateHungryEventForPet(Pet pet) {

        pet.accept(eventVisitor);
        Event event = new Event(weather, house);
        pet.setHungry(true);
        event.setPet(pet);
        event.setCause("Pet is hungry.");
        events.add(event);

        LOG.info("Pet {} did actions: become hungry.", pet.getName());
    }

    /**This method generates event for hungry adult and feeds the adult.
     * @param  person Person
     **/
    public void generateAndProcessHungryEventForAdult(Person person) {

        person.setHungry(true);
        person.setFree(false);

        Event event = new Event(weather, house);

        event.setResponsiblePerson(person);
        event.setCause("Person " + person.getName() + " is hungry.");

        Optional<Device> f = house.getDevices().stream().filter(device ->
                device.getName().equals("Fridge")).findFirst();

        if (f.isPresent()) {

            Fridge fridge = (Fridge) f.get();

            if (!fridge.getContent().isEmpty()) {

                event.setResponsibleDevice(fridge);
                DeviceHandler devH = new DeviceHandler();
                devH.handleEvent(event);

            }
        } else {
            reactByGettingFoodFromKitchenForAdult(event);
        }

        person.setHungry(false);
    }

    /**This method reacts on event hungry pet.
     * @param  event Event
     **/
    public void reactByGettingFoodFromKitchenForPet(Event event) {

        event.setWhatToDo("Feed pet " + event.getPet().getName() + " with some food in the kitchen.");

        PersonHandler p = new PersonHandler();
        p.handleEvent(event);
    }

    /**This method reacts on event hungry child.
     * @param  event Event
     **/
    public void reactByGettingFoodFromKitchenForChild(Event event) {

        event.setWhatToDo("Feed child " + event.getChild().getName() + " with some food in the kitchen.");

        PersonHandler p = new PersonHandler();
        p.handleEvent(event);

    }

    /**This method reacts on event hungry adult.
     * @param  event Event
     **/
    public void reactByGettingFoodFromKitchenForAdult(Event event) {

        event.setWhatToDo("Eat some food found in the kitchen.");

        PersonHandler p = new PersonHandler();
        p.handleEvent(event);

    }

    /**This method reacts on event for person.
     * @param  event Event
     * @param  person Person
     **/
    public void reactOnEvent(Event event, Person person) {

        person.setFree(false);
        event.setResponsiblePerson(person);

        switch(event.getCause()) {

            case "Pet is hungry.":

                event.getPet().setHungry(false);

                Optional<Device> fridge = event.getHouse().getDevices().stream().filter(device ->
                        device.getName().equals("Fridge")).findFirst();

                if (fridge.isPresent()) {

                    Fridge fridge1 = (Fridge) fridge.get();

                    if (!fridge1.getContent().isEmpty()) {

                        event.setResponsibleDevice(fridge1);
                        event.setWhatToDo("feed pet " + event.getPet().getName() + ".");

                        DeviceHandler d = new DeviceHandler();
                        d.handleEvent(event);

                    } else {
                        reactByGettingFoodFromKitchenForPet(event);
                    }
                }
                else {
                    reactByGettingFoodFromKitchenForPet(event);
                }
                break;

            case "Child is hungry.":

                Optional<Device> f =  event.getHouse().getDevices().stream().filter(device ->
                        device.getName().equals("Fridge")).findFirst();

                if (f.isPresent()) {

                    Fridge fridge2 = (Fridge) f.get();

                    if (!fridge2.getContent().isEmpty()) {

                        event.setResponsibleDevice(fridge2);
                        DeviceHandler deviceHandler = new DeviceHandler();
                        deviceHandler.handleEvent(event);
                        return;

                    } else {
                        reactByGettingFoodFromKitchenForChild(event);
                    }

                } else {
                    reactByGettingFoodFromKitchenForChild(event);
                }
                break;


            case "Weather has changed.":

                Optional<Device> s = house.getDevices().stream().filter(device ->
                        device.getName().equals("Sensor")).findFirst();

                if (s.isPresent()) {
                    Sensor sensor = (Sensor) s.get();
                    event.setResponsibleDevice(sensor);
                    sensor.accept(eventVisitor);

                    WeatherHandler weatherHandler = new WeatherHandler();
                    weatherHandler.handleEvent(event);
                    break;
                }


            case "Device is broken.":



                LOG.info("{} device is broken.", event.getResponsibleDevice().getName());
                event.setWhatToDo("repair the " + event.getResponsibleDevice().getName() + ".");

                PersonHandler personHandler = new PersonHandler();
                personHandler.setNextHandler(new BrokenDeviceHandler());
                personHandler.handleEvent(event);

                break;

            default:
                throw new IllegalArgumentException("Unknown event reason!");
        }



    }

    /**This method reacts on all events.
     **/
    public void reactOnAllEvents() {

        List<Person> freeAdults = house.getFamily().stream().filter(person -> person.isFree() &&
                person.getPersonState().equals(PersonState.ADULT)).collect(Collectors.toList());

        int lastIndex = 0;
        for (int i = 0; i < Math.min(freeAdults.size(), events.size()); i++) {
            reactOnEvent(events.get(i), freeAdults.get(i));
            lastIndex = i;
        }
        if (!freeAdults.isEmpty() && !events.isEmpty()) {
            for (int i = 0; i <= lastIndex; i++) {
                events.remove(0);
            }
        }

    }


    /**This method returns house instance.
     * @return house House
     **/
    public House getHouse() {
        List<Person> adults = house.getFamily().stream().filter(person -> person.getPersonState().
                equals(PersonState.ADULT)).collect(Collectors.toList());

        if (adults.isEmpty()) {
            throw new IllegalStateException("No adults were found in the house!");
        }
        return house;
    }

    /**This method returns weather instance.
     * @return weather Weather
     **/
    public Weather getWeather() {
        return weather;
    }

    /**This method returns list of broken devices.
     * @return List<Device>
     **/
    public List<Device> findBrokenDevices() {

        return (house.getDevices().stream().filter(device -> device.getCondition() <= 0).collect(
                Collectors.toList()));
    }

    /**This method returns list of events.
     * @return List<Event>
     **/
    public List<Event> getEvents() {
        return events;
    }


}
