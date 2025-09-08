public class Curso {
    private String nombre;
    private Estudiante[] estudiantes;
    private double[][] notas; // filas = estudiantes, columnas = evaluaciones

    public Curso(String nombre, Estudiante[] estudiantes, double[][] notas) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        this.notas = notas;
    }

    // Promedio por estudiante
    public double promedioEstudiante(int indiceEstudiante) {
        double suma = 0;
        for (int j = 0; j < notas[indiceEstudiante].length; j++) {
            suma += notas[indiceEstudiante][j];
        }
        return suma / notas[indiceEstudiante].length;
    }

    // Promedio por evaluación
    public double promedioEvaluacion(int indiceEvaluacion) {
        double suma = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            suma += notas[i][indiceEvaluacion];
        }
        return suma / estudiantes.length;
    }

    // Estudiante con mejor rendimiento
    public Estudiante mejorEstudiante() {
        int mejorIndice = 0;
        double mejorPromedio = promedioEstudiante(0);

        for (int i = 1; i < estudiantes.length; i++) {
            double promedio = promedioEstudiante(i);
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorIndice = i;
            }
        }
        return estudiantes[mejorIndice];
    }

    // Mostrar toda la información
    public void mostrarInfo() {
        System.out.println("\nCurso: " + nombre);
        System.out.println("===== Promedio por estudiante =====");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.printf("%s: %.2f%n", estudiantes[i].getNombre(), promedioEstudiante(i));
        }

        System.out.println("\n===== Promedio por evaluación =====");
        for (int j = 0; j < notas[0].length; j++) {
            System.out.printf("Evaluación %d: %.2f%n", (j + 1), promedioEvaluacion(j));
        }

        System.out.println("\nMejor estudiante: " + mejorEstudiante().getNombre());
    }
}
