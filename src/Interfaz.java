import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Qué nivel quieres usar? (1 o 2):");
        System.out.print("> ");
        String opcion = teclado.nextLine().trim();
        Lanzador lanzador = new Lanzador();

        while (true) {
            System.out.println("Introduce un número (o 'salir' para terminar):");
            System.out.print("> ");
            String entrada = teclado.nextLine().trim();

            if (entrada.equals("salir")) {
                System.out.println("Saliendo del programa");
                break;
            }

            int codigo;
            if (opcion.equals("2")) {
                codigo = lanzador.ejecutarNivel2(entrada);
            } else {
                codigo = lanzador.ejecutarNivel1(entrada);
            }

            System.out.println("Operación completada. Código de salida: " + codigo);
        }

        teclado.close();
    }
}
