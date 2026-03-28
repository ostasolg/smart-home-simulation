package cz.cvut.fel.omo.controller;

import cz.cvut.fel.omo.model.Event;
import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Car;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.PersonState;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.runningConfig.RunningConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 * This class represents Start.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Start {

    private HouseController HC;

    private static final Logger LOG = LoggerFactory.getLogger(Start.class);

    /**
     * Constructor for class Start.
     **/
    public Start(RunningConfig runningConfig) {
        HC = new HouseController(runningConfig);
    }

    /**
     *Simulates given number of rounds.
     *
     *@param ROUNDS int
     **/
    public void doRounds(int ROUNDS) {

        System.out.println("");
        LOG.info("\n---------------- STARTING NEW SIMULATION ----------------\n");

        for (int roundNumber = 1; roundNumber <= ROUNDS; roundNumber++) {

            LOG.info("\n ROUND " + roundNumber + " STARTED: \n");

            prepareRoundAtStart();
            doRound(roundNumber);
            cleanRoundAtTheEnd();

        }

        System.out.println("");
        LOG.info("\n--------------- END OF THE SIMULATION ----------------\n");
        System.out.println("");
    }


    /**
     * Simulates one round.
     *
     * @param roundNumber int
     **/
    public void doRound(int roundNumber) {

        HC.reactOnAllEvents();

        if (roundNumber % 7 == 0) {
            List<Pet> pets = HC.getHouse().getPets().stream().filter(pet -> !pet.isHungry())
                    .collect(Collectors.toList());

            if (!pets.isEmpty()) {
                Collections.shuffle(pets);
                HC.generateHungryEventForPet(pets.get(0));
            }
        }


        if (roundNumber % 4 == 0) {
            HC.generateWeatherEvent();
        }


        if (roundNumber % 3 == 0) {
            List<Person> children = HC.getHouse().getFamily().stream().filter(p -> p.getPersonState()
                    .equals(PersonState.CHILD) && p.isFree() && !p.isHungry()).collect(Collectors.toList());


            if (!children.isEmpty()) {
                Collections.shuffle(children);
                HC.generateHungryEventForChild(children.get(0));
            }
        }


        if (roundNumber % 4 == 0) {
            List<Person> adults = HC.getHouse().getFamily().stream().filter(p -> p.getPersonState()
                    .equals(PersonState.ADULT) && p.isFree()).collect(Collectors.toList());

            if (!adults.isEmpty()) {
                Collections.shuffle(adults);
                HC.generateAndProcessHungryEventForAdult(adults.get(0));
            }
        }

        HC.generateEventsForFreePeople();



    }


    /**Prepares the round at start.
     **/
    public void prepareRoundAtStart() {

        List<Device> brokenDevices = HC.findBrokenDevices();
        brokenDevices.forEach(brokenDevice -> {
            brokenDevice.setFree(false);
            Event event = new Event(HC.getWeather(), HC.getHouse());
            event.setResponsibleDevice(brokenDevice);
            event.setCause("Device is broken.");
            HC.getEvents().add(event);
        });
    }

    /**Cleans the round at the end.
     **/
    public void cleanRoundAtTheEnd() {

        cleanDevicesAtTheEndOfRound();
        cleanEquipmentAtTheEndOfRound();
        cleanPeopleAtTheEndOfRound();

    }


    /**Cleans devices at the end of round.
     **/
    public void cleanDevicesAtTheEndOfRound() {

        List<Device> devices = HC.getHouse().getDevices();

        devices.forEach(device -> {

            if (device.getDeviceState().toString().equals("ACTIVE") && device.isFree()) {

                device.setElectricitySummaryConsumption(device.getElectricitySummaryConsumption() +
                        device.getConsumption().getElectricityConsumptionPerRoundACTIVE());
                device.setWaterSummaryConsumption(device.getWaterSummaryConsumption() +
                        device.getConsumption().getWaterConsumptionPerRoundACTIVE());
            }

            else if (device.isFree() && device.getDeviceState().toString().equals("IDLE")) {

                device.setElectricitySummaryConsumption(device.getElectricitySummaryConsumption() +
                        device.getConsumption().getElectricityConsumptionPerRoundIDLE());
                device.setWaterSummaryConsumption(device.getWaterSummaryConsumption() +
                        device.getConsumption().getWaterConsumptionPerRoundIDLE());
            }

            device.setFree(true);
        });
    }

    /**Cleans equipment at the end of round.
     **/
    public void cleanEquipmentAtTheEndOfRound() {

        List<Equipment> equipments = HC.getHouse().getEquipments();

        equipments.forEach(equipment -> {

            equipment.setFree(true);

            if (equipment.getName().equals("Car")) {

                Car car = (Car) equipment;
                car.setOccupiedSeats(0);
            }
        });
    }

    /**
     * Cleans people at the end of round.
     **/
    public void cleanPeopleAtTheEndOfRound() {

        List<Person> people = HC.getHouse().getFamily();

        people.forEach(person -> {

            if (!person.isHungry()) {
                person.setFree(true);
                person.setActivity(null);
            }
        });

    }

    /**
     * This method returns instance of HouseController.
     *
     * @return HouseController instance
     **/
    public HouseController getHC() {
        return HC;
    }
}
