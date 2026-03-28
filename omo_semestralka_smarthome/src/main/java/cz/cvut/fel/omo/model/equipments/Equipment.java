package cz.cvut.fel.omo.model.equipments;

import cz.cvut.fel.omo.visitors.Visitor;


/**
 * This class is an abstract class for equipment.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public abstract class Equipment {


    protected boolean isFree;
    protected String name;

    protected Equipment() {

        isFree = true;
    }


    public void accept(Visitor visitor){
        visitor.visit(this);
    }



    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

}
