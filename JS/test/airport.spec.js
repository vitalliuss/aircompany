import { assert } from 'chai';
import MilitaryPlane from '../planes/MilitaryPlane';
import PassengerPlane from '../planes/PassengerPlane';
import Airport from '../airport';
import MilitaryType from '../models/militaryType';
import ExperimentalPlane from '../planes/ExperimentalPlane';
import ExperimentalTypes from '../models/experimentalTypes';
import ClassificationLevel from '../models/classificationLevel';

describe('Aircraft departured', () => {
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
        new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.highAltitude, ClassificationLevel.secret),
        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.vtol, ClassificationLevel.topSecret)
    ];

    const planeWithMaxPassengerCapacity = new PassengerPlane('Boeing-747', 980, 16100, 70500, 242);

    it('should have military Planes with transport type', () => {
        const airport = new Airport(planes);
        const transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        const flag = false;
        for (let militaryPlane of transportMilitaryPlanes) {
            if (militaryPlane.getMilitaryType() === MilitaryType.transport) {
                flag = true;
                break;
            };
        };
        assert.equal(flag, true);
    });

    it('should check passenger plane with max capacity', () => {
        const airport = new Airport(planes);
        const expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        assert.isFalse(expectedPlaneWithMaxPassengersCapacity === planeWithMaxPassengerCapacity);
    });


    it('test Get Passenger Plane With Max Capacity started', () => {
        const airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        const planesSortedByMaxLoadCapacity = airport.getPlanes();
        const nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (let i = 0; i < planesSortedByMaxLoadCapacity.length - 1; i++) {
            const currentPlane = planesSortedByMaxLoadCapacity[i];
            const nextPlane = planesSortedByMaxLoadCapacity[i + 1];
            if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            };
        };
        assert.isTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    });
    it('test has at least one type bomber in military planes', () => {
        const airport = new Airport(planes);
        const typeBomberMilitaryPlanes = airport.getTypeBomberMilitaryPlanes();
        const flag = false;
        for (let militaryPlane of typeBomberMilitaryPlanes) {
            if (militaryPlane.getMilitaryType() === MilitaryType.bomber) {
                flag = true;
            };
            assert.assertIsTrue(flag);
        };
    });

    it('should check that experimentsl planes has classification level higher than unclassified', () => {
        const airport = new Airport(planes);
        const typeBomberMilitaryPlanes = airport.getExperimentalPlanes();
        const hasUnclassifiedPlanes = false;
        for (const experimentalPlane of typeBomberMilitaryPlanes) {
            if (experimentalPlane.classificationLevel === ClassificationLevel.unclassified) {
                hasUnclassifiedPlanes = true;
            };
            assert.isFalse(hasUnclassifiedPlanes);
        };
    });
});
