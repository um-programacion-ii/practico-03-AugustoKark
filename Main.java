import entidades.Chef;
import entidades.Despensa;
import entidades.Ingrediente;
import entidades.Utensilio;
import entidades.Receta;
import excepciones.StockInsuficienteException;
import excepciones.VidaUtilInsuficienteException;
import interfaces.Despensable;
import recetas.*;
import services.CocinaService;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
        public static void main(String[] args) throws StockInsuficienteException, VidaUtilInsuficienteException {
            Random random = new Random();

            // Crear ingredientes
            Ingrediente huevo = new Ingrediente("Huevo", 6);
            Ingrediente harina = new Ingrediente("Harina", 500);
            Ingrediente azucar = new Ingrediente("Azucar", 250);
            Ingrediente sal = new Ingrediente("Sal", 100);
            Ingrediente aceite = new Ingrediente("Aceite", 550);
            Ingrediente agua = new Ingrediente("Agua", 8000);
            Ingrediente leche = new Ingrediente("Leche", 1000);
            Ingrediente manteca = new Ingrediente("Manteca", 600);
            Ingrediente queso = new Ingrediente("Queso", 100);
            Ingrediente pollo = new Ingrediente("Pollo", 1000);
            Ingrediente polvoDeHornear = new Ingrediente("Polvo de hornear", 100);

            // Crear utensilios
            Utensilio bowl = new Utensilio("Bowl", 50);
            Utensilio batidora = new Utensilio("Batidora", 50);
            Utensilio horno = new Utensilio("Horno", 50);
            Utensilio sarten = new Utensilio("Sarten", 50);
            Utensilio cuchara = new Utensilio("Cuchara", 100);
            Utensilio cuchillo = new Utensilio("Cuchillo", 100);
            Utensilio tenedor = new Utensilio("Tenedor", 100);
            Utensilio cucharon = new Utensilio("Cucharon", 100);
            Utensilio olla = new Utensilio("Olla", 20);
            Utensilio espatula = new Utensilio("Espatula", 100);

            // Mapa de ingredientes y utensilios
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
            despensableMap.put(queso.getNombre(), queso);
            despensableMap.put(pollo.getNombre(), pollo);
            despensableMap.put(polvoDeHornear.getNombre(), polvoDeHornear);

            // Crear despensa
            Despensa despensa1 = new Despensa(despensableMap);
            Despensa despensa2 = new Despensa(despensableMap);
            Despensa despensa3 = new Despensa(despensableMap);

            // Crear recetas
            HuevoFrito huevoFrito = new HuevoFrito();
            Torta torta = new Torta();
            HuevoDuro huevoDuro = new HuevoDuro();


            // Crear cocineros
            List<Chef> chefsSemana = new ArrayList<>();
            Chef chef1 = new Chef("Juan", 3, despensa1, huevoFrito);
            Chef chef2 = new Chef("Pedro", 3, despensa2, torta);
            Chef chef3 = new Chef("Maria", 3, despensa3, huevoDuro);

            chefsSemana.add(chef1);
            chefsSemana.add(chef2);
            chefsSemana.add(chef3);

            Brownie brownie = new Brownie();
            Pasta pasta = new Pasta();
            Torta torta1 = new Torta();
            EnsaladaCesar ensaladaCesar = new EnsaladaCesar();
            SopaDeVerduras sopaDeVerduras = new SopaDeVerduras();

            Despensa despensa4 = new Despensa(despensableMap);
            Despensa despensa5 = new Despensa(despensableMap);
            Despensa despensa6 = new Despensa(despensableMap);
            Despensa despensa7 = new Despensa(despensableMap);
            Despensa despensa8 = new Despensa(despensableMap);

            List<Chef> chefsFinde = new ArrayList<>();
            Chef chef4 = new Chef("Linguini", 3, despensa4, torta1);
            Chef chef5 = new Chef("Pedrito Electrocutador", 3, despensa5, brownie);
            Chef chef6 = new Chef("Luquitas Rodriguez", 3, despensa6, pasta);
            Chef chef7 = new Chef("Mariano Closs", 3, despensa7, ensaladaCesar);
            Chef chef8 = new Chef("Fernando Niembro", 3, despensa8, sopaDeVerduras);
            chefsFinde.add(chef4);
            chefsFinde.add(chef5);
            chefsFinde.add(chef6);
            chefsFinde.add(chef7);
            chefsFinde.add(chef8);


            int finDeSemana = random.nextInt(2);

            if (finDeSemana == 0) {
                System.out.println("Es un dia de semana");
                ExecutorService executor = Executors.newFixedThreadPool(3);
                for (Chef chef : chefsSemana) {

                    Future<String> labureChefsito = executor.submit(chef);
                    try {
                        System.out.println(labureChefsito.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                executor.shutdown();


            }
            if (finDeSemana == 1) {
                System.out.println("Es fin de semana");
                ExecutorService executor = Executors.newFixedThreadPool(5);
                for (Chef chef : chefsFinde) {
                    Future<String> labureChefsito = executor.submit(chef);
                    try {
                        System.out.println(labureChefsito.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                executor.shutdown();
            }
        }










}














