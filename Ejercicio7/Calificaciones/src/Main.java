/*
7. Sistema de Calificaciones
Objetivo: Clase Curso que tiene un nombre y una matriz de notas (estudiantes x evaluaciones).
        •    Método para promedio por estudiante.
•    Método para promedio por evaluación.
•    Estudiante con mejor rendimiento.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nombre del curso
        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = sc.nextLine();

        // Número de estudiantes
        System.out.print("Ingrese el número de estudiantes: ");
        int numEstudiantes = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Estudiante[] estudiantes = new Estudiante[numEstudiantes];

        // Registrar nombres de estudiantes
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            String nombreEst = sc.nextLine();
            estudiantes[i] = new Estudiante(nombreEst);
        }

        // Número de evaluaciones
        System.out.print("Ingrese el número de evaluaciones: ");
        int numEvaluaciones = sc.nextInt();

        double[][] notas = new double[numEstudiantes][numEvaluaciones];

        // Ingreso de notas
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("Ingrese las notas de " + estudiantes[i].getNombre() + ":");
            for (int j = 0; j < numEvaluaciones; j++) {
                System.out.print("  Evaluación " + (j + 1) + ": ");
                notas[i][j] = sc.nextDouble();
            }
        }

        // Crear el curso
        Curso curso = new Curso(nombreCurso, estudiantes, notas);

        // Mostrar resultados
        curso.mostrarInfo();

        sc.close();
    }
}
