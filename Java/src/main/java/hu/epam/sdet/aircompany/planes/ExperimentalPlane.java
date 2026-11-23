package hu.epam.sdet.aircompany.planes;

import hu.epam.sdet.aircompany.models.ClassificationLevel;

public class ExperimentalPlane extends Plane {

	private ClassificationLevel classificationLevel;

	public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
			ClassificationLevel classificationLevel) {
		super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
		this.classificationLevel = classificationLevel;
	}

	public ClassificationLevel getClassificationLevel() {
		return classificationLevel;
	}

	public void setClassificationLevel(ClassificationLevel classificationLevel) {
		this.classificationLevel = classificationLevel;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "experimentalPlane{" + "model='" + getModel() + '\'' + '}';
	}
}
