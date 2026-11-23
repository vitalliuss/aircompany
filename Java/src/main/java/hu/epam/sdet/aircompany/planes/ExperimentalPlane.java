package hu.epam.sdet.aircompany.planes;

import java.util.Objects;

import hu.epam.sdet.aircompany.models.ClassificationLevel;
import hu.epam.sdet.aircompany.planes.bean.PlaneConfig;

public class ExperimentalPlane extends Plane {

	private ClassificationLevel classificationLevel;

	public ExperimentalPlane(PlaneConfig planeConfig,
			ClassificationLevel classificationLevel) {
		super(planeConfig);
		this.classificationLevel = classificationLevel;
	}

	public ClassificationLevel getClassificationLevel() {
		return classificationLevel;
	}

	public void setClassificationLevel(ClassificationLevel classificationLevel) {
		this.classificationLevel = classificationLevel;
	}

	@Override
	public void accept(PlaneVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!super.equals(o)) {
			return false;
		}
		ExperimentalPlane that = (ExperimentalPlane) o;
		return classificationLevel == that.classificationLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), classificationLevel);
	}

	@Override
	public String toString() {
		return "experimentalPlane{" + "model='" + getModel() + '\'' + '}';
	}
}
