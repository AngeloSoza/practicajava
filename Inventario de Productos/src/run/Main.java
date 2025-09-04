package run;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(10);

        // Agregar productos
        inventario.agregarProducto(new Producto("Manzanas", "A001", 10));
        inventario.agregarProducto(new Producto("Peras", "A002", 3));
        inventario.agregarProducto(new Producto("Plátanos", "A003", 2));
        inventario.agregarProducto(new Producto("Naranjas", "A004", 7));

        // Buscar por código
        Producto buscado = inventario.buscarPorCodigo("A002");
        if (buscado != null) {
            System.out.println("Producto encontrado: " + buscado);
        } else {
            System.out.println("Producto no encontrado.");
        }

        // Mostrar productos con bajo stock
        inventario.mostrarStockBajo();
    }
}
