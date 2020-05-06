import planes.ExperimentalPlane;
import models.MilitaryPlaneTypes;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.BasePlane;

import java.util.*;

/**
 * version: 1.1
 * made by Vitali Shulha
 * 4-Jan-2019
 */

public class Airport {
    private List<? extends BasePlane> planes;

    public Airport(List<? extends BasePlane> planes) {
        this.planes = planes;
    }


    public List<ExperimentalPlane> getExperimentalPlanes() {
        return (List<ExperimentalPlane>) getPlane(ExperimentalPlane.class);
    }

    public List<PassengerPlane> getPassengerPlane() {
        return (List<PassengerPlane>) getPlane(PassengerPlane.class);
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return (List<MilitaryPlane>) getPlane(MilitaryPlane.class);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlaneByType(MilitaryPlaneTypes.TRANSPORT);
    }


    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlaneByType(MilitaryPlaneTypes.BOMBER);
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        passengerPlanes.sort((Comparator<PassengerPlane>) (o1, o2) -> o2.getPassengersCapacity() - o1.getPassengersCapacity());
        return passengerPlanes.get(0);
    }

    public List<? extends BasePlane> getPlane(Class<? extends BasePlane> planeClass) {
        List<BasePlane> planeList = new ArrayList<>();
        for (BasePlane plane : planes) {
            if (plane.getClass().isAssignableFrom(planeClass)) {
                planeList.add(plane);
            }
        }
        return planeList;
    }

    public List<MilitaryPlane> getMilitaryPlaneByType(MilitaryPlaneTypes planeType) {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (MilitaryPlane mp : getMilitaryPlanes()) {
            if (mp.getPlaneType().equals(planeType)) {
                militaryPlanes.add(mp);
            }
        }
        return militaryPlanes;
    }

    public Airport sortByMaxDistance() {
        planes.sort((Comparator<BasePlane>) (o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());
        return this;
    }


    public Airport sortByMaxFlightDistance() {
        planes.sort((Comparator<BasePlane>) (o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort((Comparator<BasePlane>) (o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());
        return this;
    }


    public List<? extends BasePlane> sortByMaxLoadCapacity() {
        planes.sort((Comparator<BasePlane>) (o1, o2) -> o1.getMinLoadCapacity() - o2.getMinLoadCapacity());
        return planes;
    }

    public List<? extends BasePlane> getPlanes() {
        return planes;
    }

    private void printAllPlanesInAirport(Collection<? extends BasePlane> collection) {
        for (BasePlane basePlane : collection) {
            System.out.println(basePlane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
