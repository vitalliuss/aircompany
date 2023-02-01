package planes;

import java.util.Objects;

public class PassengerPlane extends Plane{

    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }


    //=================METHODS=================
    public int getPassengersCapacity() {
        return this.passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace(
                "}",
                ", passengersCapacity=" + passengersCapacity + '}');
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof PassengerPlane)) return false;
        if (!super.equals(other)) return false;
        PassengerPlane plane = (PassengerPlane) other;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
