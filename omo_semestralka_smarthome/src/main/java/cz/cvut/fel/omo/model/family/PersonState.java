package cz.cvut.fel.omo.model.family;

/**
 * This class holds enum of person states.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public enum PersonState {
    ADULT("ADULT"), CHILD("CHILD");

    private final String name;

    /**
     * Constructor for PersonState.
     * @param name String
     */
    PersonState(String name) {
        this.name = name;
    }

    /**
     * This method creates String representation.
     */
    @Override
    public String toString() {
        return name;
    }

}
