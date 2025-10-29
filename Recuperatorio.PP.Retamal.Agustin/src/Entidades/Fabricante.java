package Entidades;

public class Fabricante {

    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public int getAntiguedad() {
        return this.antiguedad;
    }

    
    public static boolean sonIguales(Fabricante fabricante1, Fabricante fabricante2) {
        if (fabricante1 == fabricante2) {
            return true;
        }
        return (fabricante1.getNombre().equals(fabricante2.getNombre())
                && fabricante1.getCiudad().equals(fabricante2.getCiudad())
                && fabricante1.getAntiguedad() == fabricante2.getAntiguedad());
    }
    
    public String getInfoFabricante() {
        StringBuilder sb = new StringBuilder("Nombre: ");
        sb.append(this.getNombre());
        sb.append(". Ciudad: ");
        sb.append(this.getCiudad());
        sb.append(". Antiguedad: ");
        sb.append(this.getAntiguedad());
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Fabricante: ");
        sb.append(this.getNombre());
        sb.append(". Ciudad del fabricante: ");
        sb.append(this.getCiudad());
        sb.append(". Antiguedad: ");
        sb.append(this.getAntiguedad());
        return sb.toString();
    }
}
