package cz.cvut.fel.omo.runningConfig;

import cz.cvut.fel.omo.builders.HouseBuilder;
import cz.cvut.fel.omo.factory.DeviceFactory;
import cz.cvut.fel.omo.model.devices.*;
import cz.cvut.fel.omo.model.equipments.Bike;
import cz.cvut.fel.omo.model.equipments.Car;
import cz.cvut.fel.omo.model.equipments.Ski;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.*;
import cz.cvut.fel.omo.model.weather.Weather;
import cz.cvut.fel.omo.model.weather.WeatherState;
import cz.cvut.fel.omo.observers.ConditionObserver;


/**
 * This class represents first configuration of house.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class RunningConfig1 implements RunningConfig {


    @Override
    public House createRunningConfigOfHouse() {

        DeviceFactory deviceFactory = new DeviceFactory();

        Sensor sensor = deviceFactory.createSensor(10, 1, 0, 0);
        Sensor sensor1 = deviceFactory.createSensor(10, 1, 0, 0);
        Sensor sensor2 = deviceFactory.createSensor(10, 1, 0, 0);
        Sensor sensor3 = deviceFactory.createSensor(10, 1, 0, 0);

        Light light = deviceFactory.createLight(50,1,0,0);
        Light light1 = deviceFactory.createLight(50,1,0,0);
        Light light2 = deviceFactory.createLight(50,1,0,0);
        Light light3 = deviceFactory.createLight(50,1,0,0);
        Light light4 = deviceFactory.createLight(50,1,0,0);

        VacuumCleaner vacuumCleaner = deviceFactory.createVacuumCleaner(500,20,0,0);
        VacuumCleaner vacuumCleaner1 = deviceFactory.createVacuumCleaner(500,20,0,0);


        PC laptop = deviceFactory.createPC(20,1,0,0);

        TV tv = deviceFactory.createTV(100,1,0,0);
        TV tv1 = deviceFactory.createTV(100,1,0,0);

        Radio radio = deviceFactory.createRadio(30,1,0,0);

        WashingMachine washingMachine = deviceFactory.createWashingMachine(75,1,100,1);

        Dishwasher dishwasher = deviceFactory.createDishwasher(75,1,100,1);

        CoffeeMaker coffeeMaker = deviceFactory.createCoffeeMaker(35,1,10,0);

        Fridge fridge = deviceFactory.createFridge(100,1,20,0);
        Fridge fridge1 = deviceFactory.createFridge(100,1,20,0);
        Fridge fridge2 = deviceFactory.createFridge(100,1,20,0);
        Ski ski = new Ski();
        Bike bike =  new Bike();
        Bike bike1 =  new Bike();
        Car car = new Car();

        House house = new HouseBuilder().buildFloor(new Floor(0)).buildFloor(new Floor(1))
                .buildRoom(new Room("Attic"),1)
                .buildRoom(new Room("Kitchen"),0)
                .buildRoom(new Room("Bathroom"),1)
                .buildRoom(new Room("Bedroom"),0)
                .buildRoom(new Room("Children room"),1)
                .buildRoom(new Room("Gaming room"),1)
                .buildRoom(new Room("Study"),1)
                .buildWindow(new Window(new Blinds()),"Attic")
                .buildWindow(new Window(new Blinds()),"Kitchen")
                .buildWindow(new Window(new Blinds()),"Bedroom")
                .buildWindow(new Window(new Blinds()),"Children room")
                .buildWindow(new Window(new Blinds()),"Study")
                .buildWindow(new Window(new Blinds()),"Attic")
                .addDevice(sensor,"Attic")
                .addDevice(sensor1,"Kitchen")
                .addDevice(sensor2,"Bedroom")
                .addDevice(sensor3,"Study")
                .addDevice(light,"Attic")
                .addDevice(light1,"Kitchen")
                .addDevice(light2,"Gaming room")
                .addDevice(light3,"Bedroom")
                .addDevice(light4,"Study")
                .addDevice(fridge,"Kitchen")
                .addDevice(fridge1,"Kitchen")
                .addDevice(laptop,"Study")
                .addDevice(radio,"Kitchen")
                .addDevice(tv,"Attic")
                .addDevice(tv1,"Bedroom")
                .addDevice(washingMachine,"Bathroom")
                .addDevice(dishwasher,"Kitchen")
                .addDevice(coffeeMaker,"Kitchen")
                .addDevice(fridge2,"Kitchen")
                .addDevice(vacuumCleaner,"Study")
                .addDevice(vacuumCleaner1,"Kitchen")
                .addEquipment(ski)
                .addEquipment(bike)
                .addEquipment(car)
                .addEquipment(bike1)
                .addPerson(new Person("Jack",40),"Attic")
                .addPerson(new Person("Rose",38),"Study")
                .addPerson(new Person("Mom",45),"Kitchen")
                .addPerson(new Person("Father",50),"Attic")
                .addPerson(new Person("Aunt",48),"Kitchen")
                .addPerson(new Person("Son",5),"Gaming room")
                .addPet(new Pet("Gard","Dog"))
                .addPet(new Pet("Mia","Cat"))
                .addPet(new Pet("Jack","jellyfish"))
                .build();

        house.getDevices().forEach(device -> device.setFree(true));
        house.getDevices().forEach(device -> device.attach(new ConditionObserver(device)));

        return house;
    }

    @Override
    public Weather createRunningConfigOfWeather() {
        Weather weather = new Weather();
        weather.setTemperature(20);
        weather.setWeatherState(WeatherState.SUNNY);
        return weather;
    }

}
