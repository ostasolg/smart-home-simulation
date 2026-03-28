package cz.cvut.fel.omo.visitors;

import cz.cvut.fel.omo.model.devices.Device;
import cz.cvut.fel.omo.model.equipments.Equipment;
import cz.cvut.fel.omo.model.family.Person;
import cz.cvut.fel.omo.model.family.Pet;
import cz.cvut.fel.omo.model.house.*;
import cz.cvut.fel.omo.model.weather.Weather;


/**
 * Interface of design pattern Visitor
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public interface Visitor {

    void visit(House house);

    void visit(Floor floor);

    void visit(Room room);

    void visit(Device device);

    void visit(Equipment equipment);

    void visit(Person person);

    void visit(Weather weather);

    void visit(Pet pet);

    void visit(Window window);

    void visit(Blinds blinds);

}
