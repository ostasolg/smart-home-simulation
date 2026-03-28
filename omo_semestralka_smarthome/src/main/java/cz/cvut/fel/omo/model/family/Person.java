package cz.cvut.fel.omo.model.family;

import cz.cvut.fel.omo.model.AbstractEntity;
import cz.cvut.fel.omo.model.house.Room;
import cz.cvut.fel.omo.visitors.Visitor;

/**
 * This class represents person.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Person extends AbstractEntity {

    private Room room;
    private final String name;
    private int age;
    private PersonState personState;
    private boolean isHungry;
    private boolean isFree;
    private PersonActivity activity;

    /**
     * Creates person with given name and age
     * @param name  String name of person
     * @param age   int value of person's age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        if (age >= 18) {
            personState = PersonState.ADULT;
        } else {
            personState = PersonState.CHILD;
        }
        isHungry = false;
        isFree = true;
    }

    /**
     * This method accepts visitor
     * @param visitor Visitor
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }


    /**
     * Returns string value of person's name.
     * @return string value of person's name
     */
    public String getName() {
        return name;
    }


    /**
     * Returns int value of person's age.
     * @return int value of person's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns state of person.
     * @return PersonState value of person's state
     */
    public PersonState getPersonState() {
        return personState;
    }

    /**
     * Sets room for the person .
     * @param room room for the person
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Returns room,where person is.
     * @return room
     */
    public Room getRoom(){
        return room;
    }

    /**
     * Returns whether the person is hungry.
     * @return boolean
     */
    public boolean isHungry() {
        return isHungry;
    }

    /**
     * This method sets person to be hungry or not.
     * @param hungry boolean
     */

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    /**
     * Returns whether the person is free.
     * @return boolean
     */
    public boolean isFree() {
        return isFree;
    }

    /**
     * This method sets person to be free or not.
     * @param free boolean
     */
    public void setFree(boolean free) {
        isFree = free;
    }

    /**
     * Returns activity of person.
     * @return PersonActivity
     */
    public PersonActivity getActivity() {
        return activity;
    }

    /**
     * This method sets activity for Person
     * @param action PersonActivity
     */
    public void setActivity(PersonActivity action) {
        this.activity = action;
    }

}