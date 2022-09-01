class PlaneSettings {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    };

    getModel() {
        return this.model;
    };

    getMaxSpeed() {
        return this.maxSpeed;
    };

    GetMaxFlightDistance() {
        return this.maxFlightDistance;
    };

    getMinLoadCapacity() {
        let result = this.maxLoadCapacity;
        return result;
    };
};

export default PlaneSettings;