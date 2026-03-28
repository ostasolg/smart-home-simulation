package cz.cvut.fel.omo.model;

import cz.cvut.fel.omo.observers.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract class for handling observers.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public abstract class AbstractEntity {

    private List<Observer> observers = new ArrayList<>();


    /**
     * This method attaches observer.
     * @param observer Observer
     */
    public void attach(Observer observer){
        observers.add(observer);
    }


    /**
     * This method notifies all observers.
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
