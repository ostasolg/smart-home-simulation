package cz.cvut.fel.omo.runningConfig;

import cz.cvut.fel.omo.model.house.House;
import cz.cvut.fel.omo.model.weather.Weather;

public interface RunningConfig {

    House createRunningConfigOfHouse();
    Weather createRunningConfigOfWeather();
}
