package libitum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class robot {
    public int vida=100;
    public int escenario=1;
    Inventario inventario= new Inventario();
    

    //Listas de palabras
    List<String> palabrasMover = Arrays.asList("ir","mover","caminar", "correr", "avanzar");
    List<String> palabrasPelear = Arrays.asList("golpear", "patear", "machetear");
    List<String> palabrasObservar = Arrays.asList("observar", "mirar", "ver");

 
    //mover

    public void analizarEntrada(String entrada) {

        int posicionEspacio= endtrada.indexOf(' '); //Guarda la posición donde se encuentra el espacio
        String verbo= entrada.substring(0,posicionEspacio); //Corta la cadena en donde encuentre el primer espacio. Obligatoriamente debería ser un verbo
        String complemento = endtrada.substring(posicionEspacio+1); //Todo lo que no es el verbo.
        
        if (palabrasMover.contains(verbo)) { mover(complemento); } //Se empiezan a checar las listas para ver si en alguna se encuentra el verbo ingresado
        else if(palabrasObeservar.contains(verbo)) { observar(); }      //En caso de que se encuentre, se manda a la función indicada el complemento de la entrada

    }

    public void mover(String movimiento){ //Recibe el complemento y con eso se hace un case(¿) para manejar la dirección

    }


    public void recolectar(String objeto){ //Método para almacenar en el inventario
        if(escenario.objetos.contains(objeto)) { inventario.add(objeto); }
        return;
    }

}


