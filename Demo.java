    import java.util.ArrayList;

public class Demo {
    //ESCENARIO 1
    public static ArrayList<String> objEsc1 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc1 = new ArrayList<String>();
    public static  ArrayList<String> descEsc1 = new ArrayList<String>();
    public static Escenario escenario1= new Escenario(1, "AlmacenPlantaAlta", objEsc1, objInutilEsc1,descEsc1);

    //ESCENARIO 2
    public static ArrayList<String> objEsc2 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc2 = new ArrayList<String>();
    public static  ArrayList<String> descEsc2 = new ArrayList<String>();
    public static Escenario escenario2= new Escenario(2, "AlmacenPlantaBaja", objEsc2, objInutilEsc2, descEsc2);

    //ESCENARIO 3
    public static ArrayList<String> objEsc3 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc3 = new ArrayList<String>();
    public static ArrayList<String> descEsc3 = new ArrayList<String>();
    public static Escenario escenario3= new Escenario(3, "VertederoRobots", objEsc3, objInutilEsc3, descEsc3);

    //ESCENARIO 4
    public static ArrayList<String> objEsc4 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc4 = new ArrayList<String>();
    public static ArrayList<String> descEsc4 = new ArrayList<String>();
    public static Escenario escenario4= new Escenario(4, "Bosque", objEsc4, objInutilEsc4, descEsc4);

    //ESCENARIO 5
    public static ArrayList<String> objEsc5 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc5 = new ArrayList<String>();
    public static ArrayList<String> descEsc5 = new ArrayList<String>();
    public static Escenario escenario5= new Escenario(5, "Carretera", objEsc5, objInutilEsc5, descEsc5);

    //ESCENARIO 6 PRUEBA PELEA
    public static ArrayList<String> objEsc6 = new ArrayList<String>();
    public static ArrayList<String> objInutilEsc6 = new ArrayList<String>();
    public static ArrayList<String> descEsc6 = new ArrayList<String>();
    public static Enemigo enemigo = new Enemigo("La mafia del poder",20,"Mira nada más\nun loco");
    public static Escenario escenario6 = new Escenario(6, "Muro", objEsc6, objInutilEsc6 ,descEsc6, enemigo);
-
-    //ESCENARIO 7
-    public static  ArrayList<String> objEsc7 = new ArrayList<>();
-    public static ArrayList<String> objInutilEsc7 = new ArrayList<>();
-    public static ArrayList<String> descEsc7 = new ArrayList<>();
-    public static Escenario escenario7 = new Escenario(7, "Basurero", objEsc7, objInutilEsc7,descEsc7);
-
-    //ESCENARIO 8
-    public static  ArrayList<String> objEsc8 = new ArrayList<>();
-    public static ArrayList<String> objInutilEsc8 = new ArrayList<>();
-    public static ArrayList<String> descEsc8 = new ArrayList<>();
-    public static Enemigo enemigo1 = new Enemigo("ARLOK-24", 20, "Robot hostil, te ataca abruptamente pero logras esquivarlo");
-    public static Escenario escenario8 = new Escenario(8, "Frente de la cabaña", objEsc8, objInutilEsc8,descEsc8, enemigo1);

    public static ArrayList<Escenario> listaNiveles = new ArrayList<Escenario>();
    
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
        objInutilEsc2.add("alfombra");

        descEsc2.add("Te encuentras en la planta baja de un almacén.");
        descEsc2.add("A la derecha hay una puerta abierta ");
        descEsc2.add("Hay  unas escaleras, que van a la parte alta del almacén");
        descEsc2.add("Hay una alfombra color escarlata en el centro");

        escenario2.setDirecciones(false, false, false, false);


        escenario2.setNegativaMovimiento("No hay salida en esa direccion");
        escenario2.setDescripciones(descEsc2);
        escenario2.setObjetosAgarrables(objEsc2);

        escenario2.direccionPuerta = "este";
        escenario2.tipoPuerta = "salida"; 
        escenario2.necesitaLlave = true;


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
        escenario3.tipoPuerta = "entrada";
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

        objInutilEsc6.add("Muro");

        descEsc6.add("Sur del almacen");
        descEsc6.add("Te encuentras ante un enorme muro de concreto");
        descEsc6.add("Hay una grieta por donde podrías pasar, pero está muy alto");
  
        escenario6.setDirecciones(true, false,false,false);
        escenario6.setNegativaMovimiento("No puedes saltar hasta la grieta, por ahora");
        escenario6.setDescripciones(descEsc6);
        public static Escenario escenario6 = new Escenario(6, "Muro", objEsc6, objInutilEsc6 ,descEsc6, enemigo);
-
-    //ESCENARIO 7
-    public static  ArrayList<String> objEsc7 = new ArrayList<>();
-    public static ArrayList<String> objInutilEsc7 = new ArrayList<>();
-    public static ArrayList<String> descEsc7 = new ArrayList<>();
-    public static Escenario escenario7 = new Escenario(7, "Basurero", objEsc7, objInutilEsc7,descEsc7);
-
-    //ESCENARIO 8
-    public static  ArrayList<String> objEsc8 = new ArrayList<>();
-    public static ArrayList<String> objInutilEsc8 = new ArrayList<>();
-    public static ArrayList<String> descEsc8 = new ArrayList<>();
-    public static Enemigo enemigo1 = new Enemigo("ARLOK-24", 20, "Robot hostil, te ataca abruptamente pero logras esquivarlo");
-    public static Escenario escenario8 = new Escenario(8, "Frente de la cabaña", objEsc8, objInutilEsc8,descEsc8, enemigo1);
+    public static Escenario escenario6= new Escenario(6, "Cerca", objEsc6, objInutilEsc6 ,descEsc6, enemigo);
        //Inicialización de lista de niveles
        listaNiveles.add(escenario1);
        listaNiveles.add(escenario2);
        listaNiveles.add(escenario3);
        listaNiveles.add(escenario4);
        listaNiveles.add(escenario5);
        listaNiveles.add(escenario6);
    }

    public static void Bienvenida(){
        System.out.println("LIBITUM un juego que probará tu paciencia, imaginación y habilidades. \nMuchos han iniciado esta aventura y han fallado. Suerte.");
        System.out.println(escenario2.getDescripcion());
        System.out.println("Escribe \"Ayuda\" en cualquier momento para recibir informacion");
    }
}
