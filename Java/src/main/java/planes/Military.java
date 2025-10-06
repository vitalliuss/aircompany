package planes;

import models.PlaneType;


import java.util.Objects;

public class Military extends Plane {

    private final PlaneType.Military type;

    public Military(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, PlaneType.Military type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public PlaneType.Military getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Military)) return false;
        if (!super.equals(o)) return false;
        Military that = (Military) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
