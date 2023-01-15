import Planes.experimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;



    public List<PassengerPlane> getPasPl() {
        List<PassengerPlane> x = new ArrayList<>();
        for (Plane p : planes) {if (p instanceof PassengerPlane) {x.add((PassengerPlane) p);}}
        return x;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        } //for
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPasPl();
        Collections.sort(passengerPlanes, new Comparator<PassengerPlane>() {
            public int compare(PassengerPlane o1, PassengerPlane o2) {
                return o1.getPassengersCapacity() - o2.getPassengersCapacity();
            }
        });
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlanes().removeif(plane -> plane.getType != MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlanes().removeif(plane -> plane.getType != MilitaryType.BOMBER);
    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
            }
        });
        return this;
    }


    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMS() - o2.getMS();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
