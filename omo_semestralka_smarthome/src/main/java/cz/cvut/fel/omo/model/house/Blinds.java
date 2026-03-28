package cz.cvut.fel.omo.model.house;

/**
 * This class holds represents blinds.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Blinds {

    private boolean areRolledUp;

    /**
     * Creates new pulled down blinds
     *
     */
    public Blinds() {
        areRolledUp = false;
    }

    /**
     *Return whether the blinds are rolled up.
     * @return boolean
     */
    public boolean areRolledUp() {
        return areRolledUp;
    }

    /**
     * This method sets whether the blinds are rolled up or pulled down.
     * @param areRolledUp boolean
     * true rolled up
     * false pulled down
     */
    public void setAreRolledUp(boolean areRolledUp) {
        this.areRolledUp = areRolledUp;
    }
}
