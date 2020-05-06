import org.junit.jupiter.api.Assertions;
import planes.ExperimentalPlane;
import models.PlaneClassificationLevels;
import models.ExperimentalPlaneTypes;
import models.MilitaryPlaneTypes;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.BasePlane;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    Airport airport = new Airport(planes);
    private static List<BasePlane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneTypes.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneTypes.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneTypes.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneTypes.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneTypes.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneTypes.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalPlaneTypes.HIGH_ALTITUDE, PlaneClassificationLevels.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalPlaneTypes.VTOL, PlaneClassificationLevels.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        for (MilitaryPlane militaryPlane : airport.getTransportMilitaryPlanes()) {
            Assertions.assertSame(militaryPlane.getPlaneType(), MilitaryPlaneTypes.TRANSPORT);
        }
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Assert.assertEquals(airport.getPassengerPlaneWithMaxPassengersCapacity(), planeWithMaxPassengerCapacity);
    }

    @Test
    public void testPlanesSortedByMaxLoadCapacity() {
        for (int i = 0; i < airport.sortByMaxLoadCapacity().size() - 1; i++) {
            Assert.assertTrue(airport.sortByMaxLoadCapacity().get(i).getMinLoadCapacity() <= airport.sortByMaxLoadCapacity().get(i + 1).getMinLoadCapacity());
        }
    }


    @Test
    public void testGetBomberMilitaryPlanes() {
        for (MilitaryPlane militaryPlane : airport.getBomberMilitaryPlanes()) {
            Assertions.assertSame(militaryPlane.getPlaneType(), MilitaryPlaneTypes.BOMBER);
        }
    }

    @Test
    public void testExperimentalPlanesHasClassifiedLevel() {
        for (ExperimentalPlane planes : airport.getExperimentalPlanes()) {
            Assertions.assertNotSame(planes.getPlaneClassificationLevels(), PlaneClassificationLevels.UNCLASSIFIED);
        }
    }
}
