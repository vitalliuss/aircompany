using System.Collections.Generic;

namespace Aircompany.Planes
{
    public abstract class Plane
    {
        protected string model;
        protected int maxSpeed;
        protected int maxFlightDistance;
        protected int maxLoadCapacity;

        public Plane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity)
        {
            this.model = model;
            this.maxSpeed = maxSpeed;
            this.maxFlightDistance = maxFlightDistance;
            this.maxLoadCapacity = maxLoadCapacity;
        }

        public string GetModel()
        {
            return model;
        }

        public int GetMaxSpeed()
        {
            return maxSpeed;
        }

        public int GetMaxFlightDistance()
        {
            return maxFlightDistance;
        }

        public int GetMaxLoadCapacity()
        {
            return maxLoadCapacity;
        }

        public override string ToString()
        {
            return "Plane{" +
                "model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
        }

        public override bool Equals(object obj)
        {
            var plane = obj as Plane;
            return plane != null &&
                   model == plane.model &&
                   maxSpeed == plane.maxSpeed &&
                   maxFlightDistance == plane.maxFlightDistance &&
                   maxLoadCapacity == plane.maxLoadCapacity;
        }

        public override int GetHashCode()
        {
            var hashCode = -1043886837;
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(model);
            hashCode = hashCode * -1521134295 + maxSpeed.GetHashCode();
            hashCode = hashCode * -1521134295 + maxFlightDistance.GetHashCode();
            hashCode = hashCode * -1521134295 + maxLoadCapacity.GetHashCode();
            return hashCode;
        }

    }
}
