import java.util.Scanner;

class Jugador {
    String nombre;
    char ficha; // 'X' o 'O'

    public Jugador(String nombre, char ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
    }
}

class Tablero {
    private char[][] tablero = new char[3][3];

    public Tablero() {
        // Inicializar con espacios vacíos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public boolean colocarFicha(int fila, int col, char ficha) {
        if (fila >= 0 && fila < 3 && col >= 0 && col < 3 && tablero[fila][col] == ' ') {
            tablero[fila][col] = ficha;
            return true;
        }
        return false;
    }

    public boolean verificarGanador(char ficha) {
        // Revisar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha) ||
                    (tablero[0][i] == ficha && tablero[1][i] == ficha && tablero[2][i] == ficha)) {
                return true;
            }
        }
        // Revisar diagonales
        if ((tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha) ||
                (tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha)) {
            return true;
        }
        return false;
    }

    public void mostrarTablero() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del jugador 1 (X): ");
        Jugador j1 = new Jugador(sc.nextLine(), 'X');

        System.out.print("Nombre del jugador 2 (O): ");
        Jugador j2 = new Jugador(sc.nextLine(), 'O');

        Tablero tablero = new Tablero();
        Jugador actual = j1;

        for (int turno = 0; turno < 9; turno++) {
            tablero.mostrarTablero();
            System.out.println(actual.nombre + " (" + actual.ficha + "), elige fila y columna (0-2): ");
            int fila = sc.nextInt();
            int col = sc.nextInt();

            if (!tablero.colocarFicha(fila, col, actual.ficha)) {
                System.out.println("Movimiento inválido, intenta de nuevo.");
                turno--;
                continue;
            }

            if (tablero.verificarGanador(actual.ficha)) {
                tablero.mostrarTablero();
                System.out.println("¡" + actual.nombre + " ha ganado!");
                return;
            }


            actual = (actual == j1) ? j2 : j1;
        }

        tablero.mostrarTablero();
        System.out.println("¡Es un empate!");
    }
}

