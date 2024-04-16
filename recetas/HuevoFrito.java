package recetas;

import entidades.Ingrediente;
import entidades.Receta;
import entidades.Utensilio;

import java.util.ArrayList;

public class HuevoFrito extends Receta {


    public HuevoFrito() {
        super(3,
                new ArrayList<>() {{
                    add(new Ingrediente("Huevo", 1));
                    add(new Ingrediente("Aceite", 50));
                }},
                new ArrayList<>() {{
                    add(new Utensilio("Sarten", 10));
                    add(new Utensilio("Espatula", 5));
                }},
                "Poner el aceite en la sarten, esperar a que caliente y poner el huevo, cocinar durante 3 minutos"
        );
    }
}
