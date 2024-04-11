import entidades.Chef;
import entidades.Despensa;
import entidades.Ingrediente;
import entidades.Utensilio;
import entidades.Receta;
import excepciones.StockInsuficienteException;
import excepciones.VidaUtilInsuficienteException;
import interfaces.Despensable;
import recetas.HuevoDuro;
import recetas.HuevoFrito;
import recetas.Torta;
import services.CocinaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
        public static void main(String[] args) throws StockInsuficienteException, VidaUtilInsuficienteException {
            // Crear ingredientes
            Ingrediente huevo = new Ingrediente("Huevo", 6);
            Ingrediente harina = new Ingrediente("Harina", 500);
            Ingrediente azucar = new Ingrediente("Azucar", 250);
            Ingrediente sal = new Ingrediente("Sal", 100);
            Ingrediente aceite = new Ingrediente("Aceite", 55);
            Ingrediente agua = new Ingrediente("Agua", 8000);
            Ingrediente leche = new Ingrediente("Leche", 1000);
            Ingrediente manteca = new Ingrediente("Manteca", 600);

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

            // Crear despensas
            Despensa despensa = new Despensa(new HashMap<>(despensableMap));
            Despensa despensa2 = new Despensa(new HashMap<>(despensableMap));
            Despensa despensa3 = new Despensa(new HashMap<>(despensableMap));

            // Crear lista de chefs
            List<Chef> chefs = new ArrayList<>();
            // Agregar chefs con sus respectivas despensas
            chefs.add(new Chef("Linguinni", 30, despensa));
            chefs.add(new Chef("Remy", 30, despensa2));
            chefs.add(new Chef("Gusteau", 30, despensa3));

            // Crear recetas
            Receta huevoDuro = new HuevoDuro();
            Receta huevoFrito = new HuevoFrito();
            Receta torta = new Torta();

            // Crear lista de recetas
            List<Receta> recetas = new ArrayList<>();
//            recetas.add(huevoDuro);
            recetas.add(huevoFrito);
            recetas.add(torta);

            // Crear ExecutorService
            ExecutorService executorService = Executors.newFixedThreadPool(chefs.size());

            // Crear lista de resultados de las tareas
            List<Future<String>> resultados = new ArrayList<>();

            // Asignar recetas a los chefs y crear tareas de preparación de platos
            for (Chef chef : chefs) {
                // Obtener la receta asignada al chef
                Receta receta = recetas.get(chefs.indexOf(chef) % recetas.size());
                // Crear tarea de preparación de plato para el chef y su despensa
                CocinaService cocinaService = CocinaService.getInstance(chef, chef.getDespensa(), receta);
                // Ejecutar la tarea y agregar el resultado a la lista de resultados
                Future<String> resultado = executorService.submit(cocinaService);
                resultados.add(resultado);
            }

            // Esperar a que todas las tareas se completen y obtener los resultados
            for (Future<String> resultado : resultados) {
                try {
                    String mensaje = resultado.get();  // Obtener el resultado de la tarea
                    System.out.println(mensaje);  // Imprimir el mensaje
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Apagar el ExecutorService
            executorService.shutdown();
        }
    }













