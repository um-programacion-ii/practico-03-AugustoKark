package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

import java.util.ArrayList;

public class HuevoDuro extends Receta {
    public HuevoDuro() {
        super(10,
                new ArrayList<>() {{
                    add(new Ingrediente("Huevo", 1));
                }},
                new ArrayList<>() {{
                    add(new Utensilio("Olla", 10));
                }},
                "Poner el huevo en agua hirviendo durante 10 minutos"
        );
    }
}



