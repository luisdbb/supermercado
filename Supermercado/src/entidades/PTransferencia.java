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
public class PTransferencia extends Pago {

    private String cuenta;
    private String banco;

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public PTransferencia(Pago p, String cuenta, String banco) {
        super(p);
        this.cuenta = cuenta;
        this.banco = banco;
    }

    public PTransferencia(String cuenta, String banco, int identificador, char tipo, double importe, Date fecha) {
        super(identificador, tipo, importe, fecha);
        this.cuenta = cuenta;
        this.banco = banco;
    }

}
