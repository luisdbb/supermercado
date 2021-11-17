package entidades;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Datos;

/**
 *
 * @author luis
 */
public class Almacen {

    private int identificador;
    private String nombre;
    private int capacidad;
    private ArrayList<Transportista> transportistas = new ArrayList<Transportista>(); //relacion "trabajar" entre Almacen y Transportista

    public Almacen() {
    }

    public Almacen(int identificador, String nombre, int capacidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public Almacen(int identificador, String nombre, int capacidad, ArrayList<Transportista> transportistas) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.transportistas = transportistas;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Transportista> getTransportistas() {
        return transportistas;
    }

    public void setTransportistas(ArrayList<Transportista> transportistas) {
        this.transportistas = transportistas;
    }

    public String transportistas() {
        String ret = " transportistas:[";
        for (Transportista t : this.transportistas) {
            ret += "" + t.getIdentificador() + "(" + t.getNombre() + "), ";
        }
        return ret + "]";
    }

    /**
     * Funcion que convierte un array de Almacenes en un ArrayList<Almacen> a
     * través del método de la clase genérica Gen
     *
     * @param array de Almacenes
     * @return ArrayList<Almacen>
     */
    public static ArrayList<Almacen> convertir(Almacen[] array) {
        return new Gen<Almacen>().convertir(array);

    }

    /**
     * Función que se le pasa una lista ArrayList<Almacen> y un array de
     * identificadores, y devuelve una sublista con los Almacenes cuyos codigos
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Almacenes en los que buscar
     * @param ids array de codigos enteros de Almacenes
     * @return ArrayList<Almacen>
     */
    public static ArrayList<Almacen> arrayde(ArrayList<Almacen> lista, int[] ids) {
        ArrayList<Almacen> ret = new ArrayList<Almacen>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getIdentificador() es propio de Almacen
                if (lista.get(j).getIdentificador() == ids[i]) {
                    ret.add((Almacen) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Almacen{" + "id=" + identificador + ", nombre=" + nombre + ", capacidad=" + capacidad + "," + transportistas() + '}';
    }

    /**
     * *
     * Ejercicio1.	(Máx: 0,75ptos.) Implementar un método nuevoAlmacen que pida
     * por pantalla al usuario los datos ya existentes en la clase Almacen y
     * éste los introduzca por la entrada estándar, devolviendo un objeto
     * completo. NO pedir datos sobre los Transportistas que trabajan en el
     * nuevo Almacen que se esté creando ni tampoco sobre los Pedidos o
     * Productos que se guardarán ahí en el futuro.
     *
     * @return un nuevo Almacen
     */
    public static Almacen nuevoAlmacen() {
        Almacen ret = new Almacen();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca el nombre para el nuevo almacen:");
        ret.setNombre(in.nextLine());
        System.out.println("Introduzca la capacidad para el nuevo almacen (en metros cúbicos):");
        ret.setCapacidad(in.nextInt());
        ret.setIdentificador(Datos.numAlmacenes + 1);
        return ret;
    }

    /**
     * *
     * Funcion que busca un Almacen por su nombre
     *
     * @param nombre del Almacen
     * @return el Almacen con ese nombre o null ni no lo encuentra
     */
    public static Almacen buscarByNombre(String nombre) {
        for (Almacen a : Datos.ALMACENES) {
            if (a.getNombre().equals(nombre)) {
                return a;
            }
        }
        return null;
    }

}
