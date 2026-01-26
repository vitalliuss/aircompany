package planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private final int passengersCapacity;

    public PassengerPlane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity,
            int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = requirePositive(passengersCapacity, "passengersCapacity");
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PassengerPlane)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        PassengerPlane that = (PassengerPlane) obj;
        return passengersCapacity == that.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                super.toString() +
                ", passengersCapacity=" + passengersCapacity +
                '}';
    }
}