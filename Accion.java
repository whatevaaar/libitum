package libitum;

import libitum.Demo;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Accion {
    //Listas de palabras
    private final List<String> palabrasMover = Arrays.asList("ir","caminar", "derrar","correr", "avanzar", "correr");
    private final List<String> palabrasInteractuar = Arrays.asList("abrir", "cerrar","subir", "bajar", "salir", "saltar","entrar", "mover");
    private final List<String> palabrasPelear = Arrays.asList("golpear", "atacar", "pelear");
    private final List<String> palabrasObservar = Arrays.asList("observar", "mirar", "ver");
    private final List<String> palabrasRecolectar = Arrays.asList("recolectar", "recoger", "tomar","agarrar");
    private final List<String> palabrasEspeciales= Arrays.asList("inventario","guardar","cargar","ayuda","diagnostico","soltar");
    private final List<String> direcciones = Arrays.asList("norte", "sur", "oeste", "este", "izquierda","derecha");
    private final List<String> palabrasPeleaDA = Arrays.asList("mano", "manos", "puños","brazos"); //Desarmado
    
    private static Scanner entradaEscanner = new Scanner(System.in);
    
    private consolita c;
    private Robot robot;
    private String instruccion;
    private String verbo;
    private String complemento;
    private int posicionActual;
    private Escenario escenarioActual = null;
    private JTextField field;


    //Constructor que es llamado en el momento cada que el usuario ingresa un texto en la consola
    public Accion(String instruccion, Robot robot, consolita c){        
        this.instruccion = instruccion;
        this.robot = robot;
        this.c = c;
        this.prepararString();
        this.analizarEntrada();
        
    }
    
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
        Ubicarse();

        //Busca en la lista de palabras...
        if (palabrasMover.contains(verbo)) { mover(); } //Se empiezan a checar las listas para ver si en alguna se encuentra el verbo ingresado
        
        else if(palabrasObservar.contains(verbo)) { observar(); }//En caso de que se encuentre, se manda a la función indicada el complemento de la entrada
        
        else if (palabrasPelear.contains(verbo)) { pelear(); } // " " " llama a pelear
        
        else if(palabrasRecolectar.contains(verbo)){recolectar();}
        
        else if (palabrasEspeciales.contains(verbo)) { especiales(verbo); }

        else if(palabrasInteractuar.contains(verbo)){interactuar();}
        
        else{c.imprimir("No entiendo esa acción");}

    }

    public void mover(){ //Verifica si en el complemento existe una direccion cardinal, de ser asi realiza la acción.
        if(complemento == null){ //Verifica si existe un complemento despues del verbo de movimiento, de no ser así pregunta a donde se quiere mover
            c.imprimir("¿A dónde quieres ir?");
            c.imprimir(">: ");
            String entradaTeclado = c.entrada();
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
                    c.imprimir(escenarioActual.getDescripcion());
                    return;
                }else{  //Si intenta moverse en una direccion no válida y en esa direccion hay una puerta indica que esta está cerrada
                    if (escenarioActual.checarExistenciaObjetosRelleno("puerta")){
                        String direccion = direcciones.get(count);
                        if (direccion == "izquierda"){ direccion = "oeste";} else if (direccion == "derecha"){direccion = "este";} //Convierte la direccion IZQUIERDA o DERECHA en una direccion cardinal
                        if (escenarioActual.direccionPuerta == direccion){
                            c.imprimir("Puerta cerrada"); break;
                        }else {c.imprimir(escenarioActual.getNegativaMovimiento()); break;}
                    }else {c.imprimir(escenarioActual.getNegativaMovimiento()); break;}
                }
                } else {
                if (count == direcciones.size() - 1) { // En caso de no envecontrar una coincidencia en esa iteracion, verifica si son todas las palabras de direccion
                    c.imprimir("No entiendo a donde quieres ir, prueba con una direccion cardinal");
                } else { //Si aún hay palabras e        Random rand = new Random();
                    continue;
                }
            }
        }
    }


    public void especiales(String esp){
        switch (esp){
            case "inventario": c.imprimir(robot.inventario.mostrar()); break;
            case "guardar": guardar(robot); break;
            case "cargar": cargar(); break;
            case "ayuda": mensajeAyuda(); break;
            case "diagnostico": diagnosticar(); break;
            case "soltar": soltar(); break;
        }
    }



    private void soltar() {
        if (complemento == null){
            c.imprimir(">:¿Qué quieres soltar?");
            String entradaTeclado = c.entrada();
            if(robot.inventario.existencia(entradaTeclado)){
                int len = entradaTeclado.length();
                robot.soltarObj(entradaTeclado);
                escenarioActual.objetoSoltado(entradaTeclado);
                c.imprimir(entradaTeclado+" soltad"+(entradaTeclado.substring(len-1).equals("a")? "a":"o"));
                return;
            }
            else{
                c.imprimir("No tienes "+entradaTeclado);           
                return;}
        }
        if(robot.inventario.existencia(complemento)){
        escenarioActual.objetoSoltado(complemento);
        robot.soltarObj(complemento);
        }
        else{c.imprimir("No tienes "+complemento);}
}     

    public void diagnosticar() {
        if (90 < robot.getVida()){c.imprimir("Estado de salud óptimo");}
        else if (80 < robot.getVida()){c.imprimir("Estás no tan súper duper");}
        else if (60 < robot.getVida()){c.imprimir("Buscar asistencia");}
        else if (40 < robot.getVida()){c.imprimir("Buscar asistencia a la brevedad");}

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
        c.imprimir(mensaje);
    }
    
    public void guardar(Robot robot){
        String escenarioRobot = String.valueOf(robot.getEscenario());
        String vidaRobot = String.valueOf(robot.getVida());
        try {
        PrintWriter escritor = new PrintWriter("save.txt");
        escritor.println(escenarioRobot);
        escritor.println(vidaRobot);
        escritor.println(robot.inventario.codificar());
        for (Escenario e : Demo.listaNiveles) { escritor.println(e.generarMetaDatos()); }
        escritor.close();  
        }
        
        catch (java.io.FileNotFoundException ex){   c.imprimir("Woops algo salió mal omg ");  }
        c.imprimir("¡Partida guardada!");
    }

    public void cargar() {
        try{

            BufferedReader lector = new BufferedReader(new FileReader("save.txt"));
            int nuevoEscenario = Integer.valueOf(lector.readLine());
            int nuevaVida = Integer.valueOf(lector.readLine());
            robot.inventario.decodificar(lector.readLine());
            robot.setEscenario(nuevoEscenario);
            robot.setVida(nuevaVida);
            cargarEscenarios(lector);
            lector.close();
            }catch (Exception e){//Manejo de excepción
              System.err.println("Archivo de guardado no encontrado");
            }
            c.imprimir("¡Partida cargada exitosamente!");
    }

    public void cargarEscenarios(BufferedReader lector) {
        for (Escenario e : Demo.listaNiveles) {
            for (String string : robot.inventario.getInventario()) {    e.recogerObjeto(string);    }
            try{    e.cargarMetadata(lector.readLine());    }
            catch (Exception ex){   System.err.println("Archivo de guardado no encontrado");    }
        }
    }

    public void observar(){
            c.imprimir("vivo");
        if (complemento == null){
            Ubicarse();
            c.imprimir(String.valueOf(robot.getEscenario()));                     
            c.imprimir(escenarioActual.getDescripcion());
            return;
        }else {
            c.imprimir("El objeto tiene las sig caracteristicas: ");
            return;
        }
    }

    public void recolectar(){ //Método para almacenar en el inventario
    		if(escenarioActual.checarExistencia(complemento))	{
    			robot.inventario.almacenar(complemento);
    			c.imprimir("recogido");
                escenarioActual.recogerObjeto(complemento);
            	return;
            }
            
            else if(escenarioActual.checarExistenciaObjExtra(complemento)){
                robot.inventario.almacenar(complemento);
                c.imprimir("recogido");
                escenarioActual.recogerObjetoExtra(complemento);
            }
    		else  {c.imprimir("No puedes recoger eso");	return;}
    }

    public void interactuar(){
        Ubicarse();
        switch (verbo){
            case "subir": if (escenarioActual.checarExistenciaObjetosRelleno("escalera")){escenarioActual.salidaNorte = true; complemento = "norte"; mover();}
                else {c.imprimir("No hay ninguna escalera");} break;
            case "bajar": if (escenarioActual.checarExistenciaObjetosRelleno("escalera")){escenarioActual.salidaSur = true; complemento = "sur"; mover();}
                else {c.imprimir("No hay ninguna escalera");} break;
            case "abrir": escenarioActual.abrir(complemento,c); break;
            case "cerrar": escenarioActual.cerrarPuerta(c); break;
            case "salir": if (escenarioActual.salir(c)){this.complemento = escenarioActual.direccionPuerta; mover();} break; //En caso de devolver true, hace el movimiento simulando subir una escalera
            case "entrar": if (escenarioActual.entrar(c)){this.complemento = escenarioActual.direccionPuerta; mover();} break;
            case "mover": escenarioActual.mover(complemento,c); break;
            case "saltar": escenarioActual.saltar(c, complemento); break;
        }
    }
    public int pelearComplemento(String complementoPelea){ //Regresa el daño basado en lo que el jugador use para atacar
        int dañoExtra;
        if (palabrasPeleaDA.contains(complementoPelea)){ dañoExtra = 0;}
        else if (!robot.inventario.existencia(complementoPelea))  {c.imprimir("No tienes" + complementoPelea); dañoExtra = 0;}
        else{ dañoExtra = robot.generarDañoExtra(complementoPelea); }
        return dañoExtra;
    }
    public void pelear(){
        int dañoExtra = 0;
        if (!escenarioActual.getExistEnemigos()){   c.imprimir("No hay nadie con quién pelear aquí");   return;}

        if (complemento == null){
            c.imprimir(">:¿Con qué?");
            String entradaTeclado = c.entrada();
            dañoExtra = pelearComplemento(entradaTeclado);
        }
        else if(complemento.contains(" ")){
            int indexEspacio = complemento.lastIndexOf(" ");
            pelearComplemento(complemento.substring(indexEspacio,complemento.length()-1));
        }
        else {  pelearComplemento(complemento);   }

        Random rand = new Random();
        Enemigo enemigo = escenarioActual.getEnemigo();
        int vidaEnem = enemigo.getVida() - (rand.nextInt(10) + 1) - dañoExtra;
        int vidaRobot = robot.getVida() - enemigo.atacar();
        if (vidaEnem > 0){
            c.imprimir("Atacaste a " + enemigo.getNombre());
            enemigo.setVida(vidaEnem);
            c.imprimir("¡"+enemigo.getNombre()+" te ha atacado!");
            if (vidaRobot < 0){
                morir();
            }
            return; 
        }
        c.imprimir("Matataste a " + enemigo.getNombre());
        enemigo.morir();
        return;
    }

    public void morir() {
        c.imprimir("Haz muerto");
        // Penalización o whatevar

    }
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
            case 7: escenarioActual = Demo.escenario6;
                    posicionActual = 7;
                    break;
            case 8: escenarioActual = Demo.escenario6;
                    posicionActual = 8;
                    break;
        }
    }
}
