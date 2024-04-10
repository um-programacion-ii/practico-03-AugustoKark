package services;
import entidades.Despensa;
import interfaces.Despensable;

import java.util.List;

public class DespensaService {

    private Despensa despensa;

    public DespensaService(Despensa despensa) {
        this.despensa = despensa;
    }

    public boolean verificarStock(List<Despensable> ingredientes) {
        for (Despensable ingrediente : ingredientes) {
            if (!despensa.contieneSuficienteDespensable(ingrediente)) {
                return false;
            }}
        return true;
    }

    public boolean verificarVidaUtil(List<Despensable> utensilios) {
        for (Despensable utensilio : utensilios) {
            if (!despensa.contieneSuficienteDespensable(utensilio)) {
                return false;
            }

        }
         return true;
    }





//    Acá se puede ver que se está utilizando el método allMatch de la clase Stream, que recibe un predicado y devuelve un booleano.
//public boolean verificarStock(List<Despensable> ingredientes) {
//    return ingredientes.stream().allMatch(ingrediente -> despensa.contieneSuficienteDespensable(ingrediente));
//}
//
//    public boolean verificarVidaUtil(List<Despensable> utensilios) {
//        return utensilios.stream().allMatch(utensilio -> despensa.contieneSuficienteDespensable(utensilio));
//    }

}