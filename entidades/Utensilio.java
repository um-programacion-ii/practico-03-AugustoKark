package entidades;

import interfaces.Despensable;
import interfaces.Reutilizable;
import excepciones.VidaUtilInsuficienteException;

public class Utensilio implements Despensable, Reutilizable {

    private String nombre;
    private int vidaUtil;

    public Utensilio(String nombre, int vidaUtil) {
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public int getCantidadDisponible() {
        return vidaUtil;
    }
    @Override
    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String toString(){
        return("Utensilio: " + nombre + " con " + vidaUtil + " usos");
    }

    @Override
    public void sacar(int cantidad) throws VidaUtilInsuficienteException{
        if (this.vidaUtil >= cantidad){
            this.vidaUtil -= cantidad;
        }else{

            throw new VidaUtilInsuficienteException("No hay suficientes usos de "+ this.nombre +
                    " \n Faltan " + (cantidad - this.vidaUtil) + " usos" );
        }
    }


}
