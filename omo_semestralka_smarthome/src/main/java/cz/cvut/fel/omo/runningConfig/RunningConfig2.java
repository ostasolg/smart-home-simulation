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
 * This class represents second configuration of house.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class RunningConfig2 implements RunningConfig {


    @Override
    public House createRunningConfigOfHouse() {

        DeviceFactory deviceFactory = new DeviceFactory();

        Sensor sensor1 = deviceFactory.createSensor(10, 1, 0, 0);
        Sensor sensor2 = deviceFactory.createSensor(10, 1, 0, 0);
        Sensor sensor3 = deviceFactory.createSensor(10, 1, 0, 0);
        Sensor sensor4 = deviceFactory.createSensor(10, 1, 0, 0);

        Light light1 = deviceFactory.createLight(50,1,0,0);
        Light light2 = deviceFactory.createLight(50,1,0,0);
        Light light3 = deviceFactory.createLight(50,1,0,0);
        Light light4 = deviceFactory.createLight(50,1,0,0);
        Light light5 = deviceFactory.createLight(50,1,0,0);

        PC laptop = deviceFactory.createPC(20,1,0,0);

        TV tv = deviceFactory.createTV(100,1,0,0);

        Radio radio = deviceFactory.createRadio(30,1,0,0);

        WashingMachine washingMachine = deviceFactory.createWashingMachine(75,1,100,1);
        WashingMachine washingMachine1 = deviceFactory.createWashingMachine(75,1,100,1);

        Dishwasher dishwasher = deviceFactory.createDishwasher(75,1,100,1);

        CoffeeMaker coffeeMaker = deviceFactory.createCoffeeMaker(35,1,10,0);
        CoffeeMaker coffeeMaker1 = deviceFactory.createCoffeeMaker(35,1,10,0);

        Fridge fridge = deviceFactory.createFridge(100,0,20,0);
        Fridge fridge1 = deviceFactory.createFridge(100,0,20,0);

        VacuumCleaner vacuumCleaner = deviceFactory.createVacuumCleaner(500,100,0,0);

        Ski ski = new Ski();
        Bike bike =  new Bike();
        Car car = new Car();
        Bike bike1 =  new Bike();
        House house = new HouseBuilder().buildFloor(new Floor(0)).buildFloor(new Floor(1))
                .buildRoom(new Room("Living room"),0).buildRoom(new Room("Kitchen"),0)
                .buildRoom(new Room("Bathroom"),0).buildRoom(new Room("Bedroom"),1)
                .buildRoom(new Room("Kids bedroom"),1).buildRoom(new Room("Attic"),1)
                .buildRoom(new Room("Study"),1)
                .buildWindow(new Window(new Blinds()),"Living room")
                .buildWindow(new Window(new Blinds()),"Kitchen")
                .buildWindow(new Window(new Blinds()),"Bedroom")
                .buildWindow(new Window(new Blinds()),"Kids bedroom")
                .buildWindow(new Window(new Blinds()),"Study")
                .buildWindow(new Window(new Blinds()),"Living room")
                .addDevice(sensor4,"Living room")
                .addDevice(sensor3,"Kitchen")
                .addDevice(sensor1,"Bedroom")
                .addDevice(sensor2,"Study")
                .addDevice(light3,"Living room")
                .addDevice(light4,"Kitchen")
                .addDevice(light1,"Bathroom")
                .addDevice(light5,"Bedroom")
                .addDevice(light2,"Study")
                .addDevice(laptop,"Study")
                .addDevice(radio,"Kitchen")
                .addDevice(washingMachine1,"Kitchen")
                .addDevice(coffeeMaker,"Living room")
                .addDevice(vacuumCleaner,"Attic")
                .addDevice(tv,"Living room")
                .addDevice(fridge,"Kitchen")
                .addDevice(washingMachine,"Bathroom")
                .addDevice(dishwasher,"Kitchen")
                .addDevice(coffeeMaker1,"Kitchen")
                .addDevice(fridge1,"Kitchen")
                .addEquipment(ski)
                .addEquipment(bike)
                .addEquipment(car)
                .addEquipment(bike1)
                .addPerson(new Person("Mother",30),"Kitchen")
                .addPerson(new Person("Father",35),"Study")
                .addPerson(new Person("Daughter",10),"Kids bedroom")
                .addPerson(new Person("Son",5),"Living room")
                .addPerson(new Person("David",19),"Study")
                .addPerson(new Person("Martin", 35), "Kitchen")
                .addPet(new Pet("Jerry","Dog"))
                .addPet(new Pet("Dempsey","Guinea pig"))
                .addPet(new Pet("Tom","Cat")).build();


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
