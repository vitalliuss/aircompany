const Plane = require('./Plane');

class PassengerPlane extends Plane {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this._passengersCapacity = passengersCapacity;
    }

    getPassengersCapacity() {
        return this._passengersCapacity;
    }

    setPassengersCapacity(value) {
        this._passengersCapacity = value;
    }
}

module.exports = PassengerPlane;