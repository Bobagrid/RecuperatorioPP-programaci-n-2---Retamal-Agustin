package Entidades;

import java.util.*;

public class Pizzeria implements Iterator<Producto> {

    private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;
    private int indice;

    public Pizzeria(String nombre) {
        this(nombre, 3);
    }

    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<Producto>(capacidad);
        this.indice = 0;
    }

    private boolean sonIguales(Producto producto) {
        return productos.contains(producto);
    }

    public void agregar(Producto producto) {
        if (this.hasNext()) {
            if (!this.productos.contains(producto)) {
                productos.add(producto);
                System.out.println("Producto agregado correctamente.");
            } else {
                System.out.println("No se puede agregar un producto ya existente.");
            }
        } else {
            System.out.println("No se pudo agregar el producto ya que no hay espacio suficiente.");
        }
    }

    private double getPrecioProductos(TipoProducto tipo) {
        double precioTotal = 0;
        switch (tipo) {
            case PIZZA:
                precioTotal += this.getPrecioDePizzas();
                break;
            case POSTRE:
                precioTotal += this.getPrecioDePostres();
                break;
            case TODOS:
                precioTotal += this.getPrecioTotal();
                break;
        }
        return precioTotal;
    }

    private double getPrecioDePizzas() {
        double precioTotal = 0;
        for (Producto p : this.productos) {
            if (p instanceof Pizza) {
                precioTotal += p.getPrecioTotal();
            }
        }
        return precioTotal;
    }

    private double getPrecioDePostres() {
        double precioTotal = 0;
        for (Producto p : this.productos) {
            if (p instanceof Postre) {
                precioTotal += p.getPrecioTotal();
            }
        }
        return precioTotal;
    }

    private double getPrecioTotal() {
        return (this.getPrecioDePizzas() + this.getPrecioDePostres());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pizzeria ");
        sb.append(this.nombre);
        sb.append(". Capacidad: ");
        sb.append(this.capacidad);
        sb.append(". Cantidad de productos: ");
        sb.append(this.productos.size());
        sb.append("\n Productos: ");

        for (Producto p : this.productos) {
            sb.append(p.toString());
            sb.append("\n");
        }

        sb.append("Precio total de todas nuestras Pizzas: $");
        sb.append(this.getPrecioDePizzas());
        sb.append("\n Precio total de todos nuestros postres: $");
        sb.append(this.getPrecioDePostres());
        return sb.toString();
    }

    @Override
    public boolean hasNext() {
        return this.indice < productos.size();
    }

    @Override
    public Producto next() {
        Producto p = productos.get(this.indice);
        this.indice++;
        return p;
    }
}
