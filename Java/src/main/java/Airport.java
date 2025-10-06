import models.PlaneType;
import planes.Experimental;
import planes.Military;
import planes.Passenger;
import planes.Plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;


    public List<Passenger> getPasPl() {
        List<? extends Plane> l = this.planes;
        List<Passenger> x = new ArrayList<>();
        for (Plane p : l) {
            if (p instanceof Passenger) {
                x.add((Passenger) p);
            }
        }
        return x;
    }

    public List<Military> getMilitaryPlanes() {
        List<Military> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof Military) {
                militaryPlanes.add((Military) plane);
            } //if
            else {

            } // else
        } //for
        return militaryPlanes;
    }

    public Passenger getPassengerPlaneWithMaxPassengersCapacity() {
        List<Passenger> passengerPlanes = getPasPl();
        Passenger planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }


        return planeWithMaxCapacity;
    }

    public List<Military> getTransportMilitaryPlanes() {
        List<Military> transportMilitaryPlanes = new ArrayList<>();
        List<Military> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            Military plane = militaryPlanes.get(i);
            if (plane.getType() == PlaneType.Military.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<Military> getBomberMilitaryPlanes() {
        List<Military> bomberMilitaryPlanes = new ArrayList<>();
        List<Military> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
            Military plane = militaryPlanes.get(i);
            if (plane.getType() == PlaneType.Military.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<Experimental> getExperimentalPlanes() {
        List<Experimental> ExperimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof Experimental) {
                ExperimentalPlanes.add((Experimental) plane);
            }
        }
        return ExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }


    /**
     * Sorts by max speed
     *
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
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
