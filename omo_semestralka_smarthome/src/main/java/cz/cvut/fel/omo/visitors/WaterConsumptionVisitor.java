package cz.cvut.fel.omo.visitors;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.*;
import cz.cvut.fel.omo.model.weather.Weather;

/**
 * This class represents visitor for water consumption report.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class WaterConsumptionVisitor implements Visitor {


    /**
     *This method adds house to the report.
     *
     * @param  house House
     */
    @Override
    public void visit(House house) {
        double totalWater = 0;
        for(Floor floor : house.getFloors()){
            totalWater += floor.getCurrentWaterConsumption();
        }
        house.setCurrentWaterConsumption(totalWater);
    }


    /**
     *This method adds floor to the report.
     *
     * @param  floor Floor
     */
    @Override
    public void visit(Floor floor) {

        double totalWater = 0;
        for(Room room : floor.getRooms()){
            totalWater += room.getCurrentWaterConsumption();
        }
        floor.setCurrentWaterConsumption(totalWater);
    }


    /**
     *This method adds room to the report.
     *
     * @param  room Room
     */
    @Override
    public void visit(Room room) {

        double totalWater = 0;
        for(Device device : room.getDevices()){
            totalWater += device.getWaterSummaryConsumption();
        }
        room.setCurrentWaterConsumption(totalWater);
    }

    @Override
    public void visit(Device device) {
        device.setWaterSummaryConsumption(device.getWaterSummaryConsumption() +
                device.getConsumption().getWaterConsumptionPerRoundACTIVE());
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
