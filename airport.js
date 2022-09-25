const PassengerPlane = require("./Planes/passengerPlane");
const MilitaryPlane = require("./Planes/militaryPlane");
const MilitaryType = require("./models/militaryType");
const ExperimentalPlane = require("./Planes/experimentalPlane");

class Airport {
  constructor(planes) {
    this.planes = planes;
  }

  getPassengerPlanes() {
    let passengerPlanes = [];
    for (let plane of this.planes) {
      if (plane instanceof PassengerPlane) {
        passengerPlanes.push(plane);
      }
    }
    return passengerPlanes;
  }

  getMilitaryPlanes() {
    let militaryPlanes = [];
    this.planes.forEach((plane) => {
      if (plane instanceof MilitaryPlane) {
        militaryPlanes.push(plane);
      }
    });
    return militaryPlanes;
  }

  getPassengerPlaneWithMaxPassengersCapacity() {
    let passengerPlanes = this.getPassengerPlanes();
    let planeWithMaxCapacity = passengerPlanes[0];
    for (let element of passengerPlanes) {
      if (element.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()
      ) {planeWithMaxCapacity = element;
      }
    }
    return planeWithMaxCapacity;
  }

  getTransportMilitaryPlanes() {
    let transportMilitaryPlanes = [];
    let militaryPlanes = this.getMilitaryPlanes();
    for (let element of militaryPlanes) {
      if (element.getMilitaryType() == MilitaryType.TYPE_TRANSPORT) {
        transportMilitaryPlanes.push(element);
      }
    }
    return transportMilitaryPlanes;
  }

  getBomberMilitaryPlanes() {
    let bomberMilitaryPlanes = [];
    let militaryPlanes = this.getMilitaryPlanes();
    for (let element of militaryPlanes) {
      if (element.getMilitaryType() === MilitaryType.BOMBER) {
        bomberMilitaryPlanes.push(element);
      }
    }
    return bomberMilitaryPlanes;
  }

  getExperimentalPlanes() {
    let experimentalPlanes = [];
    this.planes.forEach((plane) => {
      if (plane instanceof ExperimentalPlane) {
        experimentalPlanes.push(plane);
      }
    });
    return experimentalPlanes;
  }

  sortByMaxDistance() {
    this.planes.sort((a, b) => a.getMaxFlightDistance() - b.getMaxFlightDistance());
    return this;
  }

  sortByMaxSpeed() {
    this.planes.sort((a, b) => a.getMaxSpeed() - b.getMaxSpeed());
    return this;
  }

  sortByMaxLoadCapacity() {this.planes.sort((a, b) => a.getMinLoadCapacity() - b.getMinLoadCapacity());
    return this;
  }

  getPlanes() {
    return this.planes;
  }

  static print(planes) {
    return JSON.stringify(planes);
  }
}

module.exports = Airport;
