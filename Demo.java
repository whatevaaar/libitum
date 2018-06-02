package libitum;
import java.util.ArrayList;

public class Demo {
    //ESCENARIO 1
    public static ArrayList<String> objEsc1 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc1 = new ArrayList<String>();
    public static  ArrayList<String> descEsc1 = new ArrayList<String>();
    public static escenario escenario1= new escenario(1, "AlmacenPlantaAlta", objEsc1, objInutilEsc1 ,descEsc1);

    //ESCENARIO 2
    public static ArrayList<String> objEsc2 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc2 = new ArrayList<String>();
    public static  ArrayList<String> descEsc2 = new ArrayList<String>();
    public static escenario escenario2= new escenario(2, "AlmacenPlantaBaja", objEsc2,objInutilEsc2 ,descEsc2);

    //ESCENARIO 3
    public static ArrayList<String> objEsc3 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc3 = new ArrayList<String>();
    public static ArrayList<String> descEsc3 = new ArrayList<String>();
    public static escenario escenario3= new escenario(3, "VertederoRobots", objEsc3, objInutilEsc3 ,descEsc3);

    //ESCENARIO 4
    public static ArrayList<String> objEsc4 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc4 = new ArrayList<String>();
    public static ArrayList<String> descEsc4 = new ArrayList<String>();
    public static escenario escenario4= new escenario(4, "Bosque", objEsc4, objInutilEsc4 ,descEsc4);

    //ESCENARIO 5
    public static ArrayList<String> objEsc5 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc5 = new ArrayList<String>();
    public static ArrayList<String> descEsc5 = new ArrayList<String>();
    public static escenario escenario5= new escenario(5, "Carretera", objEsc5, objInutilEsc5 ,descEsc5);

    //ESCENARIO 6
    public static ArrayList<String> objEsc6 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc6 = new ArrayList<String>();
    public static ArrayList<String> descEsc6 = new ArrayList<String>();
    public static escenario escenario6= new escenario(6, "Cerca", objEsc6, objInutilEsc6 ,descEsc6);


    public Demo(){
        Bienvenida();
        inicializarObjetos();
    }

    public static void inicializarObjetos(){
        //*******ESCENARIO 1********* Parte alta bodega
        objEsc1.add("tarjeta");
        objEsc1.add("documento");

        objInutilEsc1.add("Mesa");
        objInutilEsc1.add("escalera");

        descEsc1.add("Estás en la parte alta del almacen");
        descEsc1.add("Hay una mesa");
        descEsc1.add("Hay una tarjeta sobre la mesa.");
        descEsc1.add("Hay lo que parece ser un documento sobre la mesa.");
        descEsc1.add("Hay unas escaleras que van a la parte baja del almacén");


        escenario1.setDirecciones(false , false, false , false);

        escenario1.setNegativaMovimiento("No hay salida en esa direccion");
        escenario1.setDescripciones(descEsc1);
        escenario1.setObjetosAgarrables(objEsc1);

        //*******ESCENARIO 2********* Parte baja bodega
        objInutilEsc2.add("escalera");
        objInutilEsc2.add("puerta");

        descEsc2.add("Te encuentras en la planta baja de un almacén.");
        descEsc2.add("A la derecha hay una puerta abierta ");
        descEsc2.add("Hay  unas escaleras, que van a la parte alta del almacén");

        escenario2.setDirecciones(false, false, false, false);


        escenario2.setNegativaMovimiento("No hay salida en esa direccion");
        escenario2.setDescripciones(descEsc2);
        escenario2.setObjetosAgarrables(objEsc2);

        escenario2.direccionPuerta = "este";


        //*******ESCENARIO 3********* "Vertedero Robots"

        //Objetos que no se pueden almacenar
        objInutilEsc3.add("Robots");
        objInutilEsc3.add("puerta");
        descEsc3.add("Este del almacen");
        descEsc3.add("Ahí esta la puerta de entrada del almacén");
        descEsc3.add("Estás fuera del almacen, frente a ti hay un vertedero con restos de robots por todas partes.");

        escenario3.setDirecciones(true, true, true, false);

        escenario3.setNegativaMovimiento("No puedes ir ahí, hay un vertedero inmenso con robots inservibles apilados, \nhasta donde alcanza la vista");
        escenario3.setDescripciones(descEsc3);

        escenario3.direccionPuerta = "oeste";

        //******ESCENARIO 4******* "Bosque"

        //No hay objetos para almacenar

        //Objetos que no se pueden almacenar
        objInutilEsc4.add("Arboles");
        objInutilEsc4.add("Ardilla");

        descEsc4.add("Norte del almacen");
        descEsc4.add("Estás parado frente a un bosque");

        escenario4.setDirecciones(false, true, false, false);
        escenario4.setNegativaMovimiento("Un bosque inmenso cubre todo el norte, no puedes ir al ahí");
        escenario4.setDescripciones(descEsc4);

        //*****ESCENARIO 5******* "Carretera"

        //No hay objetos para almacenar

        //Objetos que no se pueden almacenar
        objInutilEsc5.add("Pavimento");

        descEsc5.add("Oeste del almacén");
        descEsc5.add("En el oeste hay una carretera.");
        descEsc5.add("Pavimento hasta donde se alcanza a ver.");
        escenario5.setDirecciones(true, true, false, false);
        escenario5.setNegativaMovimiento("No puedes ir por la carretera en esas condiciones");
        escenario5.setDescripciones(descEsc5);

        //*****ESCENARIO 6******* "Cerca"

        //No hay objetos para almacenar

        //Objetos que no se pueden almacenar

        objInutilEsc6.add("Cerca");

        descEsc6.add("Sur del almacen");
        descEsc6.add("Al sur te encuentras ante una enorme cerca");
        descEsc6.add("Es color blanco y parece que podrías escalarla con el equipo adecuado.");
        escenario6.setDirecciones(true, false,false,false);
        escenario6.setNegativaMovimiento("No puedes escalar la cerca, por ahora");
        escenario6.setDescripciones(descEsc6);
    }

    public static void Bienvenida(){
        System.out.println("LIBITUM un juego que probará tu paciencia, imaginación y habilidades. \nMuchos han iniciado esta aventura y han fallado. Suerte.");
        System.out.println("Escribe \"Ayuda\" en cualquier momento para recibir informacion");
    }
}
