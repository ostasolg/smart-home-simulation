package cz.cvut.fel.omo.model.equipments;

/**
 * This class represents car.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Car extends Equipment {

    public Car() {
        super();
        this.name="Car";
    }

    private int capacity = 7;
    private int occupiedSeats = 0;

    public void getInCar() {
        if (occupiedSeats < capacity) {
            occupiedSeats++;
        }
    }

    @Override
    public boolean isFree() {
        if (occupiedSeats < capacity) {
            return true;
        }
        return false;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(int occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }
}
