package entidades;

import java.sql.Date;

/**
 *
 * @author luis
 */
public class EComercio extends Empleado {

    private Date fechaComienzo;

    public EComercio() {
        super();
    }

    public EComercio(int identificador, String nombre, String direccion, String telefono, String email, Date fechaComienzo) {
        super(identificador, nombre, direccion, telefono, email);
        this.fechaComienzo = fechaComienzo;
    }

    public EComercio(Empleado e, Date fechaComienzo) {
        super(e);
        this.fechaComienzo = fechaComienzo;
    }

    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    @Override
    public String toString() {
        return "EComercio{ " + super.toString() + ", fechaComienzo=" + fechaComienzo + '}';
    }

}
