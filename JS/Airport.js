const PassengerPlane = require('./Planes/PassengerPlane');
const MilitaryPlane = require('./Planes/MilitaryPlane');
const MilitaryType = require('./models/MilitaryType');
const ExperimentalPlane = require('./Planes/ExperimentalPlane');

class Airport {
  getPassengerPlane() {
    var passengerPlanes = [];
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
    let passengerPlanes = this.getPassengerPlane();
    let planeWithMaxCapacity = passengerPlanes[0];
    for (let i = 0; i < passengerPlanes.length; i++) {
      if (
        passengerPlanes[i].getPassengersCapacity() >
        planeWithMaxCapacity.getPassengersCapacity()
      ) {
        planeWithMaxCapacity = passengerPlanes[i];
      }
    }
    return planeWithMaxCapacity;
  }

  getTransportMilitaryPlanes() {
    let transportMilitaryPlanes = [];
    let militaryPlanes = this.getMilitaryPlanes();
    for (let i = 0; i < militaryPlanes.length; i++) {
      if (
        militaryPlanes[i].getMilitaryType() == MilitaryType.transport
      ) {
        transportMilitaryPlanes.push(militaryPlanes[i]);
      }
    }
    return transportMilitaryPlanes;
  }

  getBomberMilitaryPlanes() {
    let bomberMilitaryPlanes = [];
    let militaryPlanes = this.getMilitaryPlanes();
    for (let i = 0; i < militaryPlanes.length; i++) {
      if (
        militaryPlanes[i].getMilitaryType() === MilitaryType.bomber
      ) {
        bomberMilitaryPlanes.push(militaryPlanes[i]);
      }
    }
    return bomberMilitaryPlanes;
  }

  constructor(planes) {
    this.planes = planes;
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
    this.planes.sort((firstPlane, secondPlane) =>
      firstPlane.Get_Max_Flight_Distance() >
      secondPlane.Get_Max_Flight_Distance()
        ? 1
        : -1
    );
    return this;
  }

  sortByMaxSpeed() {
    this.planes.sort((firstPlane, secondPlane) =>
      firstPlane.getMaximalSpeed() > secondPlane.getMaximalSpeed()
        ? 1
        : -1
    );
    return this;
  }

  sortByMaxLoadCapacity() {
    this.planes.sort((firstPlane, secondPlane) =>
      firstPlane.getMinLoadCapacity() >
      secondPlane.getMinLoadCapacity()
        ? 1
        : -1
    );
    return this;
  }

  getPlanes() {
    return this.planes;
  }

  static planesObjectJsonString(planes) {
    return JSON.stringify(planes);
  }
}

module.exports = Airport;
