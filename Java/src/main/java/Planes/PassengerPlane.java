package Planes;

import java.util.Objects;

public class PassengerPlane extends Plane {
    private final int passengersCapacity;

    private PassengerPlane(Builder builder) {
        super(builder.model, builder.maxSpeed, builder.maxFlightDistance, 0);
        this.passengersCapacity = builder.passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "model='" + super.getModel() + '\'' +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", maxFlightDistance=" + super.getMaxFlightDistance() +
                ", maxLoadCapacity=" + super.getMaxLoadCapacity() +
                ", passengersCapacity=" + passengersCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }

    public static Builder builder(String model, int maxSpeed, int maxFlightDistance) {
        return new Builder(model, maxSpeed, maxFlightDistance);
    }

    public static class Builder {
        private final String model;
        private final int maxSpeed;
        private final int maxFlightDistance;
        private int passengersCapacity;

        public Builder(String model, int maxSpeed, int maxFlightDistance) {
            this.model = model;
            this.maxSpeed = maxSpeed;
            this.maxFlightDistance = maxFlightDistance;
        }

        public Builder passengersCapacity(int passengersCapacity) {
            this.passengersCapacity = passengersCapacity;
            return this;
        }

        public PassengerPlane build() {
            return new PassengerPlane(this);
        }
    }
}
