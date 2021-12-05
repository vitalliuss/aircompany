const assert = require('chai').assert;

const Airport = require('../Airport');
const MilitaryPlane = require('../Planes/MilitaryPlane');
const PassengerPlane = require('../Planes/PassengerPlane');
const ExperimentalPlane = require('../Planes/ExperimentalPlane');
const militaryTypes = require('../models/militaryTypes');
const experimentalTypes = require('../models/experimentalTypes');
const classificationLevels = require('../models/classificationLevels');

describe('test airport', () => {

    let planes = [
        new PassengerPlane('Boeing-737', 900, 12000, 60500, 164),
        new PassengerPlane('Boeing-737-800', 940, 12300, 63870, 192),
        new PassengerPlane('Boeing-747', 980, 16100, 70500, 242),
        new PassengerPlane('Airbus A320', 930, 11800, 65500, 188),
        new PassengerPlane('Airbus A330', 990, 14800, 80500, 222),
        new PassengerPlane('Embraer 190', 870, 8100, 30800, 64),
        new PassengerPlane('Sukhoi Superjet 100', 870, 11500, 50500, 140),
        new PassengerPlane('Bombardier CS300', 920, 11000, 60700, 196),
        new MilitaryPlane('B-1B Lancer', 1050, 21000, 80000, militaryTypes.BOMBER),
        new MilitaryPlane('B-2 Spirit', 1030, 22000, 70000, militaryTypes.BOMBER),
        new MilitaryPlane('B-52 Stratofortress', 1000, 20000, 80000, militaryTypes.BOMBER),
        new MilitaryPlane('F-15', 1500, 12000, 10000, militaryTypes.FIGHTER),
        new MilitaryPlane('F-22', 1550, 13000, 11000, militaryTypes.FIGHTER),
        new MilitaryPlane('C-130 Hercules', 650, 5000, 110000, militaryTypes.TRANSPORT),
        new ExperimentalPlane("Bell X-14", 277, 482, 500, experimentalTypes.HIGH_ALTITUDE, classificationLevels.SECRET),
        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, experimentalTypes.VTOL, classificationLevels.TOP_SECRET)
    ];
    let planeWithMaxPassengerCapacity = new PassengerPlane('Boeing-747', 980, 16100, 70500, 242);
    let planeWithMaxLoadCapacity = new MilitaryPlane('C-130 Hercules', 650, 5000, 110000, militaryTypes.TRANSPORT);
    let planeWithMinLoadCapacity = new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, experimentalTypes.VTOL, classificationLevels.TOP_SECRET);

    it('should have at least one military plane with transport type', () => {
        let airport = new Airport(planes);
        assert.isNotEmpty(airport.getTransportMilitaryPlanes());
    });

    it('should check passenger plane with max capacity', () => {
        let airport = new Airport(planes);
        assert.deepEqual(airport.getPassengerPlaneWithMaxPassengersCapacity(), planeWithMaxPassengerCapacity);
    });


    it('should check sorting by max capacity', () => {
        let airport = new Airport(planes);
        let getPlanesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        assert.deepEqual(getPlanesSortedByMaxLoadCapacity[getPlanesSortedByMaxLoadCapacity.length - 1], planeWithMaxLoadCapacity);
        assert.deepEqual(getPlanesSortedByMaxLoadCapacity[0], planeWithMinLoadCapacity);
    });

    it('should have at least one military plane with bomber type', () => {
        let airport = new Airport(planes);
        assert.isNotEmpty(airport.getBomberMilitaryPlanes());
    });

    it('should check that experimental planes have classification level higher than unclassified', () => {
        let airport = new Airport(planes);
        assert.isEmpty(airport.getExperimentalPlanesWithClassificationLevel(classificationLevels.UNCLASSIFIED));
    });


});