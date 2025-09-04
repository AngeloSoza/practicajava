class Cadena {
    private String texto;

    public Cadena(String texto) {
        this.texto = texto;
    }

    public String convertirMayusculas() {
        return texto.toUpperCase();
    }

    public String convertirMinusculas() {
        return texto.toLowerCase();
    }

    public String invertirCadena() {
        return new StringBuilder(texto).reverse().toString();
    }

    public boolean esPalindromo() {
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        String invertido = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }

    public void contarVocalesConsonantes() {
        int vocales = 0, consonantes = 0;
        String limpio = texto.toLowerCase();

        for (char c : limpio.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vocales++;
                } else {
                    consonantes++;
                }
            }
        }

        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);
    }
}

public class ejercicio10 {
    public static void main(String[] args) {
        Cadena c = new Cadena("Anita lava la tina");

        System.out.println("Original: " + c);
        System.out.println("Mayúsculas: " + c.convertirMayusculas());
        System.out.println("Minúsculas: " + c.convertirMinusculas());
        System.out.println("Invertida: " + c.invertirCadena());
        System.out.println("¿Es palíndromo? " + (c.esPalindromo() ? "Sí" : "No"));
        c.contarVocalesConsonantes();
    }
}
