package Entidades;

import java.util.*;

public class Pizza extends Producto implements IVendible {

    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza(String nombre,double precio, Fabricante fabricante,TipoPizza sabor, TamanoPizza tamano) {
        super(fabricante, nombre, precio);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    @Override
    public double getPrecioTotal() {
        double precioFinal = this.precio;
        switch (this.tamano) {
            case CHICA:
                precioFinal *= 1.05;
                break;
            case MEDIANA:
                precioFinal *= 1.1;
                break;
            case GRANDE:
                precioFinal *= 1.2;
                break;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pizza: ");
        sb.append(this.nombre);
        sb.append(". Sabor: ");
        sb.append(this.sabor);
        sb.append(". Tamaño: ");
        sb.append(this.tamano);
        sb.append("\n. Calorias: ");
        sb.append(this.getCalorias());
        sb.append("\n Tiempo de Preparación: ");
        sb.append(this.tiempoPreparacion);
        sb.append("\n Precio Total: $");
        sb.append(this.getPrecioTotal());
        sb.append("\n Fabricada por: ");
        sb.append(this.fabricante.toString());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }

        Pizza p = (Pizza) obj;
        return (Producto.sonIguales(this, p) && this.sabor == p.sabor &&
                this.tamano == p.tamano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sabor, this.tamano, this.fabricante, this.nombre);
        //Hice el hashCode por ser una buena practica
 //Hacer el hash compuesto de todos los atributos que definen la igualdad entre 2 pizzas fue lo que me pareció más adecuado
  //Es decir, el sabor, tamaño, nombre y fabricante.
    }
    
    
}
