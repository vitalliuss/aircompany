const PassengerPlane = require('./Planes/PassengerPlane');
const MilitaryPlane = require('./Planes/MilitaryPlane');
const ExperimentalPlane = require('./Planes/ExperimentalPlane');
const militaryTypes = require('./models/militaryTypes');

class Airport {

    constructor(planes) {
        this.planes = planes;
    }

    getPassengerPlanes() {
        return this.getSpecificPlanes(PassengerPlane);
    }

    getPassengerPlaneWithMaxPassengersCapacity() {
        let passengerPlanes = this.getPassengerPlanes();
        let planeWithMaxCapacity = passengerPlanes[0];
        for (let i = 0; i < passengerPlanes.length; i++) {
            if (passengerPlanes[i].getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes[i];
            }
        }
        return planeWithMaxCapacity;
    }

    getExperimentalPlanes() {
        return this.getSpecificPlanes(ExperimentalPlane);
    }

    getMilitaryPlanes() {
        return this.getSpecificPlanes(MilitaryPlane);
    }

    getTransportMilitaryPlanes() {
        return this.getMilitaryPlanesWithType(militaryTypes.TRANSPORT);
    }

    getBomberMilitaryPlanes() {
        return this.getMilitaryPlanesWithType(militaryTypes.BOMBER);
    }

    sortByMaxDistance() {
        this.planes.sort((currentPlane, nextPlane) => (currentPlane.getMaxFlightDistance() > nextPlane.getMaxFlightDistance()) ? 1 : -1);
        return this;
    }

    sortByMaxSpeed() {
        this.planes.sort((currentPlane, nextPlane) => (currentPlane.getMaxSpeed() > nextPlane.getMaxSpeed()) ? 1 : -1);
        return this;
    }

    sortByMaxLoadCapacity() {
        this.planes.sort((currentPlane, nextPlane) => (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) ? 1 : -1);
        return this;
    }

    getMilitaryPlanesWithType(militaryPlaneType) {
        let militaryPlanesWithType = [];
        let militaryPlanes = this.getMilitaryPlanes();
        for (let i = 0; i < militaryPlanes.length; i++) {
            if (militaryPlanes[i].getMilitaryType() === militaryPlaneType) {
                militaryPlanesWithType.push(militaryPlanes[i]);
            }
        }
        return militaryPlanesWithType;
    }

    getExperimentalPlanesWithClassificationLevel(classificationLevel) {
        let experimentalPlanesWithClassificationLevel = [];
        let experimentalPlanes = this.getExperimentalPlanes();
        for (let i = 0; i < experimentalPlanes.length; i++) {
            if (experimentalPlanes[i].classificationLevel === classificationLevel) {
                experimentalPlanesWithClassificationLevel.push(experimentalPlanes[i]);
            }
        }
        return experimentalPlanesWithClassificationLevel;
    }

    getSpecificPlanes(planeType) {
        let specificPlanes = [];
        this.planes.forEach(plane => {
            if (plane instanceof planeType) {
                specificPlanes.push(plane);
            }
        });
        return specificPlanes;
    }

    getPlanes() {
        return this.planes;
    }

    static print(planes) {
        return JSON.stringify(planes);
    }
}

module.exports = Airport;