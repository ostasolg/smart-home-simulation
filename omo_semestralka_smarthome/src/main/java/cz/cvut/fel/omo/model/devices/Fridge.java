package cz.cvut.fel.omo.model.devices;

import cz.cvut.fel.omo.deviceStates.DeviceState;
import cz.cvut.fel.omo.model.details.Consumption;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents fridge.
 *
 * @author Oľga Ostashchuk, Tereza Lodrová, Michal Pechník
 * @version 1.0
 */
public class Fridge extends Device {

    private List<String> content;

    /**
     * Creates new Fridge with given name ,consumption and state.
     * @param name name of the device
     * @param consumption consumption of the device
     * @param deviceState state of device

     */
    public Fridge(String name, Consumption consumption, DeviceState deviceState, String descriptionOfAction) {
        super(deviceState, consumption, name, descriptionOfAction);
        content = new ArrayList<>();
    }


    /**
     * This method adds food to the fridge.
     * @param food String
     */
    public void addFood(String food) {
        content.add(food);
    }

    /**
     * This method removes food from the fridge.
     */
    public void removeFood(String food) {
        content.remove(food);
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    /**
     * This method returns true if fridge is empty.
     * @return  boolean isEmpty
     */
    public boolean isEmpty(){
        return content.isEmpty();
    }
}
