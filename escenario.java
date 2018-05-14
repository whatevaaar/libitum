package libitum;

import java.util.ArrayList;

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

	public boolean checarExistencia(String obj) { //Regresa valor booleano referente a la existencia de un objeto en el escenario
		return objetos.contains(obj) ? true: false; 
	}

	public boolean recogerObjeto(String obj) {
		for (String descripciones : d) {
			
		}
	}
}