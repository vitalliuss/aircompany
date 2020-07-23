package airports;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import models.MilitaryType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public <T extends Plane> List<T> getPlanesByClass(Class<T> clazz) {
        return planes.stream()
                .filter(v -> v.getClass() == clazz)
                .map(v -> (T) v)
                .collect(Collectors.toList());
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return this.getPlanesByClass(PassengerPlane.class);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.getPlanesByClass(ExperimentalPlane.class);
    }

    public List<MilitaryPlane> getMilitaryPlanesByMilitaryType(MilitaryType... types) {
        return this.getPlanesByClass(MilitaryPlane.class).stream()
                .filter(v -> Arrays.asList(types).contains(v.getMilitaryType()))
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanesByMilitaryType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanesByMilitaryType(MilitaryType.BOMBER);
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        passengerPlanes.sort(Comparator.comparingInt(PassengerPlane::getPassengersCapacity).reversed());
        return passengerPlanes.get(0);
    }

    public Airport sort(Comparator<Plane> comparator) {
        planes.sort(comparator);
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> planes) {
        planes.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "airports.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
