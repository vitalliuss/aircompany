package planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private final MilitaryType type;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString()
                .replace("}", ", type=" + type + '}');
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && type == ((MilitaryPlane) o).type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
