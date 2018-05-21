package libitum;
import java.util.ArrayList;
public class Inventario {
    public static ArrayList<String> objetos = new ArrayList<>();

    public void almacenar(String nombre) {
        objetos.add(nombre);
    }

    public void quitar(String nombre) {
        objetos.remove(nombre);
    }

    public String mostrar() { //Loop foreach para concatenar todos los nombres en el inventario y mostrarlos
        String temp = "";
        for (String o : objetos) {
            temp += o + "\n";
        }
        return temp;
    }
}