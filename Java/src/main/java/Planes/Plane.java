package planes;

import java.util.Objects;

public abstract class Plane {
    private final String model;
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;

    protected static int requirePositive(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be positive, but was: " + value);     }
        return value;
    }

    public Plane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity) {
        this.model = Objects.requireNonNull(model, "model must not be null");
        this.maxSpeed = requirePositive(maxSpeed, "maxSpeed");
        this.maxFlightDistance = requirePositive(maxFlightDistance, "maxFlightDistance");
        this.maxLoadCapacity = requirePositive(maxLoadCapacity, "maxLoadCapacity");
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

        Plane that = (Plane) other;

        return maxSpeed == that.maxSpeed
                && maxFlightDistance == that.maxFlightDistance
                && maxLoadCapacity == that.maxLoadCapacity
                && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }
}
