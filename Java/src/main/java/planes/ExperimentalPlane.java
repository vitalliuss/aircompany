package planes;

import models.ClassificationLevel;
import models.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane{

    private final ClassificationLevel classificationLevel;
    private final ExperimentalType type;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
        this.type = type;
    }

    public ExperimentalType getType(){ return type; }


    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane that = (ExperimentalPlane) o;
        return (type == that.type && classificationLevel == that.classificationLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.getType(), this.getClassificationLevel());
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + this.getType() + ", classification level= " + this.getClassificationLevel() +
                        '}');
    }
}
