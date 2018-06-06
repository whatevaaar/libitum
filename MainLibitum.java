import java.util.Scanner;
import java.util.ArrayList;
public class MainLibitum {

    public static void main(String[] args) {

        Demo juegoPrueba = new Demo();
        Robot personajePrincipal = new Robot();
        for (;;){
            System.out.print(">: ");
            Scanner entradaEscanner = new Scanner(System.in);
            String entradaTeclado = entradaEscanner.nextLine();
            Accion accionPrueba = new Accion(entradaTeclado,personajePrincipal);
        }
    }
}

