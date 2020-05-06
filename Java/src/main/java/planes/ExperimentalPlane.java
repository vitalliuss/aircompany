package planes;

import models.PlaneClassificationLevels;
import models.ExperimentalPlaneTypes;

public class ExperimentalPlane extends BasePlane {

    private ExperimentalPlaneTypes planeType;
    private PlaneClassificationLevels planeClassificationLevels;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneTypes planeType, PlaneClassificationLevels planeClassificationLevels) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.planeType = planeType;
        this.planeClassificationLevels = planeClassificationLevels;
    }

    public PlaneClassificationLevels getPlaneClassificationLevels() {
        return planeClassificationLevels;
    }

    public void setPlaneClassificationLevels(PlaneClassificationLevels planeClassificationLevels) {
        this.planeClassificationLevels = planeClassificationLevels;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "planeType=" + planeType +
                ", planeClassificationLevels=" + planeClassificationLevels +
                '}';
    }
}
