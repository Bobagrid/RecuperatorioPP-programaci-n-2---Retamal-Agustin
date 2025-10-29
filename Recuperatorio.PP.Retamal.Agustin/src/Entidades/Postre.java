package Entidades;

import java.util.*;

public class Postre extends Producto implements IVendible {

    private TipoPostre tipoPostre;

    public Postre(String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(fabricante, nombre, precio);
        this.tipoPostre = tipoPostre;
    }

    @Override
    public double getPrecioTotal() {
        double precioFinal = this.precio;
        switch (this.tipoPostre) {
            case FLAN:
                precioFinal *= 1.1;
                break;
            case HELADO:
                precioFinal *= 1.15;
                break;
            case TIRAMISU:
                precioFinal *= 1.2;
                break;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Postre: ");
        sb.append(this.nombre);
        sb.append(". Tipo: ");
        sb.append(this.tipoPostre);
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

        Postre p = (Postre) obj;
        return (Producto.sonIguales(this, p) && this.tipoPostre == p.tipoPostre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tipoPostre, this.fabricante, this.nombre);
    }

}
