import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.MilitaryType;

import java.util.List;

public class Runner {
    private static final List<Plane> PLANES = java.util.Arrays.asList(
            PassengerPlane.builder("Boeing-737", 900, 12000).passengersCapacity(164).build(),
            PassengerPlane.builder("Boeing-737-800", 940, 12300).passengersCapacity(192).build(),
            PassengerPlane.builder("Boeing-747", 980, 16100).passengersCapacity(242).build(),
            PassengerPlane.builder("Airbus A320", 930, 11800).passengersCapacity(188).build(),
            PassengerPlane.builder("Airbus A330", 990, 14800).passengersCapacity(222).build(),
            PassengerPlane.builder("Embraer 190", 870, 8100).passengersCapacity(64).build(),
            PassengerPlane.builder("Sukhoi Superjet 100", 870, 11500).passengersCapacity(140).build(),
            PassengerPlane.builder("Bombardier CS300", 920, 11000).passengersCapacity(196).build(),
            MilitaryPlane.builder("B-1B Lancer", 1050, 21000).type(MilitaryType.BOMBER).build(),
            MilitaryPlane.builder("B-2 Spirit", 1030, 22000).type(MilitaryType.BOMBER).build(),
            MilitaryPlane.builder("B-52 Stratofortress", 1000, 20000).type(MilitaryType.BOMBER).build(),
            MilitaryPlane.builder("F-15", 1500, 12000).type(MilitaryType.FIGHTER).build(),
            MilitaryPlane.builder("F-22", 1550, 13000).type(MilitaryType.FIGHTER).build(),
            MilitaryPlane.builder("C-130 Hercules", 650, 5000).type(MilitaryType.TRANSPORT).build()
    );

    public static void main(String[] args) {
        Airport airport = new Airport(PLANES);
        List<PassengerPlane> passengerPlanes = airport.getPassengerPlanes();
        List<MilitaryPlane> militaryPlanes = airport.getMilitaryPlanes();
        Airport militaryAirport = new Airport(militaryPlanes);
        Airport passengerAirport = new Airport(passengerPlanes);

        System.out.println("Military airport sorted by max distance: "
                + militaryAirport.sortByMaxDistance());
        System.out.println("Passenger airport sorted by max speed: "
                + passengerAirport.sortByMaxSpeed());
        System.out.println("Plane with max passenger capacity: "
                + passengerAirport.getPassengerPlaneWithMaxCapacity());
    }
}
