class Plane {

    constructor(model, maxSpeed, maxFlightDistance, maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    getModel() {
        return this.model;
    }

    getMS() {
        return this.maxSpeed;
    }

    Get_Max_Flight_Distance() {
        return this.maxFlightDistance;
    }

    getMinLoadCapacity() {
     let result = this.maxLoadCapacity;
     return result;
    }
}

module.exports = Plane;
