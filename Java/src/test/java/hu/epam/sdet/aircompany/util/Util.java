package hu.epam.sdet.aircompany.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;

import hu.epam.sdet.aircompany.planes.Plane;

public class Util {

	public static void assertLists(List<? extends Plane> expectedPlanes,
			List<? extends Plane> actualPlanes) {
		Comparator<Plane> byModel = Comparator.comparing(Plane::getModel);
		List<Plane> sortedExpected = new ArrayList<>(expectedPlanes);
		sortedExpected.sort(byModel);
		List<Plane> sortedActual = new ArrayList<>(actualPlanes);
		sortedActual.sort(byModel);
		Assert.assertEquals(sortedExpected, sortedActual);
	}

}
