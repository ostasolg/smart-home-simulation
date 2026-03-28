package cz.cvut.fel.omo.model.family;

/**
 * This class holds enum of person activities.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public enum PersonActivity {

    doSport("do sport"),
    useDevice("use device");

    private final String name;

    /**
     * Constructor for PersonActivity.
     * @param name String
     */
    PersonActivity(String name) {
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
