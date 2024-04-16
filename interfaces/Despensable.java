package interfaces;

import excepciones.VidaUtilInsuficienteException;
import excepciones.StockInsuficienteException;

public interface Despensable {

    void sacar(int cantidad) throws VidaUtilInsuficienteException, StockInsuficienteException;


    String getNombre();

    int getCantidadDisponible();
}
