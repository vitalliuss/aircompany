package hu.epam.sdet.aircompany.planes;

public class MyPlane  extends Plane {
    public MyPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
    
    @Override
    public void accept(PlaneVisitor visitor) {
        visitor.visit(this);
    }

    //TODO implement it later
}
