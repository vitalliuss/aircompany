package models;

public class PlaneCharacteristics {
    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;

    public PlaneCharacteristics(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() { return model; }
    public int getMaxSpeed() { return maxSpeed; }
    public int getMaxFlightDistance() { return maxFlightDistance; }
    public int getMaxLoadCapacity() { return maxLoadCapacity; }
}
