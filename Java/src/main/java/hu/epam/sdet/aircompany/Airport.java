package hu.epam.sdet.aircompany;

import hu.epam.sdet.aircompany.models.MilitaryType;
import hu.epam.sdet.aircompany.planes.MilitaryPlane;
import hu.epam.sdet.aircompany.planes.PassengerPlane;
import hu.epam.sdet.aircompany.planes.Plane;
import hu.epam.sdet.aircompany.planes.PlaneVisitor;
import hu.epam.sdet.aircompany.planes.ExperimentalPlane;

import java.util.*;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {

	private List<? extends Plane> planes;

	public Airport(List<? extends Plane> planes) {
		this.planes = planes;
	}

	public List<PassengerPlane> getPassengerPlanes() {
		List<PassengerPlane> passengerPlanes = new ArrayList<>();
		PlaneVisitor visitor = new PlaneVisitor() {
			@Override
			public void visit(PassengerPlane plane) {
				passengerPlanes.add(plane);
			}
		};
		for (Plane plane : planes) {
			plane.accept(visitor);
		}
		return passengerPlanes;
	}

	public List<MilitaryPlane> getMilitaryPlanes() {
		List<MilitaryPlane> militaryPlanes = new ArrayList<>();
		PlaneVisitor visitor = new PlaneVisitor() {
			@Override
			public void visit(MilitaryPlane plane) {
				militaryPlanes.add(plane);
			}
		};
		for (Plane plane : planes) {
			plane.accept(visitor);
		}
		return militaryPlanes;
	}

	public Optional<PassengerPlane> getPassengerPlaneWithMaxPassengersCapacity() {
		return getPassengerPlanes().stream().max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity));
	}

	public List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType militaryType) {
		return getMilitaryPlanes().stream().filter(e -> e.getType() == militaryType).collect(Collectors.toList());
	}

	public List<ExperimentalPlane> getExperimentalPlanes() {
		List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
		PlaneVisitor visitor = new PlaneVisitor() {
			@Override
			public void visit(ExperimentalPlane plane) {
				experimentalPlanes.add(plane);
			}
		};
		for (Plane plane : planes) {
			plane.accept(visitor);
		}
		return experimentalPlanes;
	}

	public List<Plane> getPlanesSortedByMaxDistance() {
		return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxFlightDistance))
				.collect(Collectors.toList());
	}

	public List<Plane> getPlanesSortedByMaxSpeed() {
		return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxSpeed)).collect(Collectors.toList());
	}

	public List<Plane> getPlanesSortedByMaxLoadCapacity() {
		return planes.stream().sorted(Comparator.comparingInt(Plane::getMaxLoadCapacity)).collect(Collectors.toList());
	}

	public List<Plane> getPlanes() {
		return new ArrayList<>(planes);
	}

	@Override
	public String toString() {
		return "Airport{" + "Planes=" + planes.toString() + '}';
	}

}
