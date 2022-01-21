const PlaneSettings = require('./PlaneSettings');

class MilitaryPlane extends PlaneSettings {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = militaryType;
    }

    getMilitaryType() {
        return this.militaryType;
    }
}

module.exports = MilitaryPlane;