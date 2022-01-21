const PlaneSettings = require('./PlaneSettings');

class PassengerPlane extends PlaneSettings {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    };

    getPassengersCapacity() {
        return this.passengersCapacity;
    };
};

module.exports = PassengerPlane;