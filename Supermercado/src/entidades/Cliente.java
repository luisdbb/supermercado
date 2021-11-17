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
public class Cliente {

    private int nCliente;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;

    /**
     * *
     * Ejercicio 3.	(Máx: 1pto.) Modificar la clase Cliente para que pueda
     * gestionarse toda la siguiente información:      *
     * “Me llamo JuanCa Bobón y vivo en Avenida Real 50 de Madriz, tengo 80 años
     * y mi profesión es Amodecasa. Para contactar conmigo, llamar al teléfono
     * 915512345 o escribir un email a juanqui_spain@gmail.com. Mi modo de pago
     * preferido es por tarjeta (‘T’) y sí deseo subscribirme al boletín de
     * noticias.”      *
     * Realizar los cambios necesarios (constructor/es, getters/setters, etc.)
     * en la clase Cliente sin modificar la información ya existente.
     *
     */
    private int edad;
    private String profesion;
    private char tipoPago;
    private boolean suscripcion = false;
    
    /**
     * Ejercicio 9. Cliente.saldo
     */

    private double saldo=0.0;
    
    public Cliente(int nCliente, String nombre, String direccion, String email, String telefono, int edad, String profesion, char tipoPago) {
        this.nCliente = nCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.profesion = profesion;
        this.tipoPago = tipoPago;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public char getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(char tipoPago) {
        this.tipoPago = tipoPago;
    }

    public boolean isSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(boolean suscripcion) {
        this.suscripcion = suscripcion;
    }

    
    
    
    
    
    public Cliente() {
    }

    public Cliente(int nCliente, String nombre, String direccion, String email, String telefono) {
        this.nCliente = nCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    public int getnCliente() {
        return nCliente;
    }

    public void setnCliente(int nCliente) {
        this.nCliente = nCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    
    /**
     * Funcion que convierte un array de Clientes en un ArrayList<Cliente> a
     * través del método de la clase genérica Gen
     *
     * @param array de Clientes
     * @return ArrayList<Cliente>
     */
    public static ArrayList<Cliente> convertir(Cliente[] array) {
        return new Gen<Cliente>().convertir(array);
    }

    /**
     * Función que se le pasa una lista ArrayList<Cliente> y un array de
     * identificadores, y devuelve una sublista con los Clientes cuyos codigos
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Clientes en los que buscar
     * @param ids array de números enteros de Clientes
     * @return ArrayList<Cliente>
     */
    public static ArrayList<Cliente> arrayde(ArrayList<Cliente> lista, int[] ids) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getnCliente() es propio de Cliente
                if (lista.get(j).getnCliente() == ids[i]) {
                    ret.add((Cliente) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nCliente=" + nCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + '}';
    }

    public Pedido realizarPedido() {
        Pedido p = new Pedido();
        p.setCliente(this);
        p = Pedido.nuevoPedido();

        return p;
    }

    public static void aplicarDescuento(Descuento d, Pedido p) {
        if (Descuento.getDescuentoById(d.getIdentificador()) == null) {
            System.out.println("El descuento no es válido.");
            return;
        }
        if (d.getCliente().getnCliente() != p.getCliente().getnCliente()) {
            System.out.println("El descuento no es para usted.");
            return;
        }
        if (d.getFechaValidez().before(Date.valueOf(LocalDate.now()))) {
            System.out.println("El descuento está caducado.");
            return;
        }
        //Miramos si hay algun producto promocionado en el pedido
        for (int j = 0; j < d.getProductos().size(); j++) {
            int idProdPromocionado = d.getProductos().get(j).getCodigo();
            for (int i = 0; i < p.getLineas().size(); i++) {
                LineaPedido lp = p.getLineas().get(i);
                if (lp.getProducto().getCodigo() == idProdPromocionado) {
                    //si coincide, es que el producto del descuento está en alguna línea del pedido
                    lp.setPrecioCobro(lp.getProducto().getPrecio() * 0.9); //aplicamos un 10%
                    break;
                }
            }
        }
        //actualizamos el precio total del pedido
        double nuevoCoste = 0.0;
        for (int k = 0; k < p.getLineas().size(); k++) {
            nuevoCoste += p.getLineas().get(k).getPrecioCobro() * p.getLineas().get(k).getCantidad();
        }
        p.setCosteTotal(nuevoCoste);
        return;
    }
    
    
    /***
     * Ejercicio 9.
     * CU: Realizar Pago
Precondiciones: el cliente que realiza el pago ha de estar registrado en el sistema.
Postcondiciones: se registra un nuevo pago en el sistema y se actualiza el saldo del cliente.
Pasos:
1.	El cliente introduce el importe del pago en euros y el tipo de pago (‘E’/’T’/’B’)
2.	El sistema comprueba que el importe es positivo y el tipo de pago válido. 
3.	El sistema crea un nuevo Pago con el importe, el tipo y la fecha del momento. Además: 
a.	si el pago es en el momento de compra se establece el campo Pago.pedido
4.	El sistema actualiza el saldo del cliente, incrementando su valor con la cantidad pagada.
5.	Se notifica al cliente mediante un mensaje que el pago ha sido correcto.	
Excepciones:
2.	El importe o el tipo de pago no es válido. Se muestra mensaje al cliente con las opciones 
*         de valores válidos y éste debe volver a introducirlos. 
     */

    public void realizarPago(double importe, char tipo, Pedido p) {
        Scanner in = new Scanner(System.in);
        if (importe < 0) {
            System.out.println("El importe del pago no es correcto.");
            return;
        }
        if (tipo != 'B' && tipo != 'E' && tipo != 'T') {
            System.out.println("El importe del pago no es correcto.");
            return;
        }
        Pago nuevo = new Pago();
        nuevo.setIdentificador(Datos.numPagos);
        nuevo.setFecha(Date.valueOf(LocalDate.now()));
        nuevo.setImporte(importe);
        nuevo.setTipo(tipo);

        switch (tipo) {
            case 'B':
                System.out.println("Introduzca el banco del pago por transferencia:");
                String banco = in.nextLine();
                System.out.println("Introduzca la cuenta para el pago por transferencia:");
                String cuenta = in.nextLine();
                PTransferencia nuevoPB = new PTransferencia(nuevo, cuenta, banco);
                if (p != null) {
                    p.setPago(nuevoPB);
                }
                this.setSaldo(saldo + importe);
                break;
            case 'E':
                System.out.println("Introduzca la moneda del pago en efectivo:");
                String moneda = in.nextLine();
                System.out.println("Introduzca el cambio del pago en efectivo (x.xx):");
                double cambio = in.nextDouble();
                PEfectivo nuevoPE = new PEfectivo(nuevo, moneda, cambio);
                if (p != null) {
                    p.setPago(nuevoPE);
                }
                this.setSaldo(saldo + importe);
                break;
            case 'T':
                System.out.println("Introduzca el tipo de la tarjeta para el pago por tarjeta:");
                String tipoTarjeta = in.nextLine();
                System.out.println("Introduzca el numero para el pago por tarjeta:");
                String numero = in.nextLine();
                PTarjeta nuevoPT = new PTarjeta(nuevo, numero, tipoTarjeta);
                if (p != null) {
                    p.setPago(nuevoPT);
                }
                this.setSaldo(saldo + importe);
                break;
        }
        System.out.println("El pago se ha registrado con éxito.");

    }
}
