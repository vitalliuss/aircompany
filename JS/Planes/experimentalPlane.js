const Plane = require('./Plane');

class ExperimentalPlane extends Plane {
  constructor(
    model,
    maxSpeed,
    maxFlightDistance,
    maxLoadCapacity,
    type,
    classificationLevel
  ) {
    super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    this.model = model;
    this.maxSpeed = maxSpeed;
    this.maxFlightDistance = maxFlightDistance;
    this.maxLoadCapacity = maxLoadCapacity;
    this.type = type;
    this.classificationLevel = classificationLevel;
  }

  get model() {
    return this.model;
  }

  set model(value) {
    this.model = value;
  }

  get maxSpeed() {
    return this.maxSpeed;
  }

  set maxSpeed(value) {
    this.maxSpeed = value;
  }

  get maxFlightDistance() {
    return this.maxFlightDistance;
  }

  set maxFlightDistance(value) {
    this.maxFlightDistance = value;
  }

  get maxLoadCapacity() {
    return this.maxLoadCapacity;
  }

  set maxLoadCapacity(value) {
    this.maxLoadCapacity = value;
  }

  get type() {
    return this.type;
  }

  set type(value) {
    this.type = value;
  }

  get classificationLevel() {
    return this.classificationLevel;
  }

  set classificationLevel(value) {
    this.classificationLevel = value;
  }
}

module.exports = ExperimentalPlane;
