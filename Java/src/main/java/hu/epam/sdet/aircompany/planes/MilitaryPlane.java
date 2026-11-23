package hu.epam.sdet.aircompany.planes;

import java.util.Objects;

import hu.epam.sdet.aircompany.models.MilitaryType;
import hu.epam.sdet.aircompany.planes.bean.PlaneConfig;

public class MilitaryPlane extends Plane {

    private MilitaryType type;

    public MilitaryPlane(PlaneConfig planeConfig, MilitaryType type) {
        super(planeConfig);
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public void accept(PlaneVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", type=" + type + '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        MilitaryPlane that = (MilitaryPlane) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
