const PassengerPlane = require('./Planes/passenger-plane');
const MilitaryPlane = require('./Planes/military-plane');
const ExperimentalPlane = require('./Planes/experimental-plane');

const MILITARY_TYPES = require('./models/military-types');

class Airport {

    constructor(planes) {
        this.planes = planes;
    }

    getPlanes() {
        return this.planes;
    }

    getPassengersPlanes() {
        return this._getPlanesOf(PassengerPlane);
    }

    getMilitaryPlanes() {
        return this._getPlanesOf(MilitaryPlane);
    }

    getExperimentalPlanes() {
        return this._getPlanesOf(ExperimentalPlane);
    }

    getPassengerPlaneWithMaxCapacity() {
        const passengerPlanes = this.getPassengersPlanes();

        return passengerPlanes.reduce(
            (planeWithMaxCapacity, item) => planeWithMaxCapacity.passengersCapacity < item.passengersCapacity ? item : planeWithMaxCapacity,
            passengerPlanes[0]
        );
    }

    getTransportMilitaryPlanes() {
        return this._getMilitaryPlaneByType(MILITARY_TYPES.TRANSPORT);
    }

    getBomberMilitaryPlanes() {
        return this._getMilitaryPlaneByType(MILITARY_TYPES.BOMBER);
    }

    sortByMaxDistance() {
        this.planes.sort((a, b) => a.maxFlightDistance - b.maxFlightDistance);
        return this;
    }

    sortByMaxSpeed() {
        this.planes.sort((a, b) => a.maxSpeed - b.maxSpeed);
        return this;
    }

    sortByMaxLoadCapacity() {
        this.planes.sort((a, b) => (a.maxLoadCapacity > b.maxLoadCapacity) ? 1 : -1);
        return this;
    }

    static print(planes) {
        return JSON.stringify(planes);
    }

    _getPlanesOf(type) {
        return this.planes.filter(plane => plane instanceof type);
    }

    _getMilitaryPlaneByType(militaryType) {
        return this.getMilitaryPlanes()
            .filter(plane => plane.militaryType === militaryType);
    }
}

module.exports = Airport;
