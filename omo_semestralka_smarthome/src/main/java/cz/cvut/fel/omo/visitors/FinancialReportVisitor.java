package cz.cvut.fel.omo.visitors;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.*;
import cz.cvut.fel.omo.model.weather.Weather;
import cz.cvut.fel.omo.report.Report;
import cz.cvut.fel.omo.utils.Constants;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This class represents visitor for financial report.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class FinancialReportVisitor implements Visitor {

    public final Report consumptionReport = new Report("reports/ConsumptionReport.txt");

    private final static DecimalFormat df2 = new DecimalFormat("#.##");

    /**
     * Report's heading
     */
    public void startReport(){
        consumptionReport.writeToReport("――――――――――――――――――――――― REPORT BEGINNING ―――――――――――――――――――――――");
        consumptionReport.writeToReport("                         " + getDate()+ "                         ");
    }

    /**
     * Report's footer
     */
    public void endReport(){
        consumptionReport.writeToReport("―――――――――――――――――――――――― REPORT END ――――――――――――――――――――――――");
        consumptionReport.endReport();
    }

    /**
     * @return datum
     */
    private String getDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.M. hh:mm yyyy");
        return formatter.format(date);
    }


    /**
     * @param e electricity consumption
     * @param w water consumption
     * @return price for consumption
     */
    private double calculatePriceOfConsumption(double e, double w){
        double electricity = e * Constants.ELECTRICITY_PRICE_PER_kWh;
        double water = w * Constants.WATER_PRICE_PER_LITER;
        return electricity + water;

    }

    /**
     *This method adds house to the report.
     *
     * @param  house House
     */
    @Override
    public void visit(House house) {

        house.getFloors().forEach(floor -> {
            floor.getRooms().forEach(room -> {
                room.accept(new WaterConsumptionVisitor());
                room.accept(new ElectricityConsumptionVisitor());
            });
            floor.accept(new WaterConsumptionVisitor());
            floor.accept(new ElectricityConsumptionVisitor());
        });


        house.accept(new ElectricityConsumptionVisitor());
        house.accept(new WaterConsumptionVisitor());
        double e = house.getCurrentElectricityConsumption();
        double w = house.getCurrentWaterConsumption();
        double totalPrice = calculatePriceOfConsumption(e, w);
        List<Device> devices = house.getDevices();
        for (Device device:devices
        ) {visit(device);
        }
        consumptionReport.writeToReport("House consumption ");
        consumptionReport.writeToReport("-");
        consumptionReport.writeToReport("Electricity :    " + df2.format(e) );
        consumptionReport.writeToReport("Water :         " + df2.format(w) );
        consumptionReport.writeToReport("―――――――――――――――――――――――――――");
        consumptionReport.writeToReport("Total:        " + df2.format(totalPrice) + " Kč");
        consumptionReport.writeToReport("╚═══╗");

    }

    /**
     *This method adds floor to the report.
     *
     * @param  floor Floor
     */
    @Override
    public void visit(Floor floor) {

        double e = floor.getCurrentElectricityConsumption();
        double w = floor.getCurrentWaterConsumption();
        double totalPrice = calculatePriceOfConsumption(e, w);
        consumptionReport.writeToReport("Floor consumption " + floor.getFloorNumber());
        consumptionReport.writeToReport("-");
        consumptionReport.writeToReport("Electricity :    " + df2.format(e) );
        consumptionReport.writeToReport("Water :         " + df2.format(w) );
        consumptionReport.writeToReport("―――――――――――――――――――――――――――");
        consumptionReport.writeToReport("Total:        " + df2.format(totalPrice) + " Kč");
        consumptionReport.writeToReport("╚═══╗");
    }

    /**
     *This method adds room to the report.
     *
     * @param  room Room
     */
    @Override
    public void visit(Room room) {


        double e = room.getCurrentElectricityConsumption();
        double w = room.getCurrentWaterConsumption();
        double totalPrice = calculatePriceOfConsumption(e, w);
        consumptionReport.writeToReport("Room consumption " + room.getName());
        consumptionReport.writeToReport("-");
        consumptionReport.writeToReport("Electricity :    " + df2.format(e) );
        consumptionReport.writeToReport("Water :         " + df2.format(w) );
        consumptionReport.writeToReport("―――――――――――――――――――――――――――");
        consumptionReport.writeToReport("Total:        " + df2.format(totalPrice) + " Kč");
        consumptionReport.writeToReport("╚═══╗");
    }

    /**
     *This method adds device to the report.
     *
     * @param  device Device
     */
    @Override
    public void visit(Device device) {
        double e = device.getElectricitySummaryConsumption();
        double w = device.getWaterSummaryConsumption();
        double totalPrice = calculatePriceOfConsumption(e, w);
        consumptionReport.writeToReport("Device consumption " + device.getName());
        consumptionReport.writeToReport("-");
        consumptionReport.writeToReport("Electricity :    " + df2.format(e) );
        consumptionReport.writeToReport("Water :         " + df2.format(w) );
        consumptionReport.writeToReport("―――――――――――――――――――――――――――");
        consumptionReport.writeToReport("Total:        " + df2.format(totalPrice) + " Kč");
        consumptionReport.writeToReport("╚═══╗");
    }


    @Override
    public void visit(Equipment equipment) {
    }

    @Override
    public void visit(Window window) {
    }

    @Override
    public void visit(Blinds blinds) {

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

}
