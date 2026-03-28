package cz.cvut.fel.omo.model.details;

/**
 * This class represents consumptions.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Consumption {

    private final int electricityConsumptionPerRoundACTIVE;
    private final int electricityConsumptionPerRoundIDLE;
    private final int waterConsumptionPerRoundACTIVE;
    private final int waterConsumptionPerRoundIDLE;


    /**
     * Constructor for class Consumption.
     */
    public Consumption(int electricityConsumptionPerRoundACTIVE, int electricityConsumptionPerRoundIDLE,
                       int waterConsumptionPerRoundACTIVE, int waterConsumptionPerRoundIDLE) {

        this.electricityConsumptionPerRoundACTIVE = electricityConsumptionPerRoundACTIVE;
        this.electricityConsumptionPerRoundIDLE = electricityConsumptionPerRoundIDLE;
        this.waterConsumptionPerRoundACTIVE = waterConsumptionPerRoundACTIVE;
        this.waterConsumptionPerRoundIDLE = waterConsumptionPerRoundIDLE;
    }

    /**
     * Returns electricity consumption per active round.
     * @return electricityConsumptionPerRoundACTIVE int
     */
    public int getElectricityConsumptionPerRoundACTIVE() {
        return electricityConsumptionPerRoundACTIVE;
    }

    /**
     * Returns electricity consumption per idle round.
     * @return electricityConsumptionPerRoundIDLE int
     */
    public int getElectricityConsumptionPerRoundIDLE() {
        return electricityConsumptionPerRoundIDLE;
    }

    /**
     * Returns water consumption per active round.
     * @return waterConsumptionPerRoundACTIVE int
     */
    public int getWaterConsumptionPerRoundACTIVE() {
        return waterConsumptionPerRoundACTIVE;
    }

    /**
     * Returns water consumption per idle round.
     * @return waterConsumptionPerRoundIDLE int
     */
    public int getWaterConsumptionPerRoundIDLE() {
        return waterConsumptionPerRoundIDLE;
    }
}
