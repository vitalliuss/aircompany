const Plane = require('./plane');

class PassengerPlane extends Plane {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);

        this._passengersCapacity = passengersCapacity;
    }

    get passengersCapacity() {
        return this._passengersCapacity;
    }

    set passengersCapacity(value) {
        this._passengersCapacity = value;
    }
}

module.exports = PassengerPlane;
