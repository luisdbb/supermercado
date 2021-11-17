package entidades;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class Transportista extends Empleado {

    private String vehiculo;
    private ArrayList<Almacen> almacenes = new ArrayList<Almacen>(); //relacion "trabajar" entre Transportista y Almacen

    public Transportista() {
    }

    public Transportista(Empleado e, String vehiculo) {
        super(e);
        this.vehiculo = vehiculo;
    }

    public Transportista(Empleado e, String vehiculo, ArrayList<Almacen> almacenes) {
        super(e);
        this.vehiculo = vehiculo;
        this.almacenes = almacenes;
    }

    public Transportista(int identificador, String nombre, String direccion, String telefono, String email, String vehiculo) {
        super(identificador, nombre, direccion, telefono, email);
        this.vehiculo = vehiculo;
    }

    public Transportista(int identificador, String nombre, String direccion, String telefono, String email, String vehiculo, ArrayList<Almacen> almacenes) {
        super(identificador, nombre, direccion, telefono, email);
        this.vehiculo = vehiculo;
        this.almacenes = almacenes;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ArrayList<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(ArrayList<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    
    
    
    
    public String almacenes() {
        String ret = " almacenes:[";
        for (Almacen a : this.almacenes) {
            ret += "" + a.getIdentificador() + "(" + a.getNombre() + "), ";
        }
        return ret + ']';
    }

    @Override
    public String toString() {
        return "Transportista{ " + super.toString() + ", vehiculo=" + vehiculo + "," + almacenes() + '}';
    }
}
