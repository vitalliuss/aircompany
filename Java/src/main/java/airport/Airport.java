package airport;
import Planes.Plane;

import java.util.*;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    //Lista de aviões
    /*Podendo ser de: Passageiros, militares e até experimentais */
    private List<Plane> planes;

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = new ArrayList<>(planes);
    }

    //Retorna a lista de aviões
    public List<Plane> getPlanes() {
        return planes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
