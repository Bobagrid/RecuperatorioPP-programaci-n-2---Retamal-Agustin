package Entidades;

import java.util.*;

public abstract class Producto implements IVendible {

    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    public Producto(Fabricante fabricante, String nombre, double precio) {
        Producto.inicializarAleatorio();
        this.fabricante = fabricante;
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = 0;
        this.getCalorias();
        this.tiempoPreparacion = 0;
        this.getTiempoPreparacion(); //Uso estos 2 get para settearle un numeroa calorias
                                    //y tiempo preparacion y que no queden en 0.
        
    }

    public Producto(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this(new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante), nombre, precio);
    }

    public static void inicializarAleatorio() {
        generadorAleatorio = new Random();
    }

    public int getCalorias() {
        if (this.calorias == 0) {
            this.calorias = generadorAleatorio.nextInt(200, 801);
        }
        return this.calorias;
    }

    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            this.calorias = generadorAleatorio.nextInt(5, 21);
        }
        return this.tiempoPreparacion;
    }
    
    private static String mostrar(Producto producto) {
        StringBuilder sb = new StringBuilder("Producto: ");
        sb.append(producto.nombre);
        sb.append(". Precio: $");
        sb.append(producto.precio);
        sb.append(". Fabricante:( ");
        sb.append(producto.fabricante.toString());
        sb.append("). \n");
        sb.append("Calorias: ");
        sb.append(producto.calorias);
        sb.append(". Tiempo de Preparacion: ");
        sb.append(producto.tiempoPreparacion);
        return sb.toString();
    }
    
    protected static boolean sonIguales(Producto producto1, Producto producto2) {
        if (producto1 == producto2) {
            return true;
        }
        return (producto1.nombre.equals(producto2.nombre) &&
                Fabricante.sonIguales(producto1.fabricante, producto2.fabricante));
    }

    @Override
    public String toString() {
       return Producto.mostrar(this);
    }
}
