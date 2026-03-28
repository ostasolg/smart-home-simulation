package cz.cvut.fel.omo.model.weather;

import cz.cvut.fel.omo.visitors.Visitor;

/**
 * This class represents Weather.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Weather {


    private int temperature;
    private WeatherState weatherState;


    /**
     * This method accepts Visitor.
     * @param visitor Visitor
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    /**
     * @return int returns temperature.
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * This method sets temperature of weather.
     * @param temperature int
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * This method gets state of weather.
     * @return WeatherState weatherState
     */
    public WeatherState getWeatherState() {
        return weatherState;
    }

    /**
     * This method sets state of weather.
     * @param weatherState WeatherState
     */
    public void setWeatherState(WeatherState weatherState) {
        this.weatherState = weatherState;
    }
}
