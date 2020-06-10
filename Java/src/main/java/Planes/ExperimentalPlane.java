package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

import java.util.Objects;

public final class ExperimentalPlane extends Plane {

    private final ExperimentalTypes type;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "type=" + type +
                        ", classificationLevel=" + classificationLevel +
                        "}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return type == that.type &&
                classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, classificationLevel);
    }
}
