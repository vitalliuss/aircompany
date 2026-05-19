package airport;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Planes.Plane;

public class PlaneSorter {

    // Ordena aviões por distância máxima
    public void sortByMaxDistance(List<Plane> planes) {

        Collections.sort(planes,new Comparator<Plane>() {
                @Override
                public int compare(Plane o1, Plane o2) {
                    return o1.Get_Max_Flight_Distance() - o2.Get_Max_Flight_Distance();
                }
            });
    }

    // Ordena aviões por velocidade máxima
    public void sortByMaxSpeed(List<Plane> planes) {
        Collections.sort(planes,new Comparator<Plane>() {
                @Override
                public int compare(Plane o1, Plane o2) {
                    return o1.getMS()- o2.getMS();
                }
            });
    }

    // Ordena aviões por  carga maxima
    public void sortByMaxLoadCapacity(List<Plane> planes) {
        Collections.sort(planes,new Comparator<Plane>() {
                @Override
                public int compare(Plane o1, Plane o2) {
                    return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
                }
            });
    }
}