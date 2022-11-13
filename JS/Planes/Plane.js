class Plane {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity) {
        this._model = model;
        this._maxSpeed = maxSpeed;
        this._maxFlightDistance = maxFlightDistance;
        this._maxLoadCapacity = maxLoadCapacity;
    }

    get model() {
        return this._model;
    }

    set model(value) {
        this._model = value;
    }

    get maxSpeed() {
        return this._maxSpeed;
    }

    set maxSpeed(value) {
        this._maxSpeed = value;
    }

    get maxFlightDistance() {
        return this._maxFlightDistance;
    }

    set maxFlightDistance(value) {
        this._maxFlightDistance = value;
    }

    get maxLoadCapacity() {
        return this._maxLoadCapacity;
    }

    set maxLoadCapacity(value) {
        this._maxLoadCapacity = value;
    }
}

module.exports = Plane;
