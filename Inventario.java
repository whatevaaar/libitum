package libitum;
import java.util.ArrayList;
public class Inventario {
    protected ArrayList<String> objetos = new ArrayList<String>();

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

    public static class JuegoApp {
        public static void main(String[] args){

        }
        public class Accion{

        }
    }
}