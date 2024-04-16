package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

import java.util.ArrayList;

public class Pasta extends Receta {
    public Pasta() {
        super(20,
                new ArrayList<>() {{
                    add(new Ingrediente("Pasta", 100));
                    add(new Ingrediente("Tomate", 200));
                    add(new Ingrediente("Aceite", 30));
                    add(new Ingrediente("Sal", 5));
                }},
                new ArrayList<>() {{
                    add(new Utensilio("Olla", 10));
                    add(new Utensilio("Sartén", 10));
                }},
                "Cocinar la pasta en agua hirviendo con sal. Mientras tanto, sofreír los tomates en aceite en una sartén. Mezclar la pasta con la salsa de tomate."
        );
    }
}
