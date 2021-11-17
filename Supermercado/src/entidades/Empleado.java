package entidades;

import java.util.ArrayList;

import utils.Datos;

/**
 *
 * @author luis
 */
public class Empleado {

    protected int identificador;
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected String email;

    public Empleado() {
    }

    public Empleado(int identificador, String nombre, String direccion, String telefono, String email) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Empleado(Empleado e) {
        this.identificador = e.identificador;
        this.nombre = e.nombre;
        this.direccion = e.direccion;
        this.telefono = e.telefono;
        this.email = e.email;
    }

    protected int getIdentificador() {
        return identificador;
    }

    protected void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    protected String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected String getDireccion() {
        return direccion;
    }

    protected void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    protected String getTelefono() {
        return telefono;
    }

    protected void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    /**
     * Funcion que convierte un array de Empleados en un ArrayList<Empleado> a
     * través del método de la clase genérica Gen
     *
     * @param array de Empleados
     * @return ArrayList<Empleado>
     */
    public static ArrayList<Empleado> convertir(Empleado[] array) {
        return new Gen<Empleado>().convertir(array);

    }

    /**
     * Función que se le pasa una lista ArrayList<Empleado> y un array de
     * identificadores, y devuelve una sublista con los Empleados cuyos codigos
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Empleados en los que buscar
     * @param ids array de identificadores de Empleados
     * @return ArrayList<Empleado>
     */
    public static ArrayList<Empleado> arrayde(ArrayList<Empleado> lista, int[] ids) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                //el método getIdentificador() es propio de Empleado
                if (lista.get(j).getIdentificador() == ids[i]) {
                    ret.add((Empleado) lista.get(ids[i]));
                    break;
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Empleado{" + "identificador=" + identificador + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }

    /**
     * Ejercicio 7.	(Máx: 1pto.) Implementar un código para buscar un Empleado por su
     * nombre. Se pide al usuario que introduzca una cadena de caracteres de al
     * menos 3 caracteres y se buscará en la lista de empleados existentes,
     * mostrando los datos de cada empleado cuyo nombre contenga esa cadena.
     */
     /**
     * *
     * Funcion que busca un Empleado por su nombre
     *
     * @param nombre del Empleado
     * @return el Empleado con ese nombre o null ni no lo encuentra
     */
    protected static Empleado buscarByNombre(String nombre) {
        for (Empleado a : Datos.EMPLEADOS) {
            if (a.getNombre().equals(nombre)) {
                return a;
            }
        }
        return null;
    }
    
}
