package cz.cvut.fel.omo.visitors;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.*;
import cz.cvut.fel.omo.model.weather.Weather;
import cz.cvut.fel.omo.report.Report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * This class lists information about house (floors, rooms, devices, equipments) then all house occupants.
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class StartReportVisitor implements Visitor {

    private int counter = 1;

    /**
     * Instance of report of house configuration
     */
    public static final Report houseConfigReport = new Report("reports/HouseConfigReport.txt");

    /**
     * This methods starts the report.
     */
    public void startReport(){

        houseConfigReport.writeToReport("――――――――――――――――――――――― REPORT BEGINNING ―――――――――――――――――――――――");
        houseConfigReport.writeToReport("                       " + getDate()+ "                       ");
    }

    /**
     *This methods ends the report.
     */
    public void endReport(){

        houseConfigReport.writeToReport("―――――――――――――――――――――――― REPORT END ――――――――――――――――――――――――");
        houseConfigReport.endReport();
    }

    /**
     *This method returns date written in specific format.
     *
     * @return datum
     */
    private String getDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.M. hh:mm yyyy");
        return formatter.format(date);
    }

    /**
     *This method adds house to the report.
     *
     * @param  house House
     */
    @Override
    public void visit(House house) {
        houseConfigReport.writeToReport("House ");
        int floors = house.getFloors().size();
        for (int i = 0; i < floors; i++){
            visit(house.getFloors().get(i));
        }

        houseConfigReport.writeToReport("\n");
        houseConfigReport.writeToReport("――――――――――――――――――――――――――――――――――――――――――――――――――");
        houseConfigReport.writeToReport("\n");

        List<Person> people = house.getFamily();
        houseConfigReport.writeToReport("Number of occupants " + people.size());
        for (Person person : people) {
            visit(person);
        }


        houseConfigReport.writeToReport("\n");
        houseConfigReport.writeToReport("――――――――――――――――――――――――――――――――――――――――――――――――――");
        houseConfigReport.writeToReport("\n");

        List<Pet> pets = house.getPets();
        houseConfigReport.writeToReport("Number of pets " + pets.size());
        for (Pet pet : pets) {
            visit(pet);
        }

        houseConfigReport.writeToReport("\n");
        houseConfigReport.writeToReport("――――――――――――――――――――――――――――――――――――――――――――――――――");
    }

    /**
     *This method adds floor to the report.
     *
     * @param  floor Floor
     */
    @Override
    public void visit(Floor floor) {
        houseConfigReport.writeToReport("  Floor " + floor.getFloorNumber());
        int rooms = floor.getRooms().size();
        for (int i = 0; i < rooms; i++){
            visit(floor.getRooms().get(i));
        }
    }

    /**
     *This method adds room to the report.
     *
     * @param  room Room
     */
    @Override
    public void visit(Room room) {
        houseConfigReport.writeToReport("    Room " + room.getName());
        int devices = room.getDevices().size();
        for (int i = 0; i < devices; i++){
            visit(room.getDevices().get(i));
        }
        for (int i = 0 ; i < room.getWindows().size();i++){
            visit(room.getWindows().get(i));
            visit(room.getWindows().get(i).getBlinds());
            counter++;
        }
    }

    /**
     *This method adds device to the report.
     *
     * @param  device Device
     */
    @Override
    public void visit(Device device) {
        houseConfigReport.writeToReport("      Device " + device.getName());
    }


    /**
     *This method adds equipment to the report.
     *
     * @param  equipment Equipment
     */
    @Override
    public void visit(Equipment equipment) {
        houseConfigReport.writeToReport("      Equipment " +
                equipment.getName());
    }


    /**
     *This method adds window to the report.
     *
     * @param  window Window
     */
    @Override
    public void visit(Window window) {
        houseConfigReport.writeToReport("      Window " + counter);

    }


    /**
     *This method adds blinds to the report.
     *
     * @param  blinds Blinds
     */
    @Override
    public void visit(Blinds blinds) {
        houseConfigReport.writeToReport("     Blinds for window " + counter);
    }


    /**
     *This method adds person to the report.
     *
     * @param  person Person
     */
    @Override
    public void visit(Person person){
        int age = person.getAge();
        if (age == 1){

            houseConfigReport.writeToReport("Hi, I'm " + person.getName() + " and I'm " + age + " year old.");

        } else {

            houseConfigReport.writeToReport("Hi, I'm " + person.getName() + " and I'm " + age + " years old.");
        }
    }


    /**
     *This method adds weather to the report.
     *
     * @param  weather Weather
     */
    @Override
    public void visit(Weather weather) {
        houseConfigReport.writeToReport("We have " + weather.getTemperature() + " degrees celsius" + " and it's "
                + weather.getWeatherState() + ".\n\n");

    }

    /**
     *This method adds pet to the report.
     *
     * @param  pet Pet
     */
    @Override
    public void visit(Pet pet) {
        houseConfigReport.writeToReport("This is " + pet.getName() + " and I'm a  " + pet.getType() + ".");
    }
}
