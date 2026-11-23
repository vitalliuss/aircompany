package hu.epam.sdet.aircompany;

import hu.epam.sdet.aircompany.models.MilitaryType;
import hu.epam.sdet.aircompany.planes.MilitaryPlane;
import hu.epam.sdet.aircompany.planes.PassengerPlane;
import hu.epam.sdet.aircompany.planes.Plane;
import hu.epam.sdet.aircompany.planes.bean.PlaneConfig;

import java.util.Arrays;
import java.util.List;

public class Main {
    static List<Plane> planes = Arrays.asList(new PassengerPlane(new PlaneConfig("Boeing-737", 900, 12000, 60500), 164),
            new PassengerPlane(new PlaneConfig("Boeing-737-800", 940, 12300, 63870), 192),
            new PassengerPlane(new PlaneConfig("Boeing-747", 980, 16100, 70500), 242),
            new PassengerPlane(new PlaneConfig("Airbus A320", 930, 11800, 65500), 188),
            new PassengerPlane(new PlaneConfig("Airbus A330", 990, 14800, 80500), 222),
            new PassengerPlane(new PlaneConfig("Embraer 190", 870, 8100, 30800), 64),
            new PassengerPlane(new PlaneConfig("Sukhoi Superjet 100", 870, 11500, 50500), 140),
            new PassengerPlane(new PlaneConfig("Bombardier CS300", 920, 11000, 60700), 196),
            new MilitaryPlane(new PlaneConfig("B-1B Lancer", 1050, 21000, 80000), MilitaryType.BOMBER),
            new MilitaryPlane(new PlaneConfig("B-2 Spirit", 1030, 22000, 70000), MilitaryType.BOMBER),
            new MilitaryPlane(new PlaneConfig("B-52 Stratofortress", 1000, 20000, 80000), MilitaryType.BOMBER),
            new MilitaryPlane(new PlaneConfig("F-15", 1500, 12000, 10000), MilitaryType.FIGHTER),
            new MilitaryPlane(new PlaneConfig("F-22", 1550, 13000, 11000), MilitaryType.FIGHTER),
            new MilitaryPlane(new PlaneConfig("C-130 Hercules", 650, 5000, 110000), MilitaryType.TRANSPORT));

    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: "
                + militaryAirport.getPlanesSortedByMaxDistance().toString());
        System.out.println(
                "Passenger airport sorted by max speed: " + passengerAirport.getPlanesSortedByMaxSpeed().toString());

        System.out.println(
                "Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
