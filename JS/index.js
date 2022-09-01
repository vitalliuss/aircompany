import MilitaryPlane from './planes/MilitaryPlane';
import PassengerPlane from './planes/PassengerPlane';
import Airport, { printListOfPlanes } from './Airport';
import MilitaryType from './models/militaryType';
import experimentalPlane from './planes/ExperimentalPlane';
import ExperimentalTypes from './models/experimentalTypes';
import ClassificationLevel from './models/classificationLevel';

(function runAircraftDeparture() {
    const planes = [
        new PassengerPlane('Boeing-737', 900, 12000, 60500, 164),
        new PassengerPlane('Boeing-737-800', 940, 12300, 63870, 192),
        new PassengerPlane('Boeing-747', 980, 16100, 70500, 242),
        new PassengerPlane('Airbus A320', 930, 11800, 65500, 188),
        new PassengerPlane('Airbus A330', 990, 14800, 80500, 222),
        new PassengerPlane('Embraer 190', 870, 8100, 30800, 64),
        new PassengerPlane('Sukhoi Superjet 100', 870, 11500, 50500, 140),
        new PassengerPlane('Bombardier CS300', 920, 11000, 60700, 196),
        new MilitaryPlane('B-1B Lancer', 1050, 21000, 80000, MilitaryType.bomber),
        new MilitaryPlane('B-2 Spirit', 1030, 22000, 70000, MilitaryType.bomber),
        new MilitaryPlane('B-52 Stratofortress', 1000, 20000, 80000, MilitaryType.bomber),
        new MilitaryPlane('F-15', 1500, 12000, 10000, MilitaryType.fighter),
        new MilitaryPlane('F-22', 1550, 13000, 11000, MilitaryType.fighter),
        new MilitaryPlane('C-130 Hercules', 650, 5000, 110000, MilitaryType.transport),
        new experimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.highAltitude, ClassificationLevel.secret),
        new experimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.vtol, ClassificationLevel.topSecret)];

    const airport = new Airport(planes);
    const militaryAirport = new Airport(airport.getMilitaryPlanes());
    const passengerAirport = new Airport(airport.getPassengerPlane());
    console.log(`Military airport sorted by max distance: ${printListOfPlanes(militaryAirport.sortByMaxDistance())}`);
    console.log(`Passenger airport sorted by max speed: ${printListOfPlanes(passengerAirport.sortByMaxSpeed())}`);
    console.log(`Plane with max passenger capacity: ${printListOfPlanes(passengerAirport.getPassengerPlaneWithMaxPassengersCapacity())}`);
})();