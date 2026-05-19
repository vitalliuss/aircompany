package airport;

import java.util.ArrayList;
import java.util.List;

import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.MilitaryType;

public class PlaneFilter {

    //Filtra os aviões de passageiros
    public List<PassengerPlane> getPassengerPlanes(List<Plane> planes) {
        List<Plane> l = planes;
        List<PassengerPlane> x = new ArrayList<>();
        for (Plane p : l) {
            if (p instanceof PassengerPlane) {
                x.add((PassengerPlane) p);
            }
        }
        return x;
    }

    //Filtra os aviões militares
    public List<MilitaryPlane> getMilitaryPlanes(List<Plane> planes) {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            } 
        }
        return militaryPlanes;
    }

    //Filtra os aviões militares de transporte
    public List<MilitaryPlane> getTransportMilitaryPlanes(List<Plane> planes) {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes(planes);
        
        for (MilitaryPlane m : militaryPlanes) {
            if (m.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(m);
            }
        }
        return transportMilitaryPlanes;
    }

    //Filtra os aviões militares de guerra
    public List<MilitaryPlane> getBomberMilitaryPlanes(List<Plane> planes) {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes(planes);
        
        for (MilitaryPlane m : militaryPlanes) {
            if (m.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(m);
            }
        }
        return bomberMilitaryPlanes;

    }

    //Filtra aviões experimentais
    public List<ExperimentalPlane> getExperimentalPlanes(List<Plane> planes) {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    //Busca o avião de passageiros com maior capacidade.
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity(List<Plane> planes) {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes(planes);
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane p : passengerPlanes) {
            if (p.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = p;
            }
        }

        return planeWithMaxCapacity;
    }
}
