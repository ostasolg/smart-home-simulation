package cz.cvut.fel.omo.model.weather;


/**
 * This class represents Weather states.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public enum WeatherState {

    /**
     * Weather states.
     */
    SUNNY("SUNNY"), WINDY("WINDY"), RAINY("RAINY"), FOGGY("FOGGY");

    private final String name;

    /**
     * Creates weather state with given name.
     * @param name String
     */
    WeatherState(String name) {
        this.name = name;
    }

    /**
     * Returns string containing basic info about weather state.
     * @return String name
     */
    @Override
    public String toString() {
        return name;
    }

}
