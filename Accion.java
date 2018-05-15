package libitum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Accion {
    //Listas de palabras
    private final List<String> palabrasMover = Arrays.asList("ir","caminar", "correr", "avanzar", "correr");
    private final List<String> palabrasPelear = Arrays.asList("golpear", "patear", "machetear");
    private final List<String> palabrasObservar = Arrays.asList("observar", "mirar", "ver");
    private final List<String> palabrasRecolectar = Arrays.asList("recolectar", "recoger", "tomar");
    private final List<String> direcciones = Arrays.asList("norte", "sur", "oeste", "este");
    private String instruccion;
    private String verbo;
    private String complemento;

    //Constructor que es llamado en el momento cada que el usuario ingresa un texto en la consola
    public Accion(String instruccion){
        this.instruccion = instruccion;
        this.prepararString();
        this.analizarEntrada();
    }

    public void prepararString(){
        instruccion = instruccion.trim(); //Elimina los espacios de inicio y final en caso de existir
        instruccion = instruccion.toLowerCase(); //Pasa toda la cadena a minusculas
    }

    public void analizarEntrada() {
        if(instruccion.contains(" ")){ //Primer if verifica si la instruccion es de una sola palabra o compuesta
            int posicionEspacio= instruccion.indexOf(' '); //Guarda la posición donde se encuentra el espacio
            verbo= instruccion.substring(0,posicionEspacio); //Corta la cadena en donde encuentre el primer espacio. Obligatoriamente debería ser un verbo
            complemento = instruccion.substring(posicionEspacio+1); //Todo lo que no es el verbo.
        }else{ //Si solo es una palabra en la instruccion se asume que es un verbo
            verbo = instruccion;
        }

        if (palabrasMover.contains(verbo)) { mover(); } //Se empiezan a checar las listas para ver si en alguna se encuentra el verbo ingresado
        else if(palabrasObservar.contains(verbo)) { observar(); }//En caso de que se encuentre, se manda a la función indicada el complemento de la entrada
        else if (palabrasPelear.contains(verbo)) { pelear(); } // " " " llama a pelear
        else if(palabrasRecolectar.contains(verbo)){recolectar();}
        else{System.out.println("No entiendo esa accion");}

    }

    public void mover(){ //Verifica si en el complemento existe una direccion cardinal, de ser asi realiza la acción.
        if(complemento == null){ //Verifica si existe un complemento despues del verbo de movimiento, de no ser así pregunta a donde se quiere mover
            System.out.println("A donde quieres ir?");
            System.out.print(">: ");
            Scanner entradaEscanner = new Scanner(System.in);
            String entradaTeclado = entradaEscanner.nextLine();
            instruccion = entradaTeclado;
            prepararString();
            complemento = instruccion;
        }else {}
        for (int count = 0; count < direcciones.size(); count++) { //Itera en la lista de direcciones
            if (complemento.contains(direcciones.get(count))) { // Busca si en el complemento hay una direccion valida, DE SER ASI EJECUTA LA ACCION
                System.out.println("Moviendo a: " + direcciones.get(count));
                return;
            } else {
                if (count == direcciones.size() - 1) { // En caso de no encontrar una coincidencia en esa iteracion, verifica si son todas las palabras de direccion
                    System.out.println("No entiendo a donde quieres ir, prueba con una direccion cardinal");
                } else { //Si aún hay palabras en la lista de direccion, itera de nuevo
                    continue;
                }
            }
        }
    }

    public void observar(){
        if (complemento == null){
            System.out.println("El escenario tiene las sig caracteristicas: ");
        }else {
            System.out.println("El objeto tiene las sig caracteristicas: ");
        }
    }

    public void recolectar(){ //Método para almacenar en el inventario
        Inventario inventario = new Inventario();
        SubEscenario escenario = new SubEscenario();
        for(int count = 0; count < escenario.objetosAlmacenables.size(); count++){  //Itera en los objetos Almacenables del escenario
            if(complemento.contains(escenario.objetosAlmacenables.get(count))) { inventario.objetos.add(complemento); return;} //Si la instruccion contiene un objeto almacenable disponible, lo añade al inventario
            else{continue;} //Si no encuentra una coincidencia vuelve a iterar
        }
        for (int count = 0; count < escenario.objetosExtra.size(); count++){ //Verifica si el objeto que se quiere recolectar es un objeto de decoracion solamente
            if (complemento.contains(escenario.objetosExtra.get(count))){System.out.println("No puedes recolectar ese objeto"); return;} //Caso afirmativo
            else { continue;} //Caso negativo, sigue iterando
        }
        System.out.println("No entiendo que quieres recolectar");
    }


    public void pelear(){}

}
