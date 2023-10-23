using Aircompany.Models;

namespace Aircompany.Planes
{
    public class MilitaryPlane : Plane
    {
        public MilitaryType militaryType;

        public MilitaryPlane(string model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType type)
            : base(model, maxSpeed, maxFlightDistance, maxLoadCapacity)
        {
            this.militaryType = type;
        }

        public override bool Equals(object obj)
        {
            var plane = obj as MilitaryPlane;
            return plane != null &&
                   base.Equals(obj) &&
                   militaryType == plane.militaryType;
        }

        public override int GetHashCode()
        {
            var hashCode = 1701194404;
            hashCode = hashCode * -1521134295 + base.GetHashCode();
            hashCode = hashCode * -1521134295 + militaryType.GetHashCode();
            return hashCode;
        }

        public MilitaryType GetMilitaryPlaneType()
        {
            return militaryType;
        }


        public override string ToString()
        {
            return base.ToString().Replace("}",
                    ", type=" + militaryType +
                    '}');
        }        
    }
}
