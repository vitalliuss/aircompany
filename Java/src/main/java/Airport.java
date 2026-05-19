import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    //Lista de aviões
    /*Podendo ser de: Passageiros, militares e até experimentais */
    private List<Plane> planes;

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = new ArrayList<>(planes);
    }

    //Filtra os aviões de passageiros
    public List<PassengerPlane> getPassengerPlanes() {
        List<Plane> l = this.planes;
        List<PassengerPlane> x = new ArrayList<>();
        for (Plane p : l) {
            if (p instanceof PassengerPlane) {
                x.add((PassengerPlane) p);
            }
        }
        return x;
    }

    //Filtra os aviões militares
    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            } 
        }
        return militaryPlanes;
    }

    //Busca o avião de passageiros com maior capacidade.
    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane p : passengerPlanes) {
            if (p.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = p;
            }
        }

        return planeWithMaxCapacity;
    }

    //Filtra os aviões militares de transporte
    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        
        for (MilitaryPlane m : militaryPlanes) {
            if (m.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(m);
            }
        }
        return transportMilitaryPlanes;
    }

    //Filtra os aviões militares de guerra
    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        
        for (MilitaryPlane m : militaryPlanes) {
            if (m.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(m);
            }
        }
        return bomberMilitaryPlanes;

    }

    //Filtra aviões experimentais
    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    //Ordena aviões com distância maxima de voo
    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
            }
        });
        return this;
    }

    // Ordena aviões por velocidade maxima 
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMS() - o2.getMS();
            }
        });
        return this;
    }

    //Ordena aviões por capacidade de carga
    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
            }
        });
        return this;
    }

    //Retorna a lista de aviões
    public List<Plane> getPlanes() {
        return planes;
    }

    //Imprime aviões no terminal
    private void print(Collection<Plane> collection) {
        Iterator<Plane> iterator = collection.iterator();
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



}
