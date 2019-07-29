const Plane = require('./Plane');

class PassengerPlane extends Plane {

    //=================CONSTRUCTORS=================

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this._passengersCapacity = passengersCapacity;
    }

    //=================METHODS=================
    getPassengersCapacity() {
        return this._passengersCapacity;
    }

    // set passengersCapacity(value) {
    //     this._passengersCapacity = value;
    // }
}

module.exports = PassengerPlane;