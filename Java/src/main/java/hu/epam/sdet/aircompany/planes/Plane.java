package hu.epam.sdet.aircompany.planes;

import java.util.Objects;

import hu.epam.sdet.aircompany.planes.bean.PlaneConfig;

public abstract class Plane {
	
	private PlaneConfig planeConfig;

	public Plane(PlaneConfig planeConfig) {
		this.planeConfig = planeConfig;
	}
	
	public abstract void accept(PlaneVisitor visitor);

	public String getModel() {
		return planeConfig.getModel();
	}

	public int getMaxSpeed() {
		return planeConfig.getMaxSpeed();
	}

	public int getMaxFlightDistance() {
		return planeConfig.getMaxFlightDistance();
	}

	public int getMaxLoadCapacity() {
		return planeConfig.getMaxLoadCapacity();
	}

	@Override
	public String toString() {
		return "Plane{" + "model='" + planeConfig.getModel() + '\'' + ", maxSpeed=" + planeConfig.getMaxSpeed() + ", maxFlightDistance="
				+ planeConfig.getMaxFlightDistance() + ", maxLoadCapacity=" + planeConfig.getMaxLoadCapacity() + '}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(planeConfig);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Plane other = (Plane) obj;
		return Objects.equals(planeConfig, other.planeConfig);
	}


}
