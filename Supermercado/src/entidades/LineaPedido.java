package entidades;

import java.util.ArrayList;

import utils.Datos;

/**
 *
 * @author luis
 */
public class LineaPedido {

    private long identificador;
    private int cantidad;
    private double precioCobro;
    private int impuesto;
    private Producto producto; //relación ·"forma parte de" entre LineaPedido y Producto
    private EComercio empleado; //relación "prepara" entre LineaPedido y EComercio

    public LineaPedido() {
    }

    /*
    public LineaPedido(long idetificador, int cantidad, double precioCobro, int impuesto) {
        this.idetificador = idetificador;
        this.cantidad = cantidad;
        this.precioCobro = precioCobro;
        this.impuesto = impuesto;
    }
     */
    public LineaPedido(long idetificador, int cantidad, double precioCobro, int impuesto, Producto producto) {
        this.identificador = idetificador;
        this.cantidad = cantidad;
        this.precioCobro = precioCobro;
        this.impuesto = impuesto;
        this.producto = producto;
    }

    public LineaPedido(long idetificador, int cantidad, double precioCobro, int impuesto, Producto producto, EComercio empleado) {
        this.identificador = idetificador;
        this.cantidad = cantidad;
        this.precioCobro = precioCobro;
        this.impuesto = impuesto;
        this.producto = producto;
        this.empleado = empleado;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCobro() {
        return precioCobro;
    }

    public void setPrecioCobro(double precioCobro) {
        this.precioCobro = precioCobro;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public EComercio getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EComercio empleado) {
        this.empleado = empleado;
    }

    /**
     * Función que se le pasa una lista ArrayList<LineaPedido> y un array de
     * identificadores, y devuelve una sublista con los Lineas de Pedido cuyos
     * codigos coinciden con los identificadores del array en la lista
     *
     * @param lista de Lineas de Pedido en los que buscar
     * @param ids array de identificadores de Lineas de Pedido
     * @return ArrayList<LineaPedido>
     */
    public static ArrayList<LineaPedido> arrayde(ArrayList<LineaPedido> lista, int[] ids) {
        ArrayList<LineaPedido> ret = new ArrayList<LineaPedido>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getIdentificador() es propio de LineaPedido
                if (lista.get(j).getIdentificador() == ids[i]) {
                    ret.add((LineaPedido) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * Funcion que convierte un array de LineasPedido en un
     * ArrayList<LineaPedido> a través del método de la clase genérica Gen
     *
     * @param array de LineaPedido
     * @return ArrayList<LineaPedido>
     */
    public static ArrayList<LineaPedido> convertir(LineaPedido[] array) {
        return new Gen<LineaPedido>().convertir(array);
    }
    
    /***
     * Funcion que devuelve el valor con el coste de la linea, calculado como cantidad * precioCobro * (1+ 1/impuesto)
     * @return 
     */
    public double calcularCosteLinea(){
        return this.getCantidad() * this.getPrecioCobro() * (1 + (this.getImpuesto() / 100));
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "idetificador=" + identificador + ", cantidad=" + cantidad + ", precioCobro=" + precioCobro + ", impuesto=" + impuesto + ", producto=" + producto.getNombre() + ", preparado por:" + empleado.getNombre() + '}';
    }
    
    /***
     * Funcion que devuelve el pedido al que pertenece la línea de pedido
     * @return 
     */
    public Pedido idPedido(){
        for(Pedido p: Datos.PEDIDOS){
            for(int j=0; j< p.getLineas().size(); j++)
                if(p.getLineas().get(j).equals(this))
                    return p;
        }
        return null;
    }

}
