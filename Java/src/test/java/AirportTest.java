import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
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
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        Assert.assertEquals(airport.getTransportMilitaryPlanes().get(0).getType(), MilitaryType.TRANSPORT);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes).sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(0).getModel(), "Bell X-14");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(1).getModel(), "Ryan X-13 Vertijet");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(2).getModel(), "F-15");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(3).getModel(), "F-22");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(4).getModel(), "Embraer 190");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(5).getModel(), "Sukhoi Superjet 100");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(6).getModel(), "Boeing-737");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(7).getModel(), "Bombardier CS300");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(8).getModel(), "Boeing-737-800");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(9).getModel(), "Airbus A320");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(10).getModel(), "B-2 Spirit");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(11).getModel(), "Boeing-747");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(12).getModel(), "B-1B Lancer");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(13).getModel(), "B-52 Stratofortress");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(14).getModel(), "Airbus A330");
        Assert.assertEquals(planesSortedByMaxLoadCapacity.get(15).getModel(), "C-130 Hercules");
    }

    @Test
    public void testGetBomberMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertEquals(bomberMilitaryPlanes.get(0).getType(), MilitaryType.BOMBER);
        Assert.assertEquals(bomberMilitaryPlanes.get(1).getType(), MilitaryType.BOMBER);
        Assert.assertEquals(bomberMilitaryPlanes.get(2).getType(), MilitaryType.BOMBER);
    }

    @Test
    public void testGetExperimentalPlanes(){
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        Assert.assertNotEquals(experimentalPlanes.get(0).getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
        Assert.assertNotEquals(experimentalPlanes.get(1).getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
    }
}
