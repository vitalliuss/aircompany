package hu.epam.sdet.aircompany.planes;

public interface PlaneVisitor {

    default void visit(PassengerPlane plane) {
    }

    default void visit(MilitaryPlane plane) {
    }

    default void visit(ExperimentalPlane plane) {
    }

    default void visit(MyPlane plane) {
    }

}
