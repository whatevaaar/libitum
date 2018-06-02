import java.util.Random;

public class Enemigo {
    String nombre;
    boolean vivo;
    String descripcion;
    int vida;
    int dañoExtra = 0;

    public Enemigo(String nombre, int vida, String desc){
        this.nombre = nombre;
        this.vida = vida;
        descripcion = desc;
        vivo = true;
    }

    public Enemigo(String nombre, int vida, String desc, String arma){
        this.nombre = nombre;
        this.vida = vida;
        vivo = true;
        descripcion = desc;
        dañoExtra = generarDañoExtra(arma);
    }

    public int atacar() {
        Random rand = new Random();
        return rand.nextInt(10) + 1+ dañoExtra;
    }

    public int generarDañoExtra(String arma) {
        switch(arma){
            case "tubo": return 5;
        }
        return 0;
    }
    
    public void morir(){vivo = false;}

    //Gets
    public int getVida(){   return vida;   }
    public String getNombre() {  return nombre;  }
    public String getDescripcion() {    return descripcion; }

    //Sets
    public void setVida(int vida) {this.vida = vida;}
}
