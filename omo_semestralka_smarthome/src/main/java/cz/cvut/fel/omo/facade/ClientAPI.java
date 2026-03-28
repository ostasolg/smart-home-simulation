package cz.cvut.fel.omo.facade;

import cz.cvut.fel.omo.controller.Start;
import cz.cvut.fel.omo.model.house.House;
import cz.cvut.fel.omo.model.weather.Weather;
import cz.cvut.fel.omo.runningConfig.RunningConfig1;
import cz.cvut.fel.omo.runningConfig.RunningConfig2;
import cz.cvut.fel.omo.runningConfig.RunningConfig3;
import cz.cvut.fel.omo.visitors.FinancialReportVisitor;
import cz.cvut.fel.omo.visitors.StartReportVisitor;


/**
 * This is class for simulation.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class ClientAPI {


    /**
     * Starts simulation with first configuration.
     */
    public void startSimulation1() {
        Start start1 = new Start(new RunningConfig1());
        start1.doRounds(20);
        createReports(start1.getHC().getHouse(), start1.getHC().getWeather());
    }

    /**
     * Starts simulation with second configuration.
     */
    public void startSimulation2() {
        Start start2 = new Start(new RunningConfig2());
        start2.doRounds(20);
        createReports(start2.getHC().getHouse(), start2.getHC().getWeather());
    }

    /**
     * Starts simulation with third configuration.
     */
    public void startSimulation3() {
        Start start3 = new Start(new RunningConfig3());
        start3.doRounds(20);
        createReports(start3.getHC().getHouse(), start3.getHC().getWeather());
    }

    /**
     * Creates reports.
     * @param house House
     */
    private void createReports(House house, Weather weather) {


        StartReportVisitor startReportVisitor = new StartReportVisitor();
        startReportVisitor.startReport();
        startReportVisitor.visit(house);
        startReportVisitor.visit(weather);
        startReportVisitor.endReport();

        FinancialReportVisitor financialReportVisitor = new FinancialReportVisitor();
        financialReportVisitor.startReport();
        financialReportVisitor.visit(house);
        financialReportVisitor.endReport();
    }

}
