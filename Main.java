import entidades.Chef;
import entidades.Despensa;
import entidades.Ingrediente;
import entidades.Utensilio;
import excepciones.StockInsuficienteException;
import excepciones.VidaUtilInsuficienteException;
import interfaces.Despensable;
import recetas.HuevoDuro;
import recetas.HuevoFrito;
import recetas.Torta;
import services.CocinaService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws StockInsuficienteException, VidaUtilInsuficienteException {
        Ingrediente huevo = new Ingrediente("Huevo", 6);
        Ingrediente harina = new Ingrediente("Harina", 500);
        Ingrediente azucar = new Ingrediente("Azucar", 250);
        Ingrediente sal = new Ingrediente("Sal", 100);
        Ingrediente aceite = new Ingrediente("Aceite", 55);
        Ingrediente agua = new Ingrediente("Agua", 8000);
        Ingrediente leche = new Ingrediente("Leche", 1000);
        Ingrediente manteca = new Ingrediente("Manteca", 600);

        Utensilio bowl = new Utensilio("Bowl", 50);
        Utensilio batidora = new Utensilio("Batidora", 50);
        Utensilio horno = new Utensilio("Horno", 50);
        Utensilio sarten = new Utensilio("Sarten", 50);
        Utensilio cuchara = new Utensilio("Cuchara", 100);
        Utensilio cuchillo = new Utensilio("Cuchillo", 100);
        Utensilio tenedor = new Utensilio("Tenedor", 100);
        Utensilio cucharon = new Utensilio("Cucharon", 100);
        Utensilio olla = new Utensilio("Olla", 2);
        Utensilio espatula = new Utensilio("Espatula", 100);

        Map<String, Despensable> despensableMap = new HashMap<>();
        despensableMap.put(huevo.getNombre(), huevo);
        despensableMap.put(harina.getNombre(), harina);
        despensableMap.put(azucar.getNombre(), azucar);
        despensableMap.put(sal.getNombre(), sal);
        despensableMap.put(aceite.getNombre(), aceite);
        despensableMap.put(agua.getNombre(), agua);
        despensableMap.put(leche.getNombre(), leche);
        despensableMap.put(manteca.getNombre(), manteca);
        despensableMap.put(bowl.getNombre(), bowl);
        despensableMap.put(batidora.getNombre(), batidora);
        despensableMap.put(horno.getNombre(), horno);
        despensableMap.put(sarten.getNombre(), sarten);
        despensableMap.put(cuchara.getNombre(), cuchara);
        despensableMap.put(cuchillo.getNombre(), cuchillo);
        despensableMap.put(tenedor.getNombre(), tenedor);
        despensableMap.put(cucharon.getNombre(), cucharon);
        despensableMap.put(olla.getNombre(), olla);
        despensableMap.put(espatula.getNombre(), espatula);

        Despensa despensa = new Despensa(despensableMap);

        Chef chef = new Chef("Gordon Ramsay", 3);

        CocinaService cocinaService = new CocinaService(chef, despensa);

        Torta torta = new Torta();
        HuevoDuro huevoDuro = new HuevoDuro();
        HuevoFrito huevoFrito = new HuevoFrito();

        System.out.println("------------------------------------------");

        System.out.println("Preparación de huevo duro:");
        System.out.println(cocinaService.prepararPlatos(huevoDuro));

        System.out.println("------------------------------------------");

        System.out.println("Preparación de huevo frito:");
        System.out.println(cocinaService.prepararPlatos(huevoFrito));

        System.out.println("------------------------------------------");

        System.out.println("Preparación de torta:");
        System.out.println(cocinaService.prepararPlatos(torta));
    }
}




