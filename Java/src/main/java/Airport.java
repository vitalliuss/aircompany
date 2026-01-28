import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.MilitaryType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes == null ? java.util.Collections.emptyList() : planes.stream()
                .filter(PassengerPlane.class::isInstance)
                .map(PassengerPlane.class::cast)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public Optional<PassengerPlane> getPassengerPlaneWithMaxCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        return passengerPlanes.stream()
                .max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity));
    }

    private List<MilitaryPlane> filterMilitaryPlanesByType(MilitaryType type) {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        if (militaryPlanes == null || militaryPlanes.isEmpty()) return java.util.Collections.emptyList();
        return militaryPlanes.stream()
                .filter(plane -> plane.getType() == type)
                .collect(java.util.stream.Collectors.toList());
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return filterMilitaryPlanesByType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return filterMilitaryPlanesByType(MilitaryType.BOMBER);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        if (planes != null && !planes.isEmpty()) {
            planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        }
        return this;
    }

    public Airport sortByMaxSpeed() {
        if (planes != null && !planes.isEmpty()) {
            planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        }
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        if (planes != null && !planes.isEmpty()) {
            planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        }
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "planes=" + planes +
                '}';
    }
}
