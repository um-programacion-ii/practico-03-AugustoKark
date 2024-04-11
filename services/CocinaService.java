package services;

import entidades.*;
import excepciones.StockInsuficienteException;
import interfaces.Despensable;
import excepciones.VidaUtilInsuficienteException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CocinaService implements Callable<String> {

    private Chef chef;
    private Despensa despensa;
    public static CocinaService instancia=null;
    private Receta receta;

    private CocinaService() {
    }

    private CocinaService(Chef chef, Despensa despensa, Receta receta) {
        this.chef = chef;
        this.despensa = despensa;
        this.receta = receta;

    }

    public static synchronized CocinaService getInstance(Chef chef, Despensa despensa, Receta receta) {
        if (instancia == null) {
            instancia = new CocinaService(chef, despensa, receta);
        }
        return instancia;
    }



//    public String prepararPlatos(Receta receta) throws StockInsuficienteException, VidaUtilInsuficienteException {
//        List<Despensable> ingredientes = receta.getIngredientes();
//        List<Despensable> utensilios = receta.getUtensilios();
//        boolean sePuedePreparar = true;
//
//        DespensaService despensaService = new DespensaService(despensa);
////        DespensaService despensaService = DespensaService.getInstance(despensa);
//
//        if (!despensaService.verificarStock(ingredientes)) {
//            sePuedePreparar = false;
//        }
//        if (!despensaService.verificarVidaUtil(utensilios)) {
//            sePuedePreparar = false;
//        }
//
//        for (Despensable ingrediente : ingredientes) {
//            despensa.sacar(ingrediente.getNombre(), ingrediente.getCantidadDisponible());
//
//        }
//
//        for (Despensable utensilio : utensilios) {
//             despensa.sacar(utensilio.getNombre(), utensilio.getCantidadDisponible());
//        }
//
//        if (sePuedePreparar) {
//            return "El Chef " + chef.getNombre() + " ha preparado exitosamente la receta: " + receta.getClass().getSimpleName();
//        } else {
//            return "No se pudo preparar la receta: " + receta.getClass().getSimpleName();
//        }
//
//
//    }

    @Override
    public String call() throws Exception {
        try{
            return chef.prepararPlatos(receta);
        }catch (Exception e){
            return e.getMessage();
        }


        
    }


//    Aca se puede ver que se está utilizando el método allMatch de la clase Stream, que recibe un predicado y devuelve un booleano.
//    public String prepararPlatos(Receta receta) throws StockInsuficienteException, VidaUtilInsuficienteException {
//        DespensaService despensaService = new DespensaService(despensa);
//
//        boolean sePuedePreparar = despensaService.verificarStock(receta.getIngredientes()) && despensaService.verificarVidaUtil(receta.getUtensilios());
//
//            if (sePuedePreparar) {
//                try {
//                    receta.getIngredientes().forEach(ingrediente -> {
//                        try {
//                            despensa.sacar(ingrediente.getNombre(), ingrediente.getCantidadDisponible());
//                        } catch (StockInsuficienteException e) {
//                            throw new RuntimeException(e);
//                        } catch (VidaUtilInsuficienteException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                try {
//                    receta.getUtensilios().forEach(utensilio -> {
//                        try {
//                            despensa.sacar(utensilio.getNombre(), utensilio.getCantidadDisponible());
//                        } catch (StockInsuficienteException e) {
//                            throw new RuntimeException(e);
//                        } catch (VidaUtilInsuficienteException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//                return "El Chef " + chef.getNombre() + " ha preparado exitosamente la receta: " + receta.getClass().getSimpleName();
//            } else {
//                return "No se pudo preparar la receta: " + receta.getClass().getSimpleName();
//            }
//
//    }
}






















