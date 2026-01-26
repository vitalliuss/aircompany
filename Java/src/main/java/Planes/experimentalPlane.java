package planes;

import models.ClassificationLevel;
import models.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType experimentalType;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(
            String model,
            int maxSpeed,
            int maxFlightDistance,
            int maxLoadCapacity,
            ExperimentalType experimentalType,
            ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = Objects.requireNonNull(experimentalType, "experimentalType must not be null");
        this.classificationLevel = Objects.requireNonNull(classificationLevel, "classificationLevel must not be null");
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExperimentalPlane)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        ExperimentalPlane that = (ExperimentalPlane) obj;

        return experimentalType.equals(that.experimentalType) &&
                classificationLevel.equals(that.classificationLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                super.toString() +
                ", experimentalType=" + experimentalType +
                ", classificationLevel=" + classificationLevel +
                '}';
    }
}
