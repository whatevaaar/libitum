import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Escenario {

    //las características dependeran del núemero del escenario
    public int numID; //id del escenario
    public String nomEs = "";//Nombre del escenario
    ArrayList<String> objetos = new ArrayList<String>(); //Lista que incluye los posibles objetos agarrables
    ArrayList<String> objetosExtra = new ArrayList<String>(); //Lista que incluye los posibles objetos extra agarrables
    ArrayList<String> objetosEscenario = new ArrayList<String>(); //Lista de objetos que no se pueden recoger
    ArrayList<String> descripciones = new ArrayList<String>();
    ArrayList<String> descObjExtra = new ArrayList<String>(); //Lista que incluye las descripciones de objeto soltados en el escenario
    boolean salidaNorte;
    boolean salidaSur;
    boolean salidaEste;
    boolean salidaOeste;
    boolean existEnemigos;
    boolean boolObjetosExtra;  
    boolean puertaAbierta; //Bool para comprobar si la puerta ya se abrió 
    Enemigo enemigo;
    String negativaMovimiento;
    String direccionPuerta;
    String tipoPuerta;
    boolean necesitaLlave;

    public Escenario(int id, String nombre, ArrayList<String> objetosObtenibles,
                    ArrayList<String> objetosEscenario, ArrayList<String> descripciones) { //Constructor de la clase
        numID = id;
        objetos.addAll(objetosObtenibles); //.addall copia todos los elementos de la lista recibida y las traspasa a la lista objetivo
        this.descripciones.addAll(descripciones);
        nomEs += nombre;
        this.objetosEscenario = objetosEscenario;
        existEnemigos = false;
        boolObjetosExtra = false;
        puertaAbierta = false;
    }


    public Escenario(int id, String nombre, ArrayList<String> objetosObtenibles,
    ArrayList<String> objetosEscenario, ArrayList<String> descripciones, Enemigo enemigo) { //Constructor de escenario con enemigo
        numID = id;
        objetos.addAll(objetosObtenibles); //.addall copia todos los elementos de la lista recibida y las traspasa a la lista objetivo
        this.descripciones.addAll(descripciones);
        nomEs += nombre;
        this.objetosEscenario = objetosEscenario;
        existEnemigos = true;
        this.enemigo = enemigo;
        boolObjetosExtra = false;
        puertaAbierta = false;
    }
    //Establece las salidas que puede tener cierto escenario
    public void setDirecciones(boolean norte, boolean sur, boolean oeste, boolean este) {
        salidaNorte = norte;
        salidaSur = sur;
        salidaOeste = oeste;
        salidaEste = este;
    }

    public String generarMetaDatos() {
        String temp = "e" + String.valueOf(numID);
        temp += puertaAbierta ? "a" : "c"; //'a'puerta abierta, 'c' puerta cerrada
        temp += existEnemigos ? "e" : "n"; //'e' existen enemigos, 'n' no existen enemigos en escenario
        temp += boolObjetosExtra ? "o" : "q"; //'o' existen objetos extras, 'q' no existen objetos extras.
        return temp;
    }

    public void cargarMetadata(String metadatos) {
        //md[0] = 'e'; md[1] = numID; md[2] = 'a'/'c' (puerta abuerta/cerrada); 
        //md[3] = 'e'/'n' (exist enemigos); md[4] = o/n (objExt)
        char[] arregloMet = metadatos.toCharArray();
        if (arregloMet[2] == 'a') {   puertaAbierta = true; abrirDirecPuerta();} 
        existEnemigos = (arregloMet[3] == 'e') ? true: false;
        if (arregloMet[4] == 'e') 
            for(int i = 5; i < arregloMet.length-5;i++){
                String temp = generarDesc(guiaDecodificarEsc(arregloMet[i]));
                descObjExtra.add(temp);
                objetosExtra.add(temp);
                boolObjetosExtra = true;
            }
        }

    public String guiaDecodificarEsc (char caracter) { //Guía para decodifcar, actualizar cuando se agreguen objetos agarrables.
        switch(caracter){
            case '1': return "tarjeta";
            case 'd': return "documento";
        }   return null;
    }

    public boolean checarExistencia(String obj) { //Regresa valor booleano referente a la existencia de un objeto en el escenario visible
        return objetos.contains(obj);
    }
    
    public boolean checarExistenciaObjExtra(String obj) { //Regresa valor booleano referente a la existencia de un objeto en el escenario visible
        return objetosExtra.contains(obj);
    }
    public boolean checarExistenciaObjetosRelleno(String obj) {
        return objetosEscenario.contains(obj);
    }

    public boolean getExistEnemigos() {
        return existEnemigos;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }
    public boolean recogerObjeto(String obj) {
        //Usamos un objeto iterador de la biblioteca de Java para poder buscar y eliminar la oración que contiene la descripción
        //que menciona al objeto seguramente (sin causar errores de memoria)
        Iterator<String> itr = this.descripciones.iterator();
        while (itr.hasNext()) {
            String temp = itr.next(); //Almacenamos en una variable temporal la String a analizar
            if (temp.contains(obj)) {
                itr.remove();//Se elimina la descripción que involucra al objeto
                this.objetos.remove(obj); //Se elimina el objeto de la lista de objetos agarrables
                return true;
            }
        }
        return false; //El valor de regreso sólo es para confirmar el uso de la función, no se utiliza en el código.
    }

    public boolean recogerObjetoExtra(String obj) {
        //Usamos un objeto iterador de la biblioteca de Java para poder buscar y eliminar la oración que contiene la descripción
        //que menciona al objeto seguramente (sin causar errores de memoria)
        Iterator<String> itr = this.descObjExtra.iterator();
        while (itr.hasNext()) {
            String temp = itr.next(); //Almacenamos en una variable temporal la String a analizar
            if (temp.contains(obj)) {
                itr.remove();//Se elimina la descripción que involucra al objeto
                this.objetosExtra.remove(obj); //Se elimina el objeto de la lista de objetos agarrables
                return true;
            }
        }   
        return false; //El valor de regreso sólo es para confirmar el uso de la función, no se utiliza en el código.
    }

    //Agrega las descripcione establecidas para cierto escenario
    public void setDescripciones(ArrayList<String> descripciones) {
        this.descripciones.addAll(descripciones);
    }

    public void setObjetosAgarrables(ArrayList<String> objA) {
        this.objetos.addAll(objA);
    }

    //Devuelve las descripciones de un escenario
    public String getDescripcion() { //Regresa la descripción del escenario
        String temp = "";
        for (String d : descripciones) {
            temp += d + "\n";
        }
        if(existEnemigos){
            temp += enemigo.getDescripcion();
        }

        if(boolObjetosExtra){ //Si hay objetos extra ...
            for (String dO : descObjExtra) {    temp += dO + "\n";  }
        }
        return temp;
    }

    public void objetoSoltado(String objeto) { //Función que agrega obj soltados a la lista y su desc.
        objetosExtra.add(objeto);
        boolObjetosExtra = true;
        String desc = generarDesc(objeto);
        descObjExtra.add(desc);
    }

    public boolean objetosExtraVacio() {    return objetosExtra.isEmpty();  }

    public String generarDesc(String objeto) { //Función que genera una descripción sensible al genero de los objetos soltados
        int len = objeto.length();
        return "Hay un"+(objeto.substring(len-1).equals("a")? "a":"")+" "+objeto;
    }
    //Establece la oración respuesta en caso de que no se pueda mover en cierta direccion en un escenario
    public void setNegativaMovimiento(String negativa) {
        negativaMovimiento = negativa;
    }

    //Devuelve la negativa de movimiento
    public String getNegativaMovimiento() {
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
    public boolean verificarMovimiento(String direccion) {
        boolean existencia = false;
        switch (direccion) {
            case "norte": existencia = salidaNorte; break;
            case "sur": existencia = salidaSur; break;
            case "oeste": existencia = salidaOeste; break;
            case "este": existencia = salidaEste; break;
            case "izquierda": existencia = salidaOeste; break;
            case "derecha": existencia = salidaEste; break;
            default: break;
        }
        return existencia;
    }

    //Define a qué escenario cambia, dependiendo en que escenario está y la direccion que está especificando
    public int cambiarEscenario(int noEscenario, String direccion) {
        if (direccion == "izquierda"){ direccion = "oeste";} else if (direccion == "derecha"){direccion = "este";} //Convierte la direccion IZQUIERDA o DERECHA en una direccion cardinal

        if (noEscenario == 1) {
            switch (direccion) {
                case "sur":
                    noEscenario = 2;
                    break;
            }
        } else if (noEscenario == 2) {
            switch (direccion) {
                case "este":
                    noEscenario = 3;
                    break;
                case "norte":
                    noEscenario = 1;
                    break;
            }
        } else if (noEscenario == 3) {
            switch (direccion) {
                case "oeste":
                    noEscenario = 2;
                    break;
                case "sur":
                    noEscenario = 6;
                    break;
                case "norte":
                    noEscenario = 4;
                    break;
            }
        } else if (noEscenario == 4) {
            switch (direccion) {
                case "sur":
                    noEscenario = 3;
                    break;
            }
        } else if (noEscenario == 5) {
            switch (direccion) {
                case "norte":
                    noEscenario = 4;
                    break;
                case "sur":
                    noEscenario = 6;
                    break;
            }
        } else if (noEscenario == 6) {
            switch (direccion) {
                case "norte":
                    noEscenario = 5;
                    break;
            }
        }
        return noEscenario;
    }

    //Verifica primeramente si existe una puerta en el escenario, después verifica si la puerta está abierta
    //Devuelve true solo en caso de que ambas afirmaciones sean verdaderas
    public boolean salir() {
        boolean salida = false;
        if (direccionPuerta != null) {
            if (verificarMovimiento(direccionPuerta)) {
                salida = true;
            } else {
                System.out.println("La puerta está cerrada");
            }
        } else {
            System.out.println("No estás en ningún sitio de donde se deba salir");
        }
        return salida;
    }

    public boolean entrar(){
        boolean entrada = false;
        if (direccionPuerta != null) {
            if (verificarMovimiento(direccionPuerta)) {
                entrada = true;
            } else {
                System.out.println("La puerta está cerrada");
            }
        } else {
            System.out.println("No puedes entrar ahí");
        }
        return entrada;
    }

    //Verifica que es lo que quiere abrir el ususario, ya que puede ser una puerta u objetos especiales
    public void abrir(String comp){
        if (comp == null){
            System.out.println("¿Que quieres mover?");
            System.out.print(">: ");
            Scanner entradaEscanner = new Scanner(System.in);
            String entradaTeclado = entradaEscanner.nextLine();
            entradaEscanner.close();
            comp = entradaTeclado;
        }
        for (String tmp: this.objetosEscenario) {
            if (comp.contains(tmp)){
                if (tmp == "puerta"){this.abrirPuerta();}
                else if(tmp == "compartimento"){
                    System.out.println("Encontraste el primer fragmento de memoria");
                    System.out.println("\nInsertas el fragmento de memoria en tu sistema y encuentras información confusa, " +
                                    "aparentemente son archivos de produccion de androides en masa de una comporación llamada \n\"TecnoAsia\" " +
                                    "los documentos están firmados por un tal \"ADAM WEESTWOOD\", el nombre te parece familiar, pero no logras recordar.");
                    System.out.println("El fragmento de memoria hace que se activen algunos mecanismos de tu traje.");
                    System.out.println("Ahora puedes escalar muros de tamaño considerable.");
                    System.out.println("\nPuntuacion aumentada: +200");
                    Robot.habilidades.add("salto");
                    Robot.puntuacion +=20;}
                else System.out.println("No puedes mover eso");
            }else continue;
        }
    }


    //Verifica la existencia de una puerta, de ser así, activa la salida según la direccion donde esté colocada la puerta
    public void abrirPuerta() {
            if (this.checarExistenciaObjetosRelleno("puerta")) {
                if (this.necesitaLlave){  //Si la puerta necesita una llave para poder abrirse, revisa si lleva la llave, de ser así la abre, caso contrario indica que la necesita
                    if (Inventario.existencia("tarjeta")){
                        
                        System.out.println("Usando tarjeta\nPuerta abierta");
                    }else{System.out.println("No puedes abrir esta puerta, necesitas la tarjeta de acceso"); return;}
            }else {System.out.println("Puerta abierta");}
        }else {System.out.println("No hay ninguna puerta"); return;}
        abrirDirecPuerta();
    }

    public void abrirDirecPuerta() {
        switch (direccionPuerta) {
            case "norte": salidaNorte = true; break;
            case "sur": salidaSur = true; break;
            case "este": salidaEste = true; break;
            case "oeste": salidaOeste = true; break;
        }
    }

    public void cerrarPuerta(){
        if (this.checarExistenciaObjetosRelleno("puerta")) {
            switch (direccionPuerta) {
                case "norte": salidaNorte = false; break;
                case "sur": salidaSur = false; break;
                case "este": salidaEste = false; break;
                case "oeste": salidaOeste = false; break;
            }
            System.out.println("Puerta cerrada");
        } else {System.out.println("No hay ninguna puerta"); }
    }

    //Realiza el movimiento de algun objeto del escenario
    public void mover(String comp){
        for (String tmp: this.objetosEscenario) {
            if (comp.contains(tmp)){
                if (this.numID == 2){
                    System.out.println("Moviendo alfombra\nEncontraste un compartimento secreto, tiene un viejo candado consumido por el óxido, se ve falcil de abrir");
                    this.objetosEscenario.add("compartimento");
                    this.descripciones.add("Hay un compartimento secreto en el suelo al descubierto");
                    return;
                    //this.descripciones.add("Hay un compartimento secreto en el suelo");
                }
            }else continue;
        }
        System.out.println("No esta ese objeto");
    }

}