package run;

class Producto {
    private String nombre;
    private String codigo;
    private int cantidad;

    public Producto(String nombre, String codigo, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}

class Inventario {
    private Producto[] productos;
    private int contador;

    public Inventario(int capacidad) {
        productos = new Producto[capacidad];
        contador = 0;
    }

    // Para anadir productos
    public void agregarProducto(Producto p) {
        if (contador < productos.length) {
            productos[contador] = p;
            contador++;
        } else {
            System.out.println("Inventario lleno, no se puede agregar más productos.");
        }
    }

    //Busqueda por codigo
    public Producto buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }
        return null; // no encontrado
    }

    // Mostrar productos con stock menor a 5
    public void mostrarStockBajo() {
        System.out.println("Productos con stock menor a 5:");
        for (int i = 0; i < contador; i++) {
            if (productos[i].getCantidad() < 5) {
                System.out.println(productos[i]);
            }
        }
    }
}



