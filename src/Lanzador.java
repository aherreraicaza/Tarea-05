import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lanzador {

    private String rutaFactor() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            return System.getenv("ProgramFiles") + "\\Git\\usr\\bin\\factor.exe";
        }
        return "factor";
    }

    public int ejecutarNivel1(String numero) {
        try {
            ProcessBuilder comando = new ProcessBuilder(rutaFactor(), numero);
            comando.inheritIO();
            Process proceso = comando.start();
            return proceso.waitFor();
        } catch (Exception e) {
            System.out.println("No se pudo ejecutar factor: " + e.getMessage());
            return 1;
        }
    }

    public int ejecutarNivel2(String numero) {
        try {
            Process proceso = new ProcessBuilder(rutaFactor(), numero).start();

            BufferedReader salida = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea = salida.readLine();
            while (linea != null) {
                System.out.println("[OK] " + linea);
                linea = salida.readLine();
            }

            BufferedReader error = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
            linea = error.readLine();
            while (linea != null) {
                System.out.println("[ERROR] " + linea);
                linea = error.readLine();
            }

            return proceso.waitFor();
        } catch (Exception e) {
            System.out.println("No se pudo ejecutar factor: " + e.getMessage());
            return 1;
        }
    }
}
