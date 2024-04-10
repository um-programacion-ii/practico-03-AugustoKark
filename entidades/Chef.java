package entidades;

import services.CocinaService;

import java.util.concurrent.Callable;

public class Chef implements Callable<String> {
    private String nombre;

    private int estrellasMichelin;

    private CocinaService cocinaService;

//    private services.CocinaService cocinaService;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellasMichelin() {
        return estrellasMichelin;
    }

    public void setEstrellasMichelin(int estrellasMichelin) {
        this.estrellasMichelin = estrellasMichelin;
    }

    public Chef() {
    }

    public Chef(String nombre, int estrellasMichelin, CocinaService cocinaService) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.cocinaService = cocinaService;
    }

    private void toStringChef(){
        System.out.println(" El Chef" + nombre + " posee " +estrellasMichelin+ " estrellas Michelin ");
    }


    @Override
    public String call() throws Exception {
        try {

        }
        return "";
    }
}




