package cz.cvut.fel.omo.model.family;


import cz.cvut.fel.omo.model.AbstractEntity;
import cz.cvut.fel.omo.visitors.Visitor;

/**
 * This class represents pet.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Pet extends AbstractEntity {

   private final String name;
   private boolean isHungry;
   private String type;

    /**
     * Creates pet with given name and type
     * @param name  String name of person
     * @param type String type of pet
     **/
    public Pet(String name, String type) {
        this.name = name;
        isHungry = false;
        this.type = type;
    }

    /**
     * This method accepts visitor.
     * @param visitor Visitor
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    /**
     * Returns string value of pet's name.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns whether the pet is hungry.
     * @return boolean
     */
    public boolean isHungry() {
        return isHungry;
    }

    /**
     * This method sets pet to be hungry or not.
     */
    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    /**
     * Returns type of pet.
     * @return String
     */
    public String getType() {
        return type;
    }

}
