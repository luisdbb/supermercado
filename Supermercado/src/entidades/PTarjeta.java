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
public class PTarjeta extends Pago {

    private String numero;
    private String tipoTarjeta;

    public PTarjeta() {
    }

    public PTarjeta(Pago p, String numero, String tipoTarjeta ) {
        super(p);
        this.numero = numero;
        this.tipoTarjeta = tipoTarjeta;
    }

    public PTarjeta(int identificador, char tipo, double importe, Date fecha,  String numero, String tipoTarjeta) {
        super(identificador, tipo, importe, fecha);
        this.numero = numero;
        this.tipoTarjeta = tipoTarjeta;
    }


    
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Si lo llamamos PTarjeta.tipoTarjeta tendremos un problema con
     * Pago.tipoTarjeta porque son campos diferentes, de clases distintas, de
     * diferente tipoTarjeta, pero con el mismo nombre La solución es renombrar
     * el campo, por ejemplo String PTarjeta.tipoTarjeta
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

}
