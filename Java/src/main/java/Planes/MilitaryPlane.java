package Planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {
    private final MilitaryType type;

    private MilitaryPlane(Builder builder) {
        super(builder.model, builder.maxSpeed, builder.maxFlightDistance, 0);
        this.type = builder.type;
    }

    public static class Builder {
        private final String model;
        private final int maxSpeed;
        private final int maxFlightDistance;
        private MilitaryType type;

        public Builder(String model, int maxSpeed, int maxFlightDistance) {
            this.model = model;
            this.maxSpeed = maxSpeed;
            this.maxFlightDistance = maxFlightDistance;
        }

        public Builder type(MilitaryType type) {
            this.type = type;
            return this;
        }

        public MilitaryPlane build() {
            return new MilitaryPlane(this);
        }
    }

    public static Builder builder(String model, int maxSpeed, int maxFlightDistance) {
        return new Builder(model, maxSpeed, maxFlightDistance);
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "model='" + super.getModel() + '\'' +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", maxFlightDistance=" + super.getMaxFlightDistance() +
                ", maxLoadCapacity=" + super.getMaxLoadCapacity() +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
