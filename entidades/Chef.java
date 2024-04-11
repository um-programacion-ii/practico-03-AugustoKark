package entidades;

import excepciones.StockInsuficienteException;
import excepciones.VidaUtilInsuficienteException;
import interfaces.Despensable;
import services.CocinaService;
import services.DespensaService;

import java.util.List;
import java.util.concurrent.Callable;

public class Chef  {
    private String nombre;

    private int estrellasMichelin;

    private Despensa despensa;

    public Despensa getDespensa() {
        System.out.println("La despensa del chef ");
        return despensa;
    }

    public void setDespensa(Despensa despensa) {
        this.despensa = despensa;
    }

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

    public Chef(String nombre, int estrellasMichelin, Despensa despensa) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.despensa = despensa;
    }

    private void toStringChef(){
        System.out.println(" El Chef" + nombre + " posee " +estrellasMichelin+ " estrellas Michelin ");
    }

    public String prepararPlatos(Receta receta) throws StockInsuficienteException, VidaUtilInsuficienteException {
        List<Despensable> ingredientes = receta.getIngredientes();
        List<Despensable> utensilios = receta.getUtensilios();
        boolean sePuedePreparar = true;

        DespensaService despensaService = new DespensaService(despensa);
//        DespensaService despensaService = DespensaService.getInstance(despensa);

        if (!despensaService.verificarStock(ingredientes)) {
            sePuedePreparar = false;
        }
        if (!despensaService.verificarVidaUtil(utensilios)) {
            sePuedePreparar = false;
        }

        for (Despensable ingrediente : ingredientes) {
            despensa.sacar(ingrediente.getNombre(), ingrediente.getCantidadDisponible());

        }

        for (Despensable utensilio : utensilios) {
            despensa.sacar(utensilio.getNombre(), utensilio.getCantidadDisponible());
        }

        if (sePuedePreparar) {
            return "El Chef "   + " ha preparado exitosamente la receta: " + receta.getClass().getSimpleName();
        } else {
            return "No se pudo preparar la receta: " + receta.getClass().getSimpleName();
        }


    }




    }





