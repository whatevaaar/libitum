package libitum;
import java.util.Arrays;
import java.util.List;

public class Accion {
    //Listas de palabras
    protected final List<String> palabrasMover = Arrays.asList("ir","caminar", "correr", "avanzar");
    protected final List<String> palabrasPelear = Arrays.asList("golpear", "patear", "machetear");
    protected final List<String> palabrasObservar = Arrays.asList("observar", "mirar", "ver");



    //mover
    public void analizarEntrada(String entrada) {
        int posicionEspacio= entrada.indexOf(' '); //Guarda la posición donde se encuentra el espacio
        String verbo= entrada.substring(0,posicionEspacio); //Corta la cadena en donde encuentre el primer espacio. Obligatoriamente debería ser un verbo
        String complemento =        entrada.substring(posicionEspacio+1); //Todo lo que no es el verbo.

        if (palabrasMover.contains(verbo)) { mover(complemento); } //Se empiezan a checar las listas para ver si en alguna se encuentra el verbo ingresado
        else if(palabrasObservar.contains(verbo)) { observar(); }      //En caso de que se encuentre, se manda a la función indicada el complemento de la entrada

    }

    public void mover(String movimiento){ //Recibe el complemento y con eso se hace un case(¿) para manejar la dirección
    }


    public void recolectar(String objeto){ //Método para almacenar en el inventario
        Inventario inventario = new Inventario();
        SubEscenario escenario = new SubEscenario();
        if(escenario.objetosAlmacenables.contains(objeto)) { inventario.objetos.add(objeto); }
        return;
    }

    public void observar(){ //get_descripcion(de escenario)//
    }

}
