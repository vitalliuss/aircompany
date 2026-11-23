package hu.epam.sdet.aircompany.planes;

import hu.epam.sdet.aircompany.planes.bean.PlaneConfig;

public class MyPlane extends Plane {
    public MyPlane(PlaneConfig planeConfig) {
        super(planeConfig);
    }

    @Override
    public void accept(PlaneVisitor visitor) {
        visitor.visit(this);
    }

    // TODO implement it later
}
