package cz.cvut.fel.omo.handlers;

import cz.cvut.fel.omo.model.Event;
import cz.cvut.fel.omo.model.weather.WeatherState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents handler for weather.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class WeatherHandler extends AbstractHandler {


    private static final Logger LOG = LoggerFactory.getLogger(WeatherHandler.class);


    /**
     * Handles event.
     * @param event Event Represents event to be handled
     */
    @Override
    public void handleEvent(Event event) {
        if (event != null) {
            processEvent(event);
        }

        if (nextHandler != null) {
            nextHandler.handleEvent(event);
        }
    }

    /**
     * Processes event.
     * @param event Event Represents event to be processed
     */
    @Override
    public void processEvent (Event event) {

        setNextHandler(new SensorHandler());

        StringBuilder causeMessage = new StringBuilder();
        causeMessage.append("Weather temperature has changed to " + event.getWeather().getTemperature() +
                " and weather state has changed to " + event.getWeather().getWeatherState().toString() + ".");

        LOG.info(causeMessage.toString());

        StringBuilder whatToDoMessage = new StringBuilder();

        if (event.getWeather().getTemperature() > 20 &&
                !event.getWeather().getWeatherState().equals(WeatherState.RAINY)) {

            whatToDoMessage.append("Open all windows. Roll up all blinds.");
        }
        else if (event.getWeather().getWeatherState().equals(WeatherState.RAINY)) {
            whatToDoMessage.append("Close all windows. Pull down all blinds.");
        }
        else {
            whatToDoMessage.append("Close all windows. Roll up all blinds.");
        }
        event.setWhatToDo(whatToDoMessage.toString());
    }

}
