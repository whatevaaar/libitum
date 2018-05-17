/**
 * Clase principal
 */
public class libitum {
    public static void main(String[] args) {

        robot jugador = new robot();
       
        //Listas de objetos requeridas por escenario y creación 
        
        ///Escenario 1 "Almacén planta alta"
        
        //Objetos para almacenar
        ArrayList<String> objEsc1 = new ArrayList<String>();
        objEsc1.add("tarjeta");
        objEsc1.add("Documento");
        
        //Objetos que no se pueden almacenar
        ArrayList<String> objInutilEsc1 = new ArrayList<String>();
        objInutilEsc1.add("Mesa");
        objInutilEsc1.add("Escalera");

        ArrayList<String> descEsc1 = new ArrayList<String>();
        descEsc1.add("Bienvenido, por fin has despertado... Te encuentras en un almacén.");
        descEsc1.add("A la izquierda hay una mesa y en la parte de abajo unas escaleras.");
        descEsc1.add("Sobre la mesa hay una tarjeta y lo que parece ser un documento.");
        
        escenario escenario1= new escenario(
            1, "AlmacenPlantaAlta", objEsc1,objInutilEsc1 ,descEsc1
        );

        //Escenario 2..

        ///Escenario2  "Almacén planta baja"
        //No hay objetos para almacenar
        ArrayList<String> objEsc2 = new ArrayList<String>();
        
        //Objetos que no se pueden almacenar
        ArrayList<String> objInutilEsc2 = new ArrayList<String>();
        objInutilEsc2.add("Escalera");
        objInutilEsc2.add("Puerta");

        ArrayList<String> descEsc2 = new ArrayList<String>();
        descEsc2.add("Este cuarto parece vacío, no hay más que una puerta a la derecha.");
        
        escenario escenario2= new escenario(
            2, "AlmacenPlantaBaja", objEsc2,objInutilEsc2 ,descEsc2
        );
        
        //Escenario 3 "Vertedero Robots"
        
        //No hay objetos para almacenar
        ArrayList<String> objEsc3 = new ArrayList<String>();
        
        //Objetos que no se pueden almacenar
        ArrayList<String> objInutilEsc3 = new ArrayList<String>();
        objInutilEsc3.add("Robots");

        ArrayList<String> descEsc3 = new ArrayList<String>();
        descEsc3.add("Has salido del almacen, frente a ti hay un monton de robots.");
        descEsc3.add("Más robots.");
        
        escenario escenario3= new escenario(
            3, "VertederoRobots", objEsc3, objInutilEsc3 ,descEsc3
        );
        
        //Escenario 4 "Bosque"
        
        //No hay objetos para almacenar
        ArrayList<String> objEsc4 = new ArrayList<String>();
        
        //Objetos que no se pueden almacenar
        ArrayList<String> objInutilEsc4 = new ArrayList<String>();
        objInutilEsc4.add("Arboles");
        objInutilEsc4.add("Ardilla");

        ArrayList<String> descEsc4 = new ArrayList<String>();
        descEsc4.add("Al norte hay un bosque.");
        descEsc4.add("Puros árboles.");
        
        escenario escenario4= new escenario(
            4, "Bosque", objEsc4, objInutilEsc4 ,descEsc4
        );
        
        //Escenario 5 "Carretera"

        //No hay objetos para almacenar
        ArrayList<String> objEsc5 = new ArrayList<String>();
        
        //Objetos que no se pueden almacenar
        ArrayList<String> objInutilEsc5 = new ArrayList<String>();
        objInutilEsc5.add("Pavimento");

        ArrayList<String> descEsc5 = new ArrayList<String>();
        descEsc5.add("En el oeste hay una carretera.");
        descEsc5.add("Pavimento infinito.");
        
        escenario escenario5= new escenario(
            5, "Carretera", objEsc5, objInutilEsc5 ,descEsc5
        ); 
        
        //Escenario 6 "Cerca"

        //No hay objetos para almacenar
        ArrayList<String> objEsc6 = new ArrayList<String>();
        
        //Objetos que no se pueden almacenar
        ArrayList<String> objInutilEsc6 = new ArrayList<String>();
        objInutilEsc6.add("Cerca");

        ArrayList<String> descEsc6 = new ArrayList<String>();
        descEsc6.add("Al sur te encuentras ante una enorme cerca");
        descEsc6.add("Parece que la cerca no termina.");
        
        escenario escenario6= new escenario(
            6, "Cerca", objEsc6, objInutilEsc6 ,descEsc6
        );         
        
    }
    
}
