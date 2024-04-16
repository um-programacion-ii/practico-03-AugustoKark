package services;

import entidades.*;
import excepciones.StockInsuficienteException;
import interfaces.Despensable;
import excepciones.VidaUtilInsuficienteException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CocinaService {

    public static CocinaService instancia = null;


    private CocinaService() {
    }



    public static synchronized CocinaService getInstance() {
        if (instancia == null) {
            instancia = new CocinaService();
        }
        return instancia;
    }


     public void prepararPlatos(Receta receta,Despensa despensa, String nombreChef) throws StockInsuficienteException, VidaUtilInsuficienteException {

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
             System.out.println("El Chef " + nombreChef +" ha preparado exitosamente la receta: " + receta.getClass().getSimpleName());
         } else {
             System.out.println("El Chef "+ nombreChef+" NO pudo preparar la receta: " + receta.getClass().getSimpleName());
         }

     }



}





















