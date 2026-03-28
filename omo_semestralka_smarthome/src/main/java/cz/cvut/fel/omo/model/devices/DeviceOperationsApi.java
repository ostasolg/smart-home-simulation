package cz.cvut.fel.omo.model.devices;

public interface DeviceOperationsApi {

    public void readManual();

    public void turnOn();

    public void startUsing();

    public void stopUsing();

    public void turnOff();

    public void getBroken();

    public void getFixed();
}
