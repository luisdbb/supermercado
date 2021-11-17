package principal;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.*;
import utils.Datos;

public class Supermercado {

    public static void main(String[] args) {
        System.out.println("INICIO MAIN");
        Scanner in = new Scanner(System.in);

        Cliente c1;
        Cliente c2 = new Cliente();

        //public Cliente(int nCliente, String nombre, String direccion, String email, String telefono) 
        Cliente c3 = new Cliente(101, "Max", "Alemania", "maxberlin83@gmail.de", "0049537114422");

        Cliente[] clientes = Datos.CLIENTES;
        int numClientes = clientes.length;
        //clientes[numClientes]= c3;

        for (int i = 0; i < clientes.length; i++) {
            clientes[i].toString();
        }

        double importe = 0.0;
        do {
            System.out.println("Introduzca un importe y le mostramos todos los prodcutos que podría adquirir:");
            importe = in.nextDouble();

            if (importe <= 0.0) {
                System.out.println("Valor no válido! Introduzca el importe en el formato x.xx");
            }
        } while (importe <= 0.0);
        for (int i = 0; i < Datos.numProductos; i++) {
            Producto p = Datos.PRODUCTOS[i];
            if (p.getPrecio() <= importe) {
                System.out.println("Usted puede comprar: " + p.getNombre() + "(" + p.getPrecio() + "euros).");
            }
        }

        //Realizar un pedido
        Pedido pedidoC3 = c3.realizarPedido();

        /**
         *
         * Ejercicio2.	(Máx: 0,75ptos.) En la función principal, definir una
         * variable de tipo colección de objetos Almacen que inicialmente
         * contenga los 3 almacenes ya existentes en el sistema. Luego, pedir al
         * usuario que introduzca varios nuevos almacenes (al menos uno) que se
         * irán añadiendo a esa colección. Cuando el usuario termine de
         * introducir almacenes, el programa principal mostrará de uno en uno
         * los datos de cada objeto Almacen de la colección.
         *
         */
        ArrayList<Almacen> almacenes = Almacen.convertir(Datos.ALMACENES);
        for (int i = 0; i < 3; i++) {
            System.out.println("Introduzca un nuevo almacen:");
            almacenes.add(Almacen.nuevoAlmacen());
        }
        System.out.println("Los almacenes guardados en el programa son:");
        for (Almacen a : almacenes) {
            System.out.println("Datos de almacen:" + a);
        }

        /**
         * *
         * Ejercicio 6.	(Máx: 1pto.) En la función principal, implementar un
         * código para que se muestre el nombre, el código y las existencias de
         * cada producto que se almacena en el “Polígono”.
         */
        Almacen poligono = Almacen.buscarByNombre("Poligono");
        if (poligono != null) {
            System.out.println("Los productos del almacen \"Poligono\" son:");
            for (int cont = 0; cont < Datos.numProductos; cont++) {
                Producto p = Datos.PRODUCTOS[cont];
                if (p.getAlmacen().equals(poligono)) {
                    System.out.println(p);
                }
            }

        }

        System.out.println("FIN MAIN");
    }

    public ArrayList<Producto> precioMenorQue(double precio) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        for (int i = 0; i < Datos.numProductos; i++) {
            double precioProducto = Datos.PRODUCTOS[i].getPrecio();
            if (precioProducto < precio) {
                productos.add(Datos.PRODUCTOS[i]);
            }
        }
        return productos;
    }

    /**
     * *
     *
     * 4.	(Máx: 1,5pto.) Implementar un método que, dado un Producto, devuelva
     * una lista de Clientes que hayan pedido ese Producto alguna vez. EXTRA:
     * +0,5 si la lista devuelta no tiene duplicados de Clientes.
     *
     *
     * @param p Producto para buscar
     * @return clientes que pidieron el Producto p alguna vez.
     */
    public ArrayList<Cliente> clientesPidieron(Producto p) {
        ArrayList<Cliente> ret = new ArrayList<Cliente>();
        int contLP = 0; //contador para recorrer las lineas de pedidos
        //Recorremos todos los clientes
        for (int i = 0; i < Datos.numClientes; i++) {
            Cliente c = Datos.CLIENTES[i];
            for (int j = contLP; j < Datos.numLineas; j++) {
                contLP++;
                LineaPedido lp = Datos.LINEAS[j];
                if (lp.getProducto().equals(p)) {
                    //Hay alguna linea que contiene el producto
                    if (lp.idPedido().getCliente().equals(c)) {
                        //El pedido pertenece al cliente sobre el que iteramos
                        if (!ret.contains(c)) //para evitar duplicados
                        {
                            ret.add(c);
                        }
                        break;
                    }
                }
            }
        }
        return ret;
    }

    /**
     * *
     *
     * Ejercicio 5.	(Máx: 1pto.) Implementar un método que devuelva la lista de
     * Productos a los que se les ha aplicado algún descuento alguna vez. EXTRA:
     * +0,5 si la lista devuelta no tiene duplicados de Productos. *
     *
     * @return lista de productos promocionados alguna vez
     */
    public ArrayList<Producto> productosPromocionadosAlgunaVez() {
        ArrayList<Producto> ret = new ArrayList<Producto>();
        for (int j = 0; j < Datos.numDescuentos; j++) {
            Descuento d = Datos.DESCUENTOS[j];
            for (int k = 0; k < d.getProductos().size(); k++) {
                if (!ret.contains(d.getProductos().get(k))) {
                    ret.add(d.getProductos().get(k));
                }
            }
        }
        return ret;
    }

}
