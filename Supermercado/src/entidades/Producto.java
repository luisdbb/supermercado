package entidades;

import java.util.ArrayList;

import utils.Datos;

/**
 *
 * @author luis
 */
public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int existencias;
    private Almacen almacen; //relacion "almacenar" entre Producto y Almacen

    public Producto() {
    }

    /*
    public Producto(int codigo, String nombre, double precio, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }
     */
    public Producto(int codigo, String nombre, double precio, int existencias, Almacen almacen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
        this.almacen = almacen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    /**
     * Funcion que convierte un array de Productos en un ArrayList<Producto> a
     * través del método de la clase genérica Gen
     *
     * @param array de Producto
     * @return ArrayList<Producto>
     */
    public static ArrayList<Producto> convertir(Producto[] array) {
        return new Gen<Producto>().convertir(array);
    }

    /**
     * Función que se le pasa una lista ArrayList<Producto> y un array de
     * identificadores, y devuelve una sublista con los Productos cuyos codigos
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Productos en los que buscar
     * @param ids array de codigos enteros de Productos
     * @return ArrayList<Producto>
     */
    public static ArrayList<Producto> arrayde(ArrayList<Producto> lista, int[] ids) {
        ArrayList<Producto> ret = new ArrayList<Producto>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getCodigo() es propio de Producto
                if (lista.get(j).getCodigo() == ids[i]) {
                    ret.add((Producto) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    public static void motrarProductos() {
        System.out.println("Lista de Productos disponibles:");
        for (int i = 0; i < Datos.numProductos; i++) {
            Producto p = Datos.PRODUCTOS[i];
            if (p.getExistencias() > 0) {
                System.out.println(p.toString());
            }
        }
    }
    
    public static Producto getProductoById(int id){
        for(int i=0; i< Datos.numProductos; i++){
            if(Datos.PRODUCTOS[i].getCodigo()==id)
                return Datos.PRODUCTOS[i];
        }
        return null;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", existencias=" + existencias + ", almacen=" + almacen.getNombre() + '}';
    }

}
