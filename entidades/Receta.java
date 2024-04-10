package entidades;
import interfaces.Despensable;

import java.util.List;

public class Receta {
    private int tiempoCoccion;

    private List<Despensable> ingredientes;
    private List<Despensable> utensilios;
    private String preparacion;

    public Receta(int tiempoCoccion, List<Despensable> ingredientes, List<Despensable> utensilios, String preparacion) {
        this.tiempoCoccion = tiempoCoccion;
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
        this.preparacion = preparacion;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public List<Despensable> getIngredientes() {
        return ingredientes;
    }

    public List<Despensable> getUtensilios() {
        return utensilios;
    }

    public String getPreparacion() {
        return preparacion;
    }

//    public void setIngredientes(entidades.Ingrediente[] ingredientes) {
//        this.ingredientes = ingredientes;
//    }
}






