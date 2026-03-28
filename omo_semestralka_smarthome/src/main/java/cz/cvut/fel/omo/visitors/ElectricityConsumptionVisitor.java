package cz.cvut.fel.omo.visitors;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.*;
import cz.cvut.fel.omo.model.weather.Weather;


/**
 * This class represents visitor for electricity consumption report.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class ElectricityConsumptionVisitor implements Visitor {



    /**
     *This method adds house to the report.
     *
     * @param  house House
     */
    @Override
    public void visit(House house) {
        double totalElectricity = 0;
        for(Floor floor : house.getFloors()){
            totalElectricity += floor.getCurrentElectricityConsumption();
        }
        house.setCurrentElectricityConsumption(totalElectricity);
    }


    /**
     *This method adds floor to the report.
     *
     * @param  floor Floor
     */
    @Override
    public void visit(Floor floor) {
        double totalElectricity = 0;
        for(Room room : floor.getRooms()){
            totalElectricity += room.getCurrentElectricityConsumption();
        }
        floor.setCurrentElectricityConsumption(totalElectricity);
    }


    /**
     *This method adds room to the report.
     *
     * @param  room Room
     */
    @Override
    public void visit(Room room) {
        double totalElectricity = 0;
        for(Device device : room.getDevices()){
            totalElectricity += device.getElectricitySummaryConsumption();
        }

        room.setCurrentElectricityConsumption(totalElectricity);
    }


    @Override
    public void visit(Device device) {
        device.setElectricitySummaryConsumption(device.getElectricitySummaryConsumption() +
                device.getConsumption().getElectricityConsumptionPerRoundACTIVE());
    }


    @Override
    public void visit(Equipment equipment) {

    }

    @Override
    public void visit(Person person) {

    }

    @Override
    public void visit(Weather weather) {

    }

    @Override
    public void visit(Pet pet) {

    }

    @Override
    public void visit(Window window) {

    }

    @Override
    public void visit(Blinds blinds) {

    }
}
