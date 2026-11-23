package hu.epam.sdet.aircompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import hu.epam.sdet.aircompany.models.ClassificationLevel;
import hu.epam.sdet.aircompany.models.MilitaryType;
import hu.epam.sdet.aircompany.planes.ExperimentalPlane;
import hu.epam.sdet.aircompany.planes.MilitaryPlane;
import hu.epam.sdet.aircompany.planes.PassengerPlane;
import hu.epam.sdet.aircompany.planes.Plane;
import hu.epam.sdet.aircompany.planes.bean.PlaneConfig;
import hu.epam.sdet.aircompany.util.Util;

public class AirportTest {

	private static List<Plane> planes = Arrays.asList(
			new PassengerPlane(new PlaneConfig("Boeing-737", 900, 12000, 60500), 164),
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
			new MilitaryPlane(new PlaneConfig("C-130 Hercules", 650, 5000, 110000), MilitaryType.TRANSPORT),
			new MilitaryPlane(new PlaneConfig("C-131 Xena", 651, 5001, 110001), MilitaryType.TRANSPORT),
			new MilitaryPlane(new PlaneConfig("C-132 Xena-and-Hercules", 652, 5002, 110002), MilitaryType.TRANSPORT),
			new ExperimentalPlane(new PlaneConfig("Bell X-14", 277, 482, 500), ClassificationLevel.SECRET),
			new ExperimentalPlane(new PlaneConfig("Ryan X-13 Vertijet", 560, 307, 500),
					ClassificationLevel.TOP_SECRET));

	@Test
	public void testGetTransportMilitaryPlanes() {
		Airport airport = new Airport(planes);
		List<MilitaryPlane> expectedTransportMilitaryPlanes = Arrays.asList(
				new MilitaryPlane(new PlaneConfig("C-130 Hercules", 650, 5000, 110000), MilitaryType.TRANSPORT),
				new MilitaryPlane(new PlaneConfig("C-131 Xena", 651, 5001, 110001), MilitaryType.TRANSPORT),
				new MilitaryPlane(new PlaneConfig("C-132 Xena-and-Hercules", 652, 5002, 110002),
						MilitaryType.TRANSPORT));
		List<MilitaryPlane> actualTransportMilitaryPlanes = airport.getMilitaryPlanesByType(MilitaryType.TRANSPORT);
		Util.assertLists(expectedTransportMilitaryPlanes, actualTransportMilitaryPlanes);
	}

	@Test
	public void testGetPassengerPlaneWithMaxCapacity() {
		Airport airport = new Airport(planes);
		PassengerPlane expectedPlaneWithMaxPassengerCapacity = new PassengerPlane(
				new PlaneConfig("Boeing-747", 980, 16100, 70500), 242);
		Optional<PassengerPlane> expectedPlaneWithMaxPassengersCapacity = airport
				.getPassengerPlaneWithMaxPassengersCapacity();
		Assert.assertTrue(
				expectedPlaneWithMaxPassengersCapacity.equals(Optional.of(expectedPlaneWithMaxPassengerCapacity)));
	}

	@Test
	public void testGetPlanesSortedByMaxLoadCapacity() {
		Airport airport = new Airport(planes);
		List<Plane> expectedPlanesSortedByMaxLoadCapacity = new ArrayList<>(planes);
		expectedPlanesSortedByMaxLoadCapacity.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
		List<Plane> actualPlanesSortedByMaxLoadCapacity = airport.getPlanesSortedByMaxLoadCapacity();
		Assert.assertEquals(expectedPlanesSortedByMaxLoadCapacity, actualPlanesSortedByMaxLoadCapacity);
	}

	@Test
	public void testGetBomberInMilitaryPlanes() {
		Airport airport = new Airport(planes);
		List<MilitaryPlane> expectedTransportMilitaryPlanes = Arrays.asList(
				new MilitaryPlane(new PlaneConfig("B-1B Lancer", 1050, 21000, 80000), MilitaryType.BOMBER),
				new MilitaryPlane(new PlaneConfig("B-2 Spirit", 1030, 22000, 70000), MilitaryType.BOMBER),
				new MilitaryPlane(new PlaneConfig("B-52 Stratofortress", 1000, 20000, 80000), MilitaryType.BOMBER));
		List<MilitaryPlane> actualTransportMilitaryPlanes = airport.getMilitaryPlanesByType(MilitaryType.BOMBER);
		Util.assertLists(expectedTransportMilitaryPlanes, actualTransportMilitaryPlanes);
	}

	@Test
	public void testGetExperimentalPlanes() {
		Airport airport = new Airport(planes);
		List<ExperimentalPlane> expectedExperimentalPlanes = Arrays.asList(
				new ExperimentalPlane(new PlaneConfig("Bell X-14", 277, 482, 500), ClassificationLevel.SECRET),
				new ExperimentalPlane(new PlaneConfig("Ryan X-13 Vertijet", 560, 307, 500),
						ClassificationLevel.TOP_SECRET));
		List<ExperimentalPlane> actualExperimentalPlanes = airport.getExperimentalPlanes();
		Util.assertLists(expectedExperimentalPlanes, actualExperimentalPlanes);
	}
}
