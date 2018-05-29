package libitum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot {
    private int vida=100;
    public static int escenario = 2;
    Inventario inventario = new Inventario();

    public int getEscenario() { return escenario;} //Regresa el escenario

    public int getVida() { return vida;} //Regresa la vida

    public void setEscenario(int numEsc) {escenario=numEsc;}

    public void setVida(int numVida) {vida=numVida;}

} 
