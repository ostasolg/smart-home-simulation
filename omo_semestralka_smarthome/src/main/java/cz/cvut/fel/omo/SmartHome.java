package cz.cvut.fel.omo;

import cz.cvut.fel.omo.facade.ClientAPI;

/**
 * This is the main class of the program.
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class SmartHome {

    /**
     * This method starts running this application. Please choose which configuration you want.
     *
     * @param args console arguments
     */
    public static void main(String[] args) {

        ClientAPI clientAPI = new ClientAPI();

        clientAPI.startSimulation1();
//        clientAPI.startSimulation2();
//        clientAPI.startSimulation3();
    }
}
