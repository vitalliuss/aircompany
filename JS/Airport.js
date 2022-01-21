const PassengerPlane = require('./Planes/PassengerPlane');
const MilitaryPlane = require('./Planes/MilitaryPlane');
const militaryType = require('./models/militaryType');
const experimentalPlane = require('./Planes/ExperimentalPlane');

class Airport {

    getPassengerPlane() {
        const passengerPlaneList = [];
        for (let p of this.planes) {
            if (p instanceof PassengerPlane) { passengerPlaneList.push(p); }
        };
        return passengerPlaneList;
    };

    getMilitaryPlanes() {
        const militaryPlanes = [];
        this.planes.forEach(plane => {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.push(plane);
            }
            else { }
        });
        return militaryPlanes;
    };

    getPassengerPlaneWithMaxPassengersCapacity() {
        const passengerPlanes = this.getPassengerPlane();
        const planeWithMaxCapacity = passengerPlanes[0];
        for (let i = 0; i < passengerPlanes.length; i++) {
            if (passengerPlanes[i].getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes[i];
            };
        };
        return planeWithMaxCapacity;
    };

    getTransportMilitaryPlanes() {
        const transportMilitaryPlanes = [];
        const militaryPlanes = this.getMilitaryPlanes();
        for (let i = 0; i < militaryPlanes.length; i++) {
            if (militaryPlanes[i].getmilitaryType() == militaryType.typeTransport) {
                transportMilitaryPlanes.push(militaryPlanes[i]);
            };
        };
        return transportMilitaryPlanes;
    };

    getBomberMilitaryPlanes() {
        const bomberMilitaryPlanes = [];
        const militaryPlanes = this.getMilitaryPlanes();
        for (let i = 0; i < militaryPlanes.length; i++) {
            if (militaryPlanes[i].getmilitaryType() === militaryType.typeBomber) {
                bomberMilitaryPlanes.push(militaryPlanes[i]);
            };
        };
        return bomberMilitaryPlanes;
    };

    constructor(planes) {
        this.planes = planes;
    };

    getExperimentalPlanes() {
        const experimentalPlanes = [];
        this.planes.forEach(plane => {
            if (plane instanceof experimentalPlane) {//if
                experimentalPlanes.push(plane);
            };
        });
        return experimentalPlanes;
    };

    sortByMaxDistance() {
        this.planes.sort((a, b) => (a.GetMaxFlightDistance() > b.GetMaxFlightDistance()) ? 1 : -1);
        return this;
    };

    // Sorts by max speed
    // @return Airport

    sortByMaxSpeed() {
        this.planes.sort((a, b) => (a.getMaxSpeed() > b.getMaxSpeed()) ? 1 : -1);
        return this;
    };

    sortByMaxLoadCapacity() {
        this.planes.sort((a, b) => (a.getMinLoadCapacity() > b.getMinLoadCapacity()) ? 1 : -1);
        return this;
    };

    getPlanes() {
        return this.planes;
    };




    static printListOfPlanes(planes) {
        return JSON.stringify(planes);
    };
};

module.exports = Airport;
