package Controladores;

import Modelo.Cuotas;

import java.util.List;

public class OrdenarListas {
    //Esta clase deberia ordenar todas las listas en base a una, e este caso Sportium
    private List<Cuotas> listaSportium, listaOtra;



    private List<Cuotas> comparador(List<Cuotas> listaSportium ,List<Cuotas> listaAOrdenar ){
        int i = 0;
        for (Cuotas cuotas : listaSportium) {
            String nombreequipo1 = cuotas.getNombreEquipo1();
            String nombreequipo2 = cuotas.getNombreEquipo2();
            for (Cuotas cuotass : listaAOrdenar) {
                if (cuotass.equals(nombreequipo1) && cuotass.equals(nombreequipo2)) {
                    listaAOrdenar.set(i, cuotass);
                    i++;
                }
            }

        }

        return listaAOrdenar;
    }
}
