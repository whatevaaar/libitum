package libitum;
import java.util.Scanner;
public class MainLibitum {
    public static void main(String[] args) {
        System.out.println("\t\t\t Bienvendio a Libitum, un juego de aventura en el que tu ingenio e imaginación determinarán el rumbo de la historia");
        System.out.println("Te encuentras en: \n\n");
        for (int count = 0;;count++){
            System.out.print(">: ");
            Scanner entradaEscanner = new Scanner(System.in);
            String entradaTeclado = entradaEscanner.nextLine();
            Accion accionPrueba = new Accion(entradaTeclado);
        }
    }
}
