import models.PlaneType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return filterPlanesByType(PassengerPlane.class);
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return filterPlanesByType(MilitaryPlane.class);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return filterPlanesByType(ExperimentalPlane.class);
    }


    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes().stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                .orElseThrow(() -> new NoSuchElementException("No passenger planes available"));
    }


    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return filterMilitaryPlanesByType(PlaneType.Military.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return filterMilitaryPlanesByType(PlaneType.Military.BOMBER);
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }


    private List<MilitaryPlane> filterMilitaryPlanesByType(PlaneType.Military type) {
        return getMilitaryPlanes().stream()
                .filter(plane -> plane.getType() == type)
                .collect(Collectors.toList());
    }

    private <T extends Plane> List<T> filterPlanesByType(Class<T> type) {
        return planes.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
