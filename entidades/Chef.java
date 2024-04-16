package entidades;

import excepciones.StockInsuficienteException;
import excepciones.VidaUtilInsuficienteException;
import interfaces.Despensable;
import services.CocinaService;
import services.DespensaService;

import java.util.List;
import java.util.concurrent.Callable;

public class Chef  implements Callable{
    private String nombre;

    private int estrellasMichelin;

    private Despensa despensa;

    private Receta receta;

    public CocinaService cocinaService = CocinaService.getInstance();

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

    public Chef(String nombre, int estrellasMichelin, Despensa despensa, Receta receta) {
        this.nombre = nombre;
        this.estrellasMichelin = estrellasMichelin;
        this.despensa = despensa;
        this.receta = receta;
    }

    private void toStringChef(){
        System.out.println(" El Chef" + nombre + " posee " +estrellasMichelin+ " estrellas Michelin ");
    }




    @Override
    public Void call()  {
        try{
            cocinaService.prepararPlatos(receta, despensa,this.nombre);
        }catch (StockInsuficienteException | VidaUtilInsuficienteException e){
            e.printStackTrace();
        }
        return null;

    }
}





