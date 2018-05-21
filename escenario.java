package libitum;

import java.util.ArrayList;
import java.util.Iterator;

public class escenario {
    /*
    //las características dependeran del número del escenario
    private int numescenario;
    private String nomesce;
    private ArrayList<SubEscenario> subEscenarios = new ArrayList<>();
    private String descripesce;

    //CONSTRUCTOR
    public Escenario(SubEscenario...subEscenarios){
        for (SubEscenario prueba : subEscenarios){
            this.subEscenarios.add(prueba);
        }
    }

    //SETTERS Y GETTERS
    public void setNumescenario() {}
    public int getNumescenario(){ return numescenario;}

    public void setNomesce(){}
    public String getNomesce(){return nomesce;}

    public void setDescripesce(String desc){}

    public String getDescripesce()
    {
        return descripesce;
    } */

    //las características dependeran del núemero del escenario
    public int numID; //id del escenario
    public String nomEs="";//Nombre del escenario
    ArrayList<String> objetos = new ArrayList<String>(); //Lista que incluye los posibles objetos agarrables
    ArrayList<String> objetosEscenario = new ArrayList<String>(); //Lista de objetos que no se pueden recoger
    ArrayList<String> descripciones = new ArrayList<String>();
    private boolean salidaNorte;
    private boolean salidaSur;
    private boolean salidaEste;
    private boolean salidaOeste;
    private String negativaMovimiento;

    public escenario (int id, String nombre,ArrayList<String> objetosObtenibles, ArrayList<String> objetosEscenario,ArrayList<String> descripciones){ //Constructor de la clase
        numID=id;
        objetos.addAll(objetosObtenibles); //.addall copia todos los elementos de la lista recibida y las traspasa a la lista objetivo
        this.descripciones.addAll(descripciones);
        nomEs += nombre;
        this.objetosEscenario.addAll(objetosEscenario);
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

    public boolean recogerObjeto(String obj) {

        //Usamos un objeto iterador de la biblioteca de Java para poder buscar y eliminar la oración que contiene la descripción
        //que menciona al objeto seguramente (sin causar errores de memoria)
        Iterator itr = this.descripciones.iterator();


        while(itr.hasNext()){
            String temp = (String) itr.next(); //Almacenamos en una variable temporal la String a analizar
            if (temp.contains(obj)){
                itr.remove();//Se elimina la descripción que involucra al objeto
                this.objetos.remove(obj); //Se elimina el objeto de la lista de objetos agarrables
                return true;}
        }
        return false; //El valor de regreso sólo es para confirmar el uso de la función, no se utiliza en el código.
    }
    //Agrega las descripcione establecidas para cierto escenario
    public void setDescripciones(ArrayList descripciones){
        this.descripciones = descripciones;
    }

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