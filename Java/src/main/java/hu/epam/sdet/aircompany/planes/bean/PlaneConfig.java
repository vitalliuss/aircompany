package hu.epam.sdet.aircompany.planes.bean;

import java.util.Objects;

public final class PlaneConfig {

    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;

    public PlaneConfig(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        PlaneConfig that = (PlaneConfig) other;
        return maxSpeed == that.maxSpeed && maxFlightDistance == that.maxFlightDistance
                && maxLoadCapacity == that.maxLoadCapacity && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
