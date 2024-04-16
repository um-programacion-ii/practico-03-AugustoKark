package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

import java.util.ArrayList;

public class EnsaladaCesar extends Receta {
    public EnsaladaCesar() {
        super(10,
                new ArrayList<>() {{
                    add(new Ingrediente("Lechuga", 100));
                    add(new Ingrediente("Pollo", 100));
                    add(new Ingrediente("Pan", 50));
                    add(new Ingrediente("Queso", 30));
                    add(new Ingrediente("Aceite", 10));
                }},
                new ArrayList<>() {{
                    add(new Utensilio("Bowl", 10));
                    add(new Utensilio("Sarten", 10));
                }},
                "Cortar el pollo y el pan en cubos y freírlos. Mezclar la lechuga, el pollo, el pan y el queso parmesano en un bowl."
        );
    }
}

