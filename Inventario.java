import java.util.ArrayList;
public class Inventario {
    public static ArrayList<String> objetos = new ArrayList<>();

    //Método para agregar objetos al inventario
    public void almacenar(String nombre) { objetos.add(nombre);}

    //Método para eliminar objetos al inventario
    public void quitar(String nombre) { objetos.remove(nombre); }

    public String mostrar() { //Loop foreach para concatenar todos los nombres en el inventario y mostrarlos
        String temp = "";
        for (String o : objetos) { temp += o + "\n";}
        return temp;
    }

    public String codificar(){ //Codifica los elementos del inventario para poder ser leídos por el sistema de guardado
        String temp = "";
        for (String o : objetos) { temp.concat(guiaCodificar(o) ); }
        return temp;
    }

    public String guiaCodificar (String objeto) { //Guía de codifcar, actualizar cuando se agreguen objetos agarrables.
        switch(objeto){
            case "tarjeta": return "1";
            case "documento": return "d";

        }

        return null;
    }
}