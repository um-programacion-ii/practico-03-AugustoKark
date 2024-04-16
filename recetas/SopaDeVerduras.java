package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

import java.util.ArrayList;

public class SopaDeVerduras extends Receta {
    public SopaDeVerduras() {
        super(30,
                new ArrayList<>() {{
                    add(new Ingrediente("Zanahoria", 100));
                    add(new Ingrediente("Papa", 100));
                    add(new Ingrediente("Cebolla", 50));
                    add(new Ingrediente("Aceite", 30));
                    add(new Ingrediente("Sal", 5));
                }},
                new ArrayList<>() {{
                    add(new Utensilio("Olla", 10));

                }},
                "Cortar las verduras en cubos y sofreír en aceite en una olla. Añadir agua y sal, y cocinar hasta que las verduras estén tiernas."
        );
    }
}
