const PlaneSettings = require('./PlaneSettings');

class PlaneInProgress extends PlaneSettings {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    };
};

