/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author luis Ejercicio 8.	(Máx: 1,5ptos.) Implementar una nueva clase Pago y
 * sus subclases PEfectivo, PTarjeta, PTransferencia, para que encaje con la
 * siguiente ampliación al diagrama de Clases:
 */
public class Pago {

    protected int identificador;
    protected char tipo;
    protected double importe;
    protected Date fecha;

    public Pago() {
    }

    public Pago(Pago p) {
        this.identificador = p.getIdentificador();
        this.tipo = p.getTipo();
        this.importe = p.getImporte();
        this.fecha = p.getFecha();
    }

    public Pago(int identificador, char tipo, double importe, Date fecha) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.importe = importe;
        this.fecha = fecha;
    }

    protected int getIdentificador() {
        return identificador;
    }

    protected void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    protected char getTipo() {
        return tipo;
    }

    protected void setTipo(char tipo) {
        this.tipo = tipo;
    }

    protected double getImporte() {
        return importe;
    }

    protected void setImporte(double importe) {
        this.importe = importe;
    }

    protected Date getFecha() {
        return fecha;
    }

    protected void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
