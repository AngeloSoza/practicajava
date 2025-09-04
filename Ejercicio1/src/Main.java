import java.util.Scanner;

class Estudiante {
    private String nombre;
    private int edad;
    private double[] notas;

    // Constructor
    public Estudiante(String nombre, int edad, double[] notas) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = notas;
    }

    // Método para calcular el promedio
    public double calcularPromedio() {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    // Método para mostrar datos
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.print("Notas: ");
        for (double nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println("\nPromedio: " + calcularPromedio());
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos estudiantes deseas registrar?: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Estudiante[] estudiantes = new Estudiante[n];

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

        System.out.println("\n--- Estudiantes con promedio mayor a 8.0 ---");
        for (Estudiante e : estudiantes) {
            if (e.calcularPromedio() > 8.0) {
                e.mostrarDatos();
            }
        }
    }
}
