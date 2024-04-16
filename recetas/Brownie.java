package recetas;
import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;
import interfaces.Despensable;

import java.util.ArrayList;
import java.util.List;


public class Brownie extends Receta {
    public Brownie() {

        super(25,
                new ArrayList<>() {{
                    add(new Ingrediente("Huevo", 3));
                    add(new Ingrediente("Harina", 100));
                    add(new Ingrediente("Azucar", 100));
                    add(new Ingrediente("Leche", 100));
                    add(new Ingrediente("Aceite", 50));
                    add(new Ingrediente("Polvo de hornear", 25));
                }},
                new ArrayList<>() {{
                    add(new Utensilio("Bowl", 10));
                    add(new Utensilio("Batidora", 25));
                    add(new Utensilio("Horno", 25));
                }},
                "Mezclar los ingredientes, empezamos por mezclar los liquidos y luego ingresamos los secos, tamizados previamente. Y hornear durante 30 minutos"
        );
    }



}
