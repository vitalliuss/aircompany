const PlaneSettings = require('./PlaneSettings');

class ExperimentalPlane extends PlaneSettings {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, type, classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
        this.type = type;
        this.classificationLevel = classificationLevel;
    }


    getmodel() {
        return this.model;
    }

    setmodel(value) {
        this.model = value;
    }

    getmaxSpeed() {
        return this.maxSpeed;
    }

    setmaxSpeed(value) {
        this.maxSpeed = value;
    }

    getmaxFlightDistance() {
        return this.maxFlightDistance;
    }

    setmaxFlightDistance(value) {
        this.maxFlightDistance = value;
    }

    getmaxLoadCapacity() {
        return this.maxLoadCapacity;
    }

    setmaxLoadCapacity(value) {
        this.maxLoadCapacity = value;
    }

    gettype() {
        return this.type;
    }

    settype(value) {
        this.type = value;
    }

    getclassificationLevel() {
        return this.classificationLevel;
    }

    setclassificationLevel(value) {
        this.classificationLevel = value;
    }
}

module.exports = ExperimentalPlane