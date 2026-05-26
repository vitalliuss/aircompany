package Planes;

import models.PlaneCharacteristics;
import java.util.Objects;

abstract public class Plane {
   
    private final PlaneCharacteristics characteristics;

    public Plane(PlaneCharacteristics characteristics) {
        this.characteristics = characteristics;
    }

    public String getModel() {
        return characteristics.getModel();
    }

    public int getMaxSpeed() {
        return characteristics.getMaxSpeed();
    }

    public int getMaxFlightDistance() {
        return characteristics.getMaxFlightDistance();
    }

    public int getMaxLoadCapacity() {
        return characteristics.getMaxLoadCapacity();
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + getModel() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", maxFlightDistance=" + getMaxFlightDistance() +
                ", maxLoadCapacity=" + getMaxLoadCapacity() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return getMaxSpeed() == plane.getMaxSpeed() &&
                getMaxFlightDistance() == plane.getMaxFlightDistance() &&
                getMaxLoadCapacity() == plane.getMaxLoadCapacity() &&
                Objects.equals(getModel(), plane.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getMaxSpeed(), getMaxFlightDistance(), getMaxLoadCapacity());
    }
}
