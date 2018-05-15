package libitum;

import java.util.ArrayList;
import java.util.Iterator;


public class escenario{
	
//las características dependeran del núemero del escenario
	public int numID; //id del escenario
	public String nomEs="";//Nombre del escenario
	ArrayList<String> objetos = new ArrayList<String>(); //Lista que incluye los posibles objetos agarrables
	ArrayList<String> descripciones = new ArrayList<String>(); 
	

	public escenario (int id, String nombre,List<String> objetosObtenibles, List<String> descripciones){ //Constructor de la clase
		numID=id;
		objetos.addall(objetosObtenibles); //.addall copia todos los elementos de la lista recibida y las traspasa a la lista objetivo
		this.descripciones.addall(descripciones); 
		nomEs += nombre;
	}

	public boolean checarExistencia(String obj) { //Regresa valor booleano referente a la existencia de un objeto en el escenario visible
		return objetos.contains(obj) ? true: false; 
	}

	public boolean recogerObjeto(String obj) {

		//Usamos un objeto iterador de la biblioteca de Java para poder buscar y eliminar la oración que contiene la descripción
		//que menciona al objeto seguramente (sin causar errores de memoria)
		Iterator itr = this.descripciones.Iterator();


		while(itr.hasNext()){
			String temp = itr.next(); //Almacenamos en una variable temporal la String a analizar
			if (temp.contains(obj)){ 
				itr.remove();//Se elimina la descripción que involucra al objeto
				this.objetos.remove(obj); //Se elimina el objeto de la lista de objetos agarrables
				return true;}
		}
		return false; //El valor de regreso sólo es para confirmar el uso de la función, no se utiliza en el código.
	}

	public String getDescripcion() { //Regresa la descripción del escenario
		String temp = "";
        for (String d : this.descripciones) {temp += o +"\n";}
        return temp;
	}
}