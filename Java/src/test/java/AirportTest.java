import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.ClassificationLevel;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static final List<Plane> PLANES = Arrays.asList(
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

    private static final PassengerPlane PLANE_WITH_MAX_PASSENGER_CAPACITY = PassengerPlane.builder("Boeing-747", 980, 16100).passengersCapacity(242).build();

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(PLANES);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        Assert.assertFalse(transportMilitaryPlanes.isEmpty(), "No transport military planes found");
        Assert.assertTrue(transportMilitaryPlanes.stream()
                        .allMatch(plane -> plane.getType() == MilitaryType.TRANSPORT),
                "Not all planes are of type TRANSPORT");
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(PLANES);
        PassengerPlane actual = airport.getPassengerPlaneWithMaxCapacity().orElse(null);
        Assert.assertEquals(actual, PLANE_WITH_MAX_PASSENGER_CAPACITY);
    }

    @Test
    public void testPlanesSortedByMaxLoadCapacity() {
        Airport airport = new Airport(PLANES);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> sortedPlanes = airport.getPlanes();
        for (int i = 0; i < sortedPlanes.size() - 1; i++) {
            int current = sortedPlanes.get(i).getMaxLoadCapacity();
            int next = sortedPlanes.get(i + 1).getMaxLoadCapacity();
            Assert.assertTrue(current <= next);
        }
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(PLANES);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean hasBomber = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.BOMBER) {
                hasBomber = true;
                break;
            }
        }
        Assert.assertTrue(hasBomber);
    }
}
