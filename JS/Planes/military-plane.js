const Plane = require('./plane');

class MilitaryPlane extends Plane {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);

        this._militaryType = militaryType;
    }

    get militaryType() {
        return this._militaryType;
    }

    set militaryType(value) {
        this._militaryType = value;
    }
}

module.exports = MilitaryPlane;
