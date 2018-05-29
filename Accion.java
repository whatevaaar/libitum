package libitum;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Accion {
    //Listas de palabras
    private final List<String> palabrasMover = Arrays.asList("ir","caminar", "derrar","correr", "avanzar", "correr");
    private final List<String> palabrasInteractuar = Arrays.asList("abrir", "cerrar","subir", "bajar");
    private final List<String> palabrasPelear = Arrays.asList("golpear", "patear", "machetear");
    private final List<String> palabrasObservar = Arrays.asList("observar", "mirar", "ver");
    private final List<String> palabrasRecolectar = Arrays.asList("recolectar", "recoger", "tomar","agarrar");
    private final List<String> palabrasEspeciales= Arrays.asList("inventario","guardar","cargar","salir","ayuda");
    private final List<String> direcciones = Arrays.asList("norte", "sur", "oeste", "este");
  
    private Robot robot;
    private String instruccion;
    private String verbo;
    private String complemento;
    private int posicionActual;
    private escenario escenarioActual = null;

    //Constructor que es llamado en el momento cada que el usuario ingresa un texto en la consola
    public Accion(String instruccion, Robot robot){
        this.instruccion = instruccion;
        this.robot = robot;
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
        Ubicarse();

        //Busca en la lista de palabras...
        if (palabrasMover.contains(verbo)) { mover(); } //Se empiezan a checar las listas para ver si en alguna se encuentra el verbo ingresado
        
        else if(palabrasObservar.contains(verbo)) { observar(); }//En caso de que se encuentre, se manda a la función indicada el complemento de la entrada
        
        else if (palabrasPelear.contains(verbo)) { pelear(); } // " " " llama a pelear
        
        else if(palabrasRecolectar.contains(verbo)){recolectar(robot.inventario, complemento, escenarioActual);}
        
        else if (palabrasEspeciales.contains(verbo)) { especiales(verbo); }

        else if(palabrasInteractuar.contains(verbo)){interactuar();}
        
        else{System.out.println("No entiendo esa acción");}

    }

    public void mover(){ //Verifica si en el complemento existe una direccion cardinal, de ser asi realiza la acción.
        if(complemento == null){ //Verifica si existe un complemento despues del verbo de movimiento, de no ser así pregunta a donde se quiere mover
            System.out.println("¿A dónde quieres ir?");
            System.out.print(">: ");
            Scanner entradaEscanner = new Scanner(System.in);
            String entradaTeclado = entradaEscanner.nextLine();

            entradaEscanner.close();
            instruccion = entradaTeclado;
            prepararString();
            complemento = instruccion;
        }else {}
        for (int count = 0; count < direcciones.size(); count++) { //Itera en la lista de direcciones
            if (complemento.contains(direcciones.get(count))) { // Busca si en el complemento hay una direccion valida, DE SER ASI EJECUTA LA ACCION
                Ubicarse();
                 boolean accion = escenarioActual.verificarMovimiento(direcciones.get(count)); //Devuelve true si la accion es permiida, false en caso contrario
                if (accion == true) {
                    Ubicarse();
                    Robot.escenario = escenarioActual.cambiarEscenario(posicionActual, direcciones.get(count));
                    posicionActual = Robot.escenario;
                    GenerarEscenario();
                    System.out.println(escenarioActual.getDescripcion());
                    return;
                }else{
                    System.out.println(escenarioActual.getNegativaMovimiento()); return;
                }


                } else {
                if (count == direcciones.size() - 1) { // En caso de no envecontrar una coincidencia en esa iteracion, verifica si son todas las palabras de direccion
                    System.out.println("No entiendo a donde quieres ir, prueba con una direccion cardinal");
                } else { //Si aún hay palabras en la lista de direccion, itera de nuevo
                    continue;
                }
            }
        }
    }

    public void especiales(String esp){
        switch (esp){
            case "inventario": System.out.println(robot.inventario.mostrar()); break;
            case "guardar": guardar(robot); break;
            case "cargar": cargar(robot); break;
            case "ayuda": mensajeAyuda(); break;
            case "salir": System.exit(0);
        }
    }

    public void mensajeAyuda() {
        String mensaje = 
                        "¡Bienvenido a Libitum!\n"+
                        "Libitum es un juego basado en texto\n\n"+
                        "Algunos comandos útiles:\n"+
                        "ver : Da una descripción de tus alrededores\n"+
                        "guardar : guarda partida\ncargar : cargar partida\n"+
                        "inventario : muestra items de tu inventario\nsalir : salir del juego"+
                            "";
        System.out.println(mensaje);
    }
    public void guardar(Robot robot){
        
        String escenarioRobot = String.valueOf(robot.getEscenario());
        String vidaRobot = String.valueOf(robot.getVida());

        try {
        PrintWriter escritor = new PrintWriter("save.txt");
        escritor.println(escenarioRobot);
        escritor.println(vidaRobot);
        escritor.println(robot.inventario.codificar());
        escritor.close();  
        }
    
    catch (java.io.FileNotFoundException ex)  {
        System.out.println("Woops algo salió mal omg ");
        }
    System.out.println("¡Partida guardada!");
        
    }

    public void cargar(Robot robot) {
        try{

            BufferedReader lector = new BufferedReader(new FileReader("save.txt"));
            int nuevoEscenario = Integer.valueOf(lector.readLine());
            int nuevaVida = Integer.valueOf(lector.readLine());
            robot.inventario.decodificar(lector.readLine());
            robot.setEscenario(nuevoEscenario);
            robot.setVida(nuevaVida);
            }catch (Exception e){//Manejo de excepción
              System.err.println("Archivo de guardado no encontrado");
            }
            System.out.println("¡Partida cargada exitosamente!");
            
    }


    public void observar(){
        if (complemento == null){
            Ubicarse();
            System.out.println(escenarioActual.getDescripcion());
            return;
        }else {
            System.out.println("El objeto tiene las sig caracteristicas: ");
            return;
        }
    }

    public void recolectar(Inventario inventario, String complemento, escenario escenarioA){ //Método para almacenar en el inventario
    		if(escenarioA.checarExistencia(complemento))	{
    			inventario.almacenar(complemento);
    			System.out.println("recogido");
                escenarioA.recogerObjeto(complemento);
            	return;
    		}
    		else  {System.out.println("No puedes recoger eso");	return;}
    }

    public void interactuar(){
        Ubicarse();
        switch (verbo){
            case "subir": if (escenarioActual.checarExistenciaObjetosRelleno("escalera")){escenarioActual.salidaNorte = true; complemento = "norte"; mover();}
            else {System.out.println("No hay ninguna escalera");} break;
            case "bajar": if (escenarioActual.checarExistenciaObjetosRelleno("escalera")){escenarioActual.salidaSur = true; complemento = "sur"; mover();}
            else {System.out.println("No hay ninguna escalera");} break;
            case "abrir": if (escenarioActual.checarExistenciaObjetosRelleno("puerta")){escenarioActual.salidaEste = true; System.out.println("Puerta abierta");}
            else {System.out.println("No hay ninguna puerta");} break;
            case "cerrar": if (escenarioActual.checarExistenciaObjetosRelleno("puerta")){escenarioActual.salidaEste = false; System.out.println("Puerta cerrada");}
            else {System.out.println("No hay ninguna puerta");} break;
        }
    }

    public void pelear(){}

    public void Ubicarse(){

        posicionActual = robot.getEscenario(); //Obtiene la posicion actual del robot

        GenerarEscenario(); //Obtiene el escenario actual del robot
    }

    public void GenerarEscenario(){
        switch (posicionActual)
        {
            case 1: escenarioActual = Demo.escenario1;
                    posicionActual = 1;
                    break;
            case 2: escenarioActual = Demo.escenario2;
                    posicionActual = 2;
                    break;
            case 3: escenarioActual = Demo.escenario3;
                    posicionActual = 3;
                    break;
            case 4: escenarioActual = Demo.escenario4;
                    posicionActual = 4;
                    break;
            case 5: escenarioActual = Demo.escenario5;
                    posicionActual = 5;
                    break;
            case 6: escenarioActual = Demo.escenario6;
                    posicionActual = 6;
                    break;
        }
    }
}
