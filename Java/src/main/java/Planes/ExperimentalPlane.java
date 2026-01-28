package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class ExperimentalPlane extends Plane {
    private final ExperimentalTypes type;
    private final ClassificationLevel classificationLevel;

    private ExperimentalPlane(Builder builder) {
        super(builder.model, builder.maxSpeed, builder.maxFlightDistance, builder.maxLoadCapacity);
        this.type = builder.type;
        this.classificationLevel = builder.classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return type == that.type && classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), type, classificationLevel);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "model='" + super.getModel() + '\'' +
                ", maxSpeed=" + super.getMaxSpeed() +
                ", maxFlightDistance=" + super.getMaxFlightDistance() +
                ", maxLoadCapacity=" + super.getMaxLoadCapacity() +
                ", type=" + type +
                ", classificationLevel=" + classificationLevel +
                '}';
    }

    public static class Builder {
        private final String model;
        private final int maxSpeed;
        private final int maxFlightDistance;
        private int maxLoadCapacity;
        private ExperimentalTypes type;
        private ClassificationLevel classificationLevel;

        public Builder(String model, int maxSpeed, int maxFlightDistance) {
            this.model = model;
            this.maxSpeed = maxSpeed;
            this.maxFlightDistance = maxFlightDistance;
        }

        public Builder maxLoadCapacity(int maxLoadCapacity) {
            this.maxLoadCapacity = maxLoadCapacity;
            return this;
        }

        public ExperimentalPlane build() {
            return new ExperimentalPlane(this);
        }
    }
}
