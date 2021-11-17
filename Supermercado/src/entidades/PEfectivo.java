/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author luis
 */
public class PEfectivo extends Pago {

    private String moneda;
    private double cambio;

    public PEfectivo(String moneda, double cambio, int identificador, char tipo, double importe, Date fecha) {
        super(identificador, tipo, importe, fecha);
        this.moneda = moneda;
        this.cambio = cambio;
    }

    public PEfectivo(Pago p, String moneda, double cambio) {
        super(p);
        this.moneda = moneda;
        this.cambio = cambio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

}
