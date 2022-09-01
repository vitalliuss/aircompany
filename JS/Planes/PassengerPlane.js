import PlaneSettings from './PlaneSettings';

class PassengerPlane extends PlaneSettings {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity, passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    };

    getPassengersCapacity() {
        return this.passengersCapacity;
    };
};

export default PassengerPlane;