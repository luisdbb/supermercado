package entidades;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Datos;

/**
 *
 * @author luis
 */
public class Pedido {

    private int numPedido;
    private Date fechaPedido = Date.valueOf(LocalDate.now());
    private char estado = 'P';
    private Date fechaEnvio;
    private double costeTotal;
    private boolean envio = false;
    private Cliente cliente; //relacion "realizar" entre Pedido y Cliente
    private Transportista transportista; //relacion "finalizar" entre Pedido y Transportista
    private Descuento descuento; //relacion "descontar" entre Pedido y Descuento 
    private ArrayList<LineaPedido> lineas = new ArrayList<LineaPedido>(); //relacion "compuesto_de" entre Pedido y LineaPedido 
    private Almacen almacen; //relacion "guardar" entre Pedido y Almacen 
    
    private Pago pago=null;

    public Pedido() {
    }

    /*
    public Pedido(int numPedido, Date fechaPedido, char estado, Date fechaEnvio, double costeTotal, boolean envio) {
        this.numPedido = numPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.costeTotal = costeTotal;
        this.envio = envio;
    }
     */
    public Pedido(int numPedido, Date fechaPedido, char estado, Date fechaEnvio, double costeTotal, boolean envio, Cliente cliente) {
        this.numPedido = numPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.costeTotal = costeTotal;
        this.envio = envio;
        this.cliente = cliente;
    }

    public Pedido(int numPedido, Date fechaPedido, char estado, Date fechaEnvio, double costeTotal, boolean envio, Cliente cliente, Descuento descuento) {
        this.numPedido = numPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.costeTotal = costeTotal;
        this.envio = envio;
        this.cliente = cliente;
        this.descuento = descuento;
    }

    public Pedido(int numPedido, Date fechaPedido, char estado, Date fechaEnvio, double costeTotal, boolean envio, Cliente cliente, Descuento descuento, Transportista transportista) {
        this.numPedido = numPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.costeTotal = costeTotal;
        this.envio = envio;
        this.cliente = cliente;
        this.transportista = transportista;
        this.descuento = descuento;
    }

    public Pedido(int numPedido, Date fechaPedido, char estado, Date fechaEnvio, double costeTotal, boolean envio, Cliente cliente, Descuento descuento, Transportista transportista, ArrayList<LineaPedido> lineas) {
        this.numPedido = numPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.costeTotal = costeTotal;
        this.envio = envio;
        this.cliente = cliente;
        this.transportista = transportista;
        this.descuento = descuento;
        this.lineas = lineas;
    }

    public Pedido(int numPedido, Date fechaPedido, char estado, Date fechaEnvio, double costeTotal, boolean envio, Cliente cliente, Descuento descuento, Transportista transportista, ArrayList<LineaPedido> lineas, Almacen almacen) {
        this.numPedido = numPedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.costeTotal = costeTotal;
        this.envio = envio;
        this.cliente = cliente;
        this.transportista = transportista;
        this.descuento = descuento;
        this.lineas = lineas;
        this.almacen = almacen;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public boolean isEnvio() {
        return envio;
    }

    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public ArrayList<LineaPedido> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaPedido> lineas) {
        this.lineas = lineas;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

  
    
    
    /**
     * Funcion que convierte un array de Pedidos en un ArrayList<Pedido> a
     * través del método de la clase genérica Gen
     *
     * @param array de Pedidos
     * @return ArrayList<Pedido>
     */
    public static ArrayList<Pedido> convertir(Pedido[] array) {
        return new Gen<Pedido>().convertir(array);

    }

    /**
     * Función que se le pasa una lista ArrayList<Pedido> y un array de
     * identificadores, y devuelve una sublista con los Pedidos cuyos codigos
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Pedidos en los que buscar
     * @param ids array de identificadores de Pedidos
     * @return ArrayList<Pedido>
     */
    public static ArrayList<Pedido> arrayde(ArrayList<Pedido> lista, int[] ids) {
        ArrayList<Pedido> ret = new ArrayList<Pedido>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getNumPedido() es propio de Pedido
                if (lista.get(j).getNumPedido() == ids[i]) {
                    ret.add((Pedido) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numPedido=" + numPedido + ", fechaPedido=" + fechaPedido + ", estado=" + estado + ", fechaEnvio=" + fechaEnvio + ", costeTotal=" + costeTotal + ", envio=" + envio + ", cliente=" + cliente.getNombre() + " descuento=" + descuento.getIdentificador() + ", finalizado por=" + transportista.getNombre() + '}';
    }

    public static Pedido nuevoPedido() {
        Scanner in = new Scanner(System.in);
        Pedido p = new Pedido();
        char opcion = '-';

        int numPedido = Datos.numPedidos + 1;
        p.setNumPedido(numPedido);
        Date fechaPedido = Date.valueOf(LocalDate.now());
        p.setFechaPedido(fechaPedido);
        char estado = 'P';
        p.setEstado(estado);
        Date fechaEnvio = null;
        p.setFechaEnvio(fechaEnvio);
        double costeTotal = 0.0;

        int idProducto = 0;
        do {
            Producto.motrarProductos();
            in = new Scanner(System.in);
            System.out.println("Introduzca el codigo del producto:");
            idProducto = in.nextInt();
            Producto prod = Producto.getProductoById(idProducto);
            if (prod == null) {
                System.out.println("No existe el producto de codigo " + idProducto);
                continue;
            } else {
                in = new Scanner(System.in);
                System.out.println("Introduzca la cantidad de " + prod.getNombre() + " deseada (quedan " + prod.getExistencias() + " unidades):");
                int cantidad = 0;
                cantidad = in.nextInt();
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser positiva.");
                } else if (cantidad > prod.getExistencias()) {
                    System.out.println("No tenemos suficientes existencias de " + prod.getNombre() + ". Quedan solo " + prod.getExistencias() + " disponibles.");
                    continue;
                } else {
                    //La cantidad deseada es correcta -> se añade la linea al pedido.
                    prod.setExistencias(prod.getExistencias() - cantidad);
                    LineaPedido linea = new LineaPedido(p.getLineas().size() + Datos.numLineas + 1, cantidad, prod.getPrecio(), 16, prod, null);
                    p.getLineas().add(linea);
                }
            }
            
            do{
                in = new Scanner(System.in);
                System.out.println("¿Desea introducir otro producto? (S/N)");
                opcion = in.nextLine().charAt(0);
                if (opcion == 'N' || opcion == 'n')
                    break;
                else
                    if (opcion == 'S' || opcion == 's') 
                       continue;
            }while(opcion != 'N' && opcion != 'S' && opcion != 'n' && opcion != 's');    
            
        } while (opcion == 'S' || opcion == 's');
        //Se calcula el coste total del pedido
        p.calcularCosteLineasPedido();

        //Mostramos el pedido al usuario
        p.mostrarPedidoBasico();

        System.out.println("¿Desea usar algun descuento?");
        opcion = in.nextLine().charAt(0);
        if (opcion == 'S' || opcion == 's') {
            System.out.println("Introduzca el identificador del descuento:");
            int idDesc = in.nextInt();
            Descuento d = Descuento.getDescuentoById(idDesc);
            if (d != null) {
                //aplicamos el descuento
                Cliente.aplicarDescuento(d, p);
            } else {
                System.out.println("No existe el descuento con el identificador " + idDesc);

            }
            p.setDescuento(d);
            System.out.println("El coste del pedido tras el descuento es: " + p.getCosteTotal() + " euros.");
        }

        do {
            System.out.println("¿Desea que le enviemos su pedido? (S/N)");
            opcion = in.nextLine().charAt(0);
        } while (opcion != 'N' && opcion != 'S' && opcion != 'n' && opcion != 's');
        if (opcion == 'N' || opcion == 'n') {
            p.setEnvio(false);
        } else {
            p.setEnvio(true);
        }

        p.setTransportista(null);
        p.setAlmacen(Datos.ALMACENES[2]);

        return p;
    }

    /**
     * *
     * Funcion que muestra por pantalla los datos basicos del pedido, es decir,
     * sus líneas de pedido y sus costes, así como el coste total del pedido.
     * Pero no muestra otros datos como Cliente, Descuento, Almacen, etc.
     */
    public void mostrarPedidoBasico() {
        System.out.println("El pedido es:");
        for (int i = 0; i < this.lineas.size(); i++) {
            double costeLinea = this.lineas.get(i).getCantidad() * this.lineas.get(i).getPrecioCobro() * (1 + (this.lineas.get(i).getImpuesto() / 100));
            System.out.println(this.lineas.get(i).getCantidad() + " unidades de " + this.lineas.get(i).getProducto().getNombre() + " a " + this.lineas.get(i).getPrecioCobro() + " euros/unidad -> " + this.lineas.get(i).getCantidad() * this.lineas.get(i).getPrecioCobro() + "(impuesto " + this.lineas.get(i).getImpuesto() + ") =" + costeLinea);
        }
        System.out.println("El coste total del pedido es:" + this.costeTotal);
    }

    /**
     * *
     * Funcion que establece el coste Total del pedido al valor de la suma de
     * los costes de cada Linea Cada coste de linea se calcula como: cantidad *
     * precioCobro + (1+ impuesto/100)
     */
    public void calcularCosteLineasPedido() {
        double costeCalculado = 0.0;
        for (int i = 0; i < this.lineas.size(); i++) {
            double costeLinea = this.getLineas().get(i).calcularCosteLinea();
            costeCalculado += costeLinea;
        }
        this.costeTotal = costeCalculado;
    }
}
