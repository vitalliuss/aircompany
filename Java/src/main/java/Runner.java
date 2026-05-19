import models.MilitaryType;

import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import airport.Airport;
import airport.PlaneFilter;
import airport.PlaneSorter;

import java.util.Arrays;
import java.util.List;

public class Runner {

    static List<Plane> planes = Arrays.asList(

            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),

            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );

    public static void main(String[] args) {

        Airport airport = new Airport(planes);

        PlaneFilter filter = new PlaneFilter();
        PlaneSorter sorter = new PlaneSorter();

        // Filtra aviões militares
        List<MilitaryPlane> militaryPlanes =
                filter.getMilitaryPlanes(airport.getPlanes());

        // Cria aeroporto militar
        Airport militaryAirport = new Airport(militaryPlanes);

        // Ordena por distância máxima
        sorter.sortByMaxDistance(militaryAirport.getPlanes());

        // Exibe resultado
        System.out.println(militaryAirport);

    }
}