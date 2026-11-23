package hu.epam.sdet.aircompany;
import hu.epam.sdet.aircompany.models.MilitaryType;
import hu.epam.sdet.aircompany.planes.MilitaryPlane;
import hu.epam.sdet.aircompany.planes.PassengerPlane;
import hu.epam.sdet.aircompany.planes.Plane;
import hu.epam.sdet.aircompany.planes.ExperimentalPlane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
	private List<? extends Plane> planes;

	public List<PassengerPlane> getPassengerPlanes() {
		List<PassengerPlane> passengerPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof PassengerPlane) {
				passengerPlanes.add((PassengerPlane) plane);
			}
		}
		return passengerPlanes;
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		List<MilitaryPlane> militaryPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof MilitaryPlane) {
				militaryPlanes.add((MilitaryPlane) plane);
			}
		}
		return militaryPlanes;
	}

	public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
		List<PassengerPlane> passengerPlanes = getPassengerPlanes();
		PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
		for (int i = 0; i < passengerPlanes.size(); i++) {
			if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
				planeWithMaxCapacity = passengerPlanes.get(i);
			}
		}

		return planeWithMaxCapacity;
	}

	public List<MilitaryPlane> getTransportMilitaryPlanes() {
		List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
		List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
		for (int i = 0; i < militaryPlanes.size(); i++) {
			MilitaryPlane plane = militaryPlanes.get(i);
			if (plane.getType() == MilitaryType.TRANSPORT) {
				transportMilitaryPlanes.add(plane);
			}
		}
		return transportMilitaryPlanes;
	}

	public List<MilitaryPlane> getBomberMilitaryPlanes() {
		List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
		List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
		for (int i = 0; i < militaryPlanes.size(); i++) {
			MilitaryPlane plane = militaryPlanes.get(i);
			if (plane.getType() == MilitaryType.BOMBER) {
				bomberMilitaryPlanes.add(plane);
			}
		}
		return bomberMilitaryPlanes;

	}

	public List<ExperimentalPlane> getExperimentalPlanes() {
		List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
		for (Plane plane : planes) {
			if (plane instanceof ExperimentalPlane) {
				experimentalPlanes.add((ExperimentalPlane) plane);
			}
		}
		return experimentalPlanes;
	}

	public Airport sortByMaxDistance() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
			}
		});
		return this;
	}

	/**
	 * Sorts by max speed
	 * 
	 * @return Airport
	 */
	public Airport sortByMaxSpeed() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMS() - o2.getMS();
			}
		});
		return this;
	}

	public Airport sortByMaxLoadCapacity() {
		Collections.sort(planes, new Comparator<Plane>() {
			public int compare(Plane o1, Plane o2) {
				return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
			}
		});
		return this;
	}

	public List<? extends Plane> getPlanes() {
		return planes;
	}

	@Override
	public String toString() {
		return "Airport{" + "Planes=" + planes.toString() + '}';
	}

	// Constructor
	public Airport(List<? extends Plane> planes) {
		this.planes = planes;
	}

}
