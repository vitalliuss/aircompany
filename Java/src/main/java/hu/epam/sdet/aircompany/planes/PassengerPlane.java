package hu.epam.sdet.aircompany.planes;

import java.util.Objects;

import hu.epam.sdet.aircompany.planes.bean.PlaneConfig;

public class PassengerPlane extends Plane {

    private int passengersCapacity;

    public PassengerPlane(PlaneConfig planeConfig, int passengersCapacity) {
        super(planeConfig);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public void accept(PlaneVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", passengersCapacity=" + passengersCapacity + '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        PassengerPlane plane = (PassengerPlane) o;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
