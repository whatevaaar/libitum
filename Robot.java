package libitum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot {
    static int vida=100;
    public static int escenario = 2;
    Inventario inventario = new Inventario();
    static ArrayList<String> habilidades = new ArrayList<>();
    static int puntuacion;

    public int getEscenario() { return escenario;} //Regresa el escenario

    public int getVida() { return vida;} //Regresa la vida

    public void setEscenario(int numEsc) {escenario=numEsc;}

    public void setVida(int numVida) {vida=numVida;}

    public void soltarObj(String obj) { inventario.quitar(obj); }
    
    public int generarDañoExtra(String arma) {
        switch(arma){
            case "tubo": return 5;
        }
        return 0;
    }
    public static boolean buscarHabilidad(String habilidad){
         return habilidades.contains(habilidad);
     }
 
     public static void addHabilidad(String habilidad){
         habilidades.add(habilidad);
     }
} 
