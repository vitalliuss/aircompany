package planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private final MilitaryType militaryType;

    public MilitaryPlane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity,
            MilitaryType militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = Objects.requireNonNull(militaryType, "militaryType must not be null");
    }

    public MilitaryType getMilitaryType() {
        return militaryType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MilitaryPlane)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        MilitaryPlane that = (MilitaryPlane) obj;
        return Objects.equals(militaryType, that.militaryType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }

    @Override
    public String toString() {
        return "MilitaryPlane{" +
                super.toString() +
                ", militaryType=" + militaryType +
                '}';
    }
}