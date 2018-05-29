package libitum;
import java.util.ArrayList;
import java.util.Iterator;

public class escenario {

    //las características dependeran del núemero del escenario
    public int numID; //id del escenario
    public String nomEs="";//Nombre del escenario
    ArrayList<String> objetos = new ArrayList<String>(); //Lista que incluye los posibles objetos agarrables
    ArrayList<String> objetosEscenario = new ArrayList<String>(); //Lista de objetos que no se pueden recoger
    ArrayList<String> descripciones = new ArrayList<String>();
    boolean salidaNorte;
    boolean salidaSur;
    boolean salidaEste;
    boolean salidaOeste;
    private String negativaMovimiento;
    //private String direccionPuerta;
    //private String direccionEscalera;


    public escenario (int id, String nombre,ArrayList<String> objetosObtenibles, ArrayList<String> objetosEscenario,ArrayList<String> descripciones){ //Constructor de la clase
        numID=id;
        objetos.addAll(objetosObtenibles); //.addall copia todos los elementos de la lista recibida y las traspasa a la lista objetivo
        this.descripciones.addAll(descripciones);
        nomEs += nombre;

        this.objetosEscenario=objetosEscenario;
    }
    //Establece las salidas que puede tener cierto escenario
    public void setDirecciones(boolean norte, boolean sur, boolean oeste, boolean este){
        salidaNorte = norte;
        salidaSur = sur;
        salidaOeste = oeste;
        salidaEste = este;
    }
    public boolean checarExistencia(String obj) { //Regresa valor booleano referente a la existencia de un objeto en el escenario visible
        return objetos.contains(obj) ? true: false;
    }

    public boolean checarExistenciaObjetosRelleno(String obj){
            return objetosEscenario.contains(obj);
        }
    public boolean recogerObjeto(String obj) {

        //Usamos un objeto iterador de la biblioteca de Java para poder buscar y eliminar la oración que contiene la descripción
        //que menciona al objeto seguramente (sin causar errores de memoria)
        Iterator<String> itr = this.descripciones.iterator();


        while(itr.hasNext()){
            String temp = itr.next(); //Almacenamos en una variable temporal la String a analizar
            if (temp.contains(obj)){
                itr.remove();//Se elimina la descripción que involucra al objeto
                this.objetos.remove(obj); //Se elimina el objeto de la lista de objetos agarrables
                return true;}
        }
        return false; //El valor de regreso sólo es para confirmar el uso de la función, no se utiliza en el código.
    }

    //Agrega las descripcione establecidas para cierto escenario
    public void setDescripciones(ArrayList<String> descripciones){ this.descripciones.addAll(descripciones); }

    public void setObjetosAgarrables(ArrayList<String> objA){ this.objetos.addAll(objA); }

    //Devuelve las descripciones de un escenario
    public String getDescripcion() { //Regresa la descripción del escenario
        String temp = "";
        for (String d : descripciones) {temp += d +"\n";}
        return temp;
    }

    //Establece la oración respuesta en caso de que no se pueda mover en cierta direccion en un escenario
    public void setNegativaMovimiento(String negativa){
        negativaMovimiento = negativa;
    }

    //Devuelve la negativa de movimiento
    public String getNegativaMovimiento(){
        return negativaMovimiento;
    }

    //Establece la direecion a la que dirige la escalera
    //public void setDireccionEscalera(String direccion){direccionEscalera = direccion;}
    //Devuelve la direccion a la que dirige la escalera
    //public String getDireccionEscalera(){return  direccionEscalera;}
    //Establece la direccion a la que dirige la puerta
    //public void setDireccionPuerta(String direccion){direccionPuerta = direccion;}
    //Devuelve la direccion a la que direige la puerta
   // public String getDireccionPuerta(){return direccionPuerta;}



    //Verifica si el movimiento que se quiere hacer es válido, segun el diseño del escenario
    public boolean verificarMovimiento(String direccion){
        boolean existencia = false;
        switch (direccion){
            case "norte": existencia= salidaNorte;
                break;
            case "sur": existencia = salidaSur;
                break;
            case "oeste": existencia = salidaOeste;
                break;
            case "este": existencia = salidaEste;
                break;
            default: break;
        }
        return existencia;
    }

    //Define a qué escenario cambia, dependiendo en que escenario está y la direccion que está especificando
    public  int cambiarEscenario(int noEscenario, String direccion){
        if(noEscenario == 1){
            switch (direccion){
                case "sur": noEscenario = 2; break;
            }
        }
        else if(noEscenario == 2){
            switch (direccion){
                case "este": noEscenario = 3; break;
                case "norte": noEscenario = 1; break;
            }
        }
        else if(noEscenario == 3){
            switch (direccion){
                case "oeste": noEscenario = 2; break;
                case "sur": noEscenario = 6; break;
                case "norte": noEscenario = 4; break;
            }
        }
        else if(noEscenario == 4){
            switch (direccion){
                case "sur": noEscenario = 3; break;
            }
        }
        else if(noEscenario == 5){
            switch (direccion){
                case "norte": noEscenario = 4; break;
                case "sur": noEscenario = 6; break;
            }
        }
        else if(noEscenario == 6){
            switch (direccion){
                case "norte": noEscenario = 5; break;
            }
        }
        return  noEscenario;
    }

}