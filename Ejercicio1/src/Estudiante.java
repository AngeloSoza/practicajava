import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes deseas registrar?: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Estudiante[] estudiantes = new Estudiante[n];

        // Registro de estudiantes
        for (int i = 0; i < n; i++) {
            System.out.println("\nEstudiante #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            System.out.print("Cantidad de notas: ");
            int m = sc.nextInt();
            double[] notas = new double[m];

            for (int j = 0; j < m; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[j] = sc.nextDouble();
            }
            sc.nextLine(); // limpiar buffer

            estudiantes[i] = new Estudiante(nombre, edad, notas);
        }

        // Mostrar estudiantes con promedio mayor a 8.0
        System.out.println("\n--- Estudiantes con promedio mayor a 8.0 ---");
        for (Estudiante e : estudiantes) {
            if (e.calcularPromedio() > 8.0) {
                e.mostrarDatos();
            }
        }
    }
}
