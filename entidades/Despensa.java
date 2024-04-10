package entidades;

import excepciones.StockInsuficienteException;
import excepciones.VidaUtilInsuficienteException;
import interfaces.Cocinable;
import interfaces.Despensable;


import java.util.Map;

public class Despensa implements Cocinable {

    private Map<String, Despensable> despensableMap;

    public Despensa(Map<String, Despensable> despensableMap) {
        this.despensableMap = despensableMap;
    }

    public void sacar(String nombre, int cantidad) throws StockInsuficienteException, VidaUtilInsuficienteException {
        Despensable despensable = despensableMap.get(nombre);

        if (despensable != null) {
            try {
                despensable.sacar(cantidad);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("No se encontro el despensable: " + nombre);
        }
    }


    public boolean contieneSuficienteDespensable(Despensable despensable) {
        Despensable despensaItem = despensableMap.get(despensable.getNombre());
        return despensaItem != null && despensaItem.getCantidadDisponible() >= despensable.getCantidadDisponible();
    }

//    public int getCantidadDisponible(String nombreDespensable) {
//        Despensable despensable = despensableMap.get(nombreDespensable);
//        return despensable != null ? despensable.getCantidadDisponible() : 0;
//    }

}


