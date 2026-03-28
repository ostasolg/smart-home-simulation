package cz.cvut.fel.omo.visitors;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.PersonActivity;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.*;
import cz.cvut.fel.omo.model.weather.Weather;
import cz.cvut.fel.omo.model.weather.WeatherState;

import java.util.Random;

/**
 * This class represents visitor for events.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class EventVisitor implements Visitor {

    Random rand = new Random();




    /**
     *This method adds device to the report.
     *
     * @param  device Device
     */
    @Override
    public void visit(Device device) {

        if (device.getDeviceState().toString().equals("OFF")) {
            device.turnOn();
            useDevice(device);
            device.turnOff();

            return;
        }
        useDevice(device);
    }


    /**
     *This method starts using the device and handles it's behaviour.
     *
     * @param  device Device
     */
    public void useDevice(Device device) {
        device.startUsing();
        device.setFree(false);

        device.accept(new ElectricityConsumptionVisitor());
        device.accept(new WaterConsumptionVisitor());

        device.setCondition(device.getCondition() - 30);
        device.notifyAllObservers();

        device.stopUsing();
    }

    /**
     *This method adds equipment to the report.
     *
     * @param  equipment Equipment
     */
    @Override
    public void visit(Equipment equipment) {
        equipment.setFree(false);
    }

    /**
     *This method adds person to the report.
     *
     * @param  person Person
     */
    @Override
    public void visit(Person person) {

        PersonActivity[] values = PersonActivity.values();
        int length = values.length;
        int randIndex = rand.nextInt(length);

        person.setFree(false);
        person.setActivity(values[randIndex]);
    }



    /**
     *This method adds weather to the report.
     *
     * @param  weather Weather
     */
    @Override
    public void visit(Weather weather) {

        int randomNum = rand.nextInt((25 - 0) + 1) + 0;
        weather.setTemperature(randomNum);

        WeatherState[] values = WeatherState.values();
        int length = values.length;
        int randIndex = rand.nextInt(length);
        weather.setWeatherState(values[randIndex]);
    }


    /**
     *This method adds pet to the report.
     *
     * @param  pet Pet
     */
    @Override
    public void visit(Pet pet) {
        pet.setHungry(true);
    }

    @Override
    public void visit(House house) {

    }

    @Override
    public void visit(Floor floor) {

    }

    @Override
    public void visit(Window window) {
    }

    @Override
    public void visit(Blinds blinds) {

    }

    @Override
    public void visit(Room room) {

    }
}
