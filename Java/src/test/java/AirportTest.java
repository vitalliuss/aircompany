import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AirportTest {

    private static final List<Plane> PLANES = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );
    private static final PassengerPlane PLANE_WITH_MAX_PASSENGERS_CAPACITY =
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    private Airport airport;

    @BeforeMethod
    public void setUp() {
        airport = new Airport(PLANES);
    }

    @Test
    public void getTransportMilitaryPlanesTest() {
        List<MilitaryPlane> transportPlanes = airport.getTransportMilitaryPlanes();

        Assert.assertFalse(transportPlanes.isEmpty(),
                "Expected at least one transport military plane");
        Assert.assertTrue(
                transportPlanes.stream()
                        .allMatch(plane -> plane.getMilitaryType() == MilitaryType.TRANSPORT),
                "All returned planes must be TRANSPORT type"
        );
    }

    @Test
    public void getPassengerPlaneWithMaxPassengersCapacityTest() {
        PassengerPlane actualPlane = airport.getPassengerPlaneWithMaxPassengersCapacity();

        Assert.assertEquals(actualPlane, PLANE_WITH_MAX_PASSENGERS_CAPACITY,
                "Plane with max passengers capacity should match expected plane");
    }

    @Test
    public void sortPlanesByMaxLoadCapacityInAscendingOrderTest() {
        List<? extends Plane> actual = airport
                .sortByMaxLoadCapacity()
                .getPlanes();

        List<Plane> expected = PLANES.stream()
                .sorted(Comparator.comparingInt(Plane::getMaxLoadCapacity))
                .collect(Collectors.toList());

        Assert.assertEquals(actual, expected,"Planes should be sorted by max load capacity in ascending order");
    }

    @Test
    public void getBomberMilitaryPlanesTest() {
        List<MilitaryPlane> bomberPlanes = airport.getBomberMilitaryPlanes();

        Assert.assertFalse(bomberPlanes.isEmpty(),
                "Expected at least one bomber military plane");
        Assert.assertTrue(
                bomberPlanes.stream()
                        .allMatch(plane -> plane.getMilitaryType() == MilitaryType.BOMBER),
                "All returned planes must be BOMBER type"
        );
    }

    @Test
    public void experimentalPlanesShouldBeClassifiedTest() {
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();

        Assert.assertFalse(experimentalPlanes.isEmpty(), "Expected at least one experimental plane");
        Assert.assertTrue(
                experimentalPlanes.stream()
                        .noneMatch(plane -> plane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED),
                "Experimental planes must not contain UNCLASSIFIED classification level"
        );
    }
}