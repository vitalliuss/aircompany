const Plane = require("./plane");

class ExperimentalPlane extends Plane {
  constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, type, classificationLevel) {
    super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    this.type = type;
    this.classificationLevel = classificationLevel;
  }

  getType() {
    return this.type;
  }

  getClassificationLevel() {
    return this.classificationLevel;
  }
}

module.exports = ExperimentalPlane;
