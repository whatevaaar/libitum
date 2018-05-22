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
}