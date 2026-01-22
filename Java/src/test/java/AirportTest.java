import models.PlaneType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import planes.ExperimentalPlane;
import models.ClassificationLevel;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AirportTest {

    private Airport airport;

    @BeforeEach
    void setUp() {
        airport = new Airport(TestData.getSamplePlanes());
    }


    @Test
    public void shouldReturnOnlyTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean isTransportMilitary = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == PlaneType.Military.TRANSPORT)) {
                isTransportMilitary = true;
                break;
            }
        }
        assertTrue(isTransportMilitary, "Expected at least one transport military plane, but none were found.");
    }

    @Test
    public void shouldReturnPassengerPlaneWithMaxCapacity() {
        PassengerPlane actual = airport.getPassengerPlaneWithMaxPassengersCapacity();
        PassengerPlane expected = TestData.getPlaneWithMaxPassengerCapacity();
        assertEquals(expected, actual, "The passenger plane with max capacity does not match the expected one.");
    }


    @Test
    public void shouldSortPlanesByMaxLoadCapacity() {
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> sortedPlanes = airport.getPlanes();

        boolean isSortedByMaxLoadCapacity = true;
        for (int i = 0; i < sortedPlanes.size() - 1; i++) {
            Plane currentPlane = sortedPlanes.get(i);
            Plane nextPlane = sortedPlanes.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                isSortedByMaxLoadCapacity = false;
                break;
            }
        }
        assertTrue(isSortedByMaxLoadCapacity, "Planes are not sorted by max load capacity in ascending order.");
    }

    @Test
    public void shouldContainAtLeastOneBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean isMilitaryBomberPresent = false;
        for (MilitaryPlane military : bomberMilitaryPlanes) {
            if ((military.getType() == PlaneType.Military.BOMBER)) {
                isMilitaryBomberPresent = true;
                break;
            }
        }
        assertTrue(isMilitaryBomberPresent, "Expected at least one bomber military plane, but none were found.");
    }

    @Test
    public void experimentalPlanesShouldNotBeUnclassified() {
        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for (ExperimentalPlane experimental : ExperimentalPlanes) {
            if (experimental.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        assertFalse(hasUnclassifiedPlanes, "Found experimental planes with UNCLASSIFIED classification level.");
    }
}
