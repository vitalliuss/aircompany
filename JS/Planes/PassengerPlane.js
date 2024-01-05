const Plane = require('./Plane');

class PassengerPlane extends Plane {

    //=================CONSTRUCTORS=================

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    //=================METHODS=================
    get passengersCapacity() {
        return this.passengersCapacity;
    }

    set passengersCapacity(value) {
        this.passengersCapacity = value;
    }
}

module.exports = PassengerPlane;
