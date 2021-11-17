package entidades;

import java.sql.Date;
import java.util.ArrayList;

import utils.Datos;

/**
 *
 * @author luis
 */
public class Descuento {

    private int identificador;
    private Date fechaValidez;
    private Cliente cliente; //relacion "disponer" entre Descuento y Cliente
    private ArrayList<Producto> productos = new ArrayList<Producto>(); //relacion "aplicable" entre Descuento y Producto

    public Descuento() {
    }

    /*
    public Descuento(int identificador, Date fechaValidez) {
        this.identificador = identificador;
        this.fechaValidez = fechaValidez;
    }
     */
    public Descuento(int identificador, Date fechaValidez, Cliente cliente, ArrayList<Producto> productos) {
        this.identificador = identificador;
        this.fechaValidez = fechaValidez;
        this.cliente = cliente;
        this.productos = productos;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Date getFechaValidez() {
        return fechaValidez;
    }

    public void setFechaValidez(Date fechaValidez) {
        this.fechaValidez = fechaValidez;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String productos() {
        String ret = " productos:[";
        for (Producto p : this.productos) {
            ret += "" + p.getCodigo() + "(" + p.getNombre() + "), ";
        }
        return ret + "]";
    }

    /**
     * Funcion que convierte un array de Descuentos en un ArrayList<Descuento> a
     * través del método de la clase genérica Gen
     *
     * @param array de Descuento
     * @return ArrayList<Descuento>
     */
    public static ArrayList<Descuento> convertir(Descuento[] array) {
        return new Gen<Descuento>().convertir(array);

    }

    /**
     * Función que se le pasa una lista ArrayList<Descuento> y un array de
     * identificadores, y devuelve una sublista con los Descuentos cuyos codigos
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Descuentos en los que buscar
     * @param ids array de identificadores de Descuentos
     * @return ArrayList<Descuento>
     */
    public static ArrayList<Descuento> arrayde(ArrayList<Descuento> lista, int[] ids) {
        ArrayList<Descuento> ret = new ArrayList<Descuento>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getIdentificador() es propio de Descuento
                if (lista.get(j).getIdentificador() == ids[i]) {
                    ret.add((Descuento) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }
    
    public static Descuento getDescuentoById(int id) {
        for (int i = 0; i < Datos.numDescuentos; i++) {
            if (Datos.DESCUENTOS[i].getIdentificador() == id) {
                return Datos.DESCUENTOS[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Descuento{" + "id=" + identificador + ", fechaValidez=" + fechaValidez + ", cliente=" + cliente.getNombre() + ", " + productos() + '}';
    }

}
