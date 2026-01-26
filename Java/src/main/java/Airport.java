import models.MilitaryType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

public class Airport {

    private final List<Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = new ArrayList<>(Objects.requireNonNull(planes, "planes"));
    }

    public List<Plane> getPlanes() {
        return List.copyOf(planes);
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return filterByType(PassengerPlane.class);
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return filterByType(MilitaryPlane.class);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return filterByType(ExperimentalPlane.class);
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return getPassengerPlanes().stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity))
                .orElseThrow(() -> new NoSuchElementException("No passenger planes in airport"));
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanesByType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanesByType(MilitaryType.BOMBER);
    }

    public Airport sortByMaxDistance() {
        return sortBy(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public Airport sortByMaxSpeed() {
       return sortBy(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public Airport sortByMaxLoadCapacity() {
        return sortBy(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "Airport{planes=" + planes + '}';
    }

    private <T extends Plane> List<T> filterByType(Class<T> type) {
        return planes.stream()
                .filter(type::isInstance)
                .map(type::cast)
                .toList();
    }

    private Airport sortBy(Comparator<? super Plane> comparator) {
        List<Plane> sorted = new ArrayList<>(planes);
        sorted.sort(comparator);
        return new Airport(sorted);
    }

    private List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType type) {
        return getMilitaryPlanes().stream()
                .filter(militaryPlane -> type.equals(militaryPlane.getMilitaryType()))
                .toList();
    }
}
