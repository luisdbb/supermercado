package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entidades.*;

/**
 *
 * @author luis
 */
public class Datos {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
    /**
     * public Cliente(int nCliente, String nombre, String direccion, String
     * email, String telefono)
     */
    public static final Cliente CLIENTES[] = {
        new Cliente(1, "Luis", "Gijon", "luis@educantabria.es", "942779900"),
        new Cliente(2, "Ana", "Madrid", "ana@gmail.com", "912331188"),
        new Cliente(3, "Bruno", "Barcelona", "brunob@hotmail.es", "932432245"),
        new Cliente(4, "Carla", "Santander", "carla@outlook.com", "975073211"),
        new Cliente(5, "Ramona", "Valencia", "ramonnaval@gmail.com", "942779900")
    };
    public static final int numClientes = CLIENTES.length;

    /**
     * public Almacen(int identificador, String nombre, int capacidad)
     */
    public static final Almacen ALMACENES[] = {
        new Almacen(1, "Sotano", 100),
        new Almacen(2, "Piso2", 50),
        new Almacen(3, "Poligono", 250)
    };
    public static final int numAlmacenes = ALMACENES.length;

    /**
     * public Producto(int codigo, String nombre, double precio, int
     * existencias, Almacen almacen)
     */
    public static final Producto PRODUCTOS[] = {
        new Producto(1, "ordenador", 399.99, 4, ALMACENES[2]),
        new Producto(2, "bolsa de patatas", 3.99, 43, ALMACENES[0]),
        new Producto(3, "bote de caramelos", 2.99, 98, ALMACENES[0]),
        new Producto(4, "boligrafo", 0.99, 125, ALMACENES[1]),
        new Producto(5, "leche", 0.59, 78, ALMACENES[0]),
        new Producto(6, "consola", 99.99, 3, ALMACENES[2]),
        new Producto(7, "papel higienico", 1.45, 22, ALMACENES[2]),
        new Producto(8, "garrafa agua 5L", 2.30, 34, ALMACENES[2]),
        new Producto(9, "tableta chocolate", 1.25, 10, ALMACENES[0])
    };
    public static final int numProductos = PRODUCTOS.length;

    /**
     * public Descuento(int identificador, Date fechaValidez, Cliente cliente,
     * ArrayList<Producto> productos) {
     */
    public static final Descuento DESCUENTOS[] = {
        new Descuento(1, Date.valueOf(LocalDate.parse("31/12/2017", dateFormatter)), CLIENTES[2], Producto.arrayde(Producto.convertir(PRODUCTOS), new int[]{0, 5})),
        new Descuento(2, Date.valueOf(LocalDate.parse("31/12/2017", dateFormatter)), CLIENTES[3], Producto.arrayde(Producto.convertir(PRODUCTOS), new int[]{3})),
        new Descuento(3, Date.valueOf(LocalDate.parse("31/12/2017", dateFormatter)), CLIENTES[0], Producto.arrayde(Producto.convertir(PRODUCTOS), new int[]{1, 4, 7, 8}))
    };
    public static final int numDescuentos = DESCUENTOS.length;

    /**
     * public Empleado(int identificador, String nombre, String direccion, String telefono, String email) 
     * public EComercio(int identificador, String nombre, String direccion, String telefono, String email, Date fechaComienzo) 
     * public EComercio(Empleado e, Date fechaComienzo) 
     * public Transportista(int identificador, String nombre, String direccion, String telefono, String email, String vehiculo) 
     * public Transportista(Empleado e, String vehiculo)
     * public Transportista(int identificador, String nombre, String direccion, String telefono, String email, String vehiculo, ArrayList<Almacen> almacenes)
     */
    public static final Empleado EMPLEADOS[] = {
        new EComercio(1, "Raquel", "Castro Urdiales", "942653309", "raqcastro86@gmail.com", Date.valueOf(LocalDate.parse("20/08/2013", dateFormatter))),
        new EComercio(2, "Marcos", "Castro Urdiales", "942321124", "mzorth@gmail.com", Date.valueOf(LocalDate.parse("08/09/2018", dateFormatter))),
        new EComercio(3, "Laura", "Samano", "942630083", "lausamano99@gmail.com", Date.valueOf(LocalDate.parse("10/06/2019", dateFormatter))),
        new EComercio(4, "Rocio", "Laredo", "942125124", "roci222@hotmail.com", Date.valueOf(LocalDate.parse("02/01/2015", dateFormatter))),
        new EComercio(5, "Juan", "Santander", "683319233", "jsantanderperez@gmail.com", Date.valueOf(LocalDate.parse("28/04/2012", dateFormatter))),
        new EComercio(6, "Veronica", "Bilbao", "623246233", "vergarciarodriguez@gmail.com", Date.valueOf(LocalDate.parse("12/11/2018", dateFormatter))),
        new EComercio(7, "Maria", "Castro Urdiales", "942628882", "marimarcastro@hotmail.es", Date.valueOf(LocalDate.parse("15/01/2019", dateFormatter))),
        new Transportista(8, "Marga", "Madrid", "642773309", "margarus87@gmail.com", "Seat Ibiza", Almacen.arrayde(Almacen.convertir(ALMACENES), new int[]{0, 1, 2})),
        new Transportista(9, "Jose", "Castro Urdiales", "672620300", "josecar2000@gmail.com", "Peugeot 307", Almacen.arrayde(Almacen.convertir(ALMACENES), new int[]{0, 2})),
        new Transportista(10, "Simon", "Torrelavega", "942871993", "simonkantabria@hotmail.com", "Audi A2", Almacen.arrayde(Almacen.convertir(ALMACENES), new int[]{0, 2})),
        new Transportista(11, "Sergio", "Sevilla", "924567188", "sergisev1985@gmail.com", "Renault Berlingo", Almacen.arrayde(Almacen.convertir(ALMACENES), new int[]{2}))
    };
    public static final int numEmpleados = EMPLEADOS.length;

    /**
     * public LineaPedido(long idetificador, int cantidad, double precioCobro,
     * int impuesto, Producto producto, EComercio empleado)
     */
    public static final LineaPedido LINEAS[] = {
        new LineaPedido(1, 1, 399.99, 16, PRODUCTOS[0], (EComercio) EMPLEADOS[4]),
        new LineaPedido(2, 1, 3.99, 16, PRODUCTOS[1], (EComercio) EMPLEADOS[0]),
        new LineaPedido(3, 1, 2.99, 16, PRODUCTOS[2], (EComercio) EMPLEADOS[5]),
        new LineaPedido(4, 3, 0.59, 16, PRODUCTOS[4], (EComercio) EMPLEADOS[2]),
        new LineaPedido(5, 2, 99.99, 24, PRODUCTOS[5], (EComercio) EMPLEADOS[4]),
        new LineaPedido(6, 2, 350.79, 16, PRODUCTOS[0], (EComercio) EMPLEADOS[4]),
        new LineaPedido(7, 50, 0.97, 16, PRODUCTOS[3], (EComercio) EMPLEADOS[2]),
        new LineaPedido(8, 1, 2.99, 16, PRODUCTOS[2], (EComercio) EMPLEADOS[3]),
        new LineaPedido(9, 16, 2.30, 16, PRODUCTOS[7], (EComercio) EMPLEADOS[1]),
        new LineaPedido(10, 20, 2.30, 16, PRODUCTOS[7], (EComercio) EMPLEADOS[1]),
        new LineaPedido(11, 10, 1.45, 16, PRODUCTOS[6], (EComercio) EMPLEADOS[0]),
        new LineaPedido(12, 1, 99.99, 16, PRODUCTOS[5], null)
    };
    public static final int numLineas = LINEAS.length;

    /**
     * public Pedido(int numPedido, Date fechaPedido, char estado, Date fechaEnvio, double costeTotal, boolean envio, Cliente cliente, Descuento descuento, Transportista transportista, ArrayList<LineaPedido> lineas, Almacen almacen) 
     */
    public static final Pedido PEDIDOS[] = {
        new Pedido(1, Date.valueOf(LocalDate.parse("12/10/2017", dateFormatter)), 'R', Date.valueOf(LocalDate.parse("13/10/2017", dateFormatter)), 463.99, false, CLIENTES[0], null, (Transportista) EMPLEADOS[7], LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{0}), ALMACENES[0]),
        new Pedido(2, Date.valueOf(LocalDate.parse("15/10/2017", dateFormatter)), 'R', Date.valueOf(LocalDate.parse("15/10/2017", dateFormatter)), 10.15, false, CLIENTES[1], null, (Transportista) EMPLEADOS[8], LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{1, 2, 3}), ALMACENES[0]),
        new Pedido(3, Date.valueOf(LocalDate.parse("20/10/2017", dateFormatter)), 'R', Date.valueOf(LocalDate.parse("22/10/2017", dateFormatter)), 247.98, true, CLIENTES[2], null, (Transportista) EMPLEADOS[7], LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{4}), ALMACENES[2]),
        new Pedido(4, Date.valueOf(LocalDate.parse("01/11/2017", dateFormatter)), 'R', Date.valueOf(LocalDate.parse("02/10/2017", dateFormatter)), 813.83, true, CLIENTES[2], DESCUENTOS[0], (Transportista) EMPLEADOS[9], LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{5}), ALMACENES[0]),
        new Pedido(5, Date.valueOf(LocalDate.parse("12/11/2017", dateFormatter)), 'R', Date.valueOf(LocalDate.parse("12/11/2017", dateFormatter)), 59.73, false, CLIENTES[3], DESCUENTOS[1], (Transportista) EMPLEADOS[10], LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{6, 7}), ALMACENES[2]),
        new Pedido(6, Date.valueOf(LocalDate.parse("26/11/2017", dateFormatter)), 'R', Date.valueOf(LocalDate.parse("26/11/2017", dateFormatter)), 39.74, false, CLIENTES[0], null, (Transportista) EMPLEADOS[8], LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{8}), ALMACENES[2]),
        new Pedido(7, Date.valueOf(LocalDate.parse("07/12/2017", dateFormatter)), 'R', Date.valueOf(LocalDate.parse("08/12/2017", dateFormatter)), 65.34, true, CLIENTES[4], null, (Transportista) EMPLEADOS[9], LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{9, 10}), ALMACENES[2]),
        new Pedido(8, Date.valueOf(LocalDate.parse("23/12/2017", dateFormatter)), 'C', null, 123.99, true, CLIENTES[4], null, null, LineaPedido.arrayde(LineaPedido.convertir(LINEAS), new int[]{11}), null)
    };
    public static final int numPedidos = PEDIDOS.length;
    
    
    public static final Pedido PAGOS[] = {};
    public static final int numPagos = PAGOS.length;        

}
