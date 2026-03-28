package cz.cvut.fel.omo.model.house;

/**
 * This class represents Window.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Window {

    private boolean isOpened;
    private final Blinds blinds;

    /**
     * Creates new Window with blinds
     * @param blinds Blinds
     */
    public Window(Blinds blinds) {
        isOpened = false;
        this.blinds = blinds;
    }

    /**
     * Return whether the window is opened.
     * @return boolean
     * true window is opened
     * false window is closed
     */
    public boolean isOpened(){
        return isOpened;
    }

    /**
     * Creates new pulled down blinds
     *
     */
    public void setOpened(boolean opened) {
        isOpened = opened;
    }


    /**
     * Return blinds.
     * @return Blinds
     */
    public Blinds getBlinds() {
        return blinds;
    }
}
