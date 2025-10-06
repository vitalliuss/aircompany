import models.PlaneType;
import planes.Experimental;
import models.ClassificationLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.Military;
import planes.Passenger;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new Passenger("Boeing-737", 900, 12000, 60500, 164),
            new Passenger("Boeing-737-800", 940, 12300, 63870, 192),
            new Passenger("Boeing-747", 980, 16100, 70500, 242),
            new Passenger("Airbus A320", 930, 11800, 65500, 188),
            new Passenger("Airbus A330", 990, 14800, 80500, 222),
            new Passenger("Embraer 190", 870, 8100, 30800, 64),
            new Passenger("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new Passenger("Bombardier CS300", 920, 11000, 60700, 196),
            new Military("B-1B Lancer", 1050, 21000, 80000, PlaneType.Military.BOMBER),
            new Military("B-2 Spirit", 1030, 22000, 70000, PlaneType.Military.BOMBER),
            new Military("B-52 Stratofortress", 1000, 20000, 80000, PlaneType.Military.BOMBER),
            new Military("F-15", 1500, 12000, 10000, PlaneType.Military.FIGHTER),
            new Military("F-22", 1550, 13000, 11000, PlaneType.Military.FIGHTER),
            new Military("C-130 Hercules", 650, 5000, 110000, PlaneType.Military.TRANSPORT),
            new Experimental("Bell X-14", 277, 482, 500, PlaneType.Experimental.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new Experimental("Ryan X-13 Vertijet", 560, 307, 500, PlaneType.Experimental.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static Passenger planeWithMaxPassengerCapacity = new Passenger("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<Military> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean flag = false;
        for (Military militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == PlaneType.Military.TRANSPORT)) {
                flag = true;
                break;
            }
        }
        Assert.assertEquals(flag, true);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        System.out.println("TEST testGetPassengerPlaneWithMaxCapacity started!");
        Airport airport = new Airport(planes);
        Passenger expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void test3() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<Military> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean flag = false;
        for (Military military : bomberMilitaryPlanes) {
            if ((military.getType() == PlaneType.Military.BOMBER)) {
                flag = true;
            }
            else {
                Assert.fail("Test failed!");
            }
        }
        // if not failed
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);
        List<Experimental> ExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(Experimental experimental : ExperimentalPlanes){
            if(experimental.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
