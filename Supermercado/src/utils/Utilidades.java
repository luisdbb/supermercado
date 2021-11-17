package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Utilidades {
	/**
     * Función que pide al usuario que introduce un valor para una fecha a
     * partir de 3 enteros para el día, mes y año respectivamente. Si los
     * valores introducidos no producen una fecha correcta, avisa al usuario y
     * le pide que los introduzca de nuevo. Si no lo consigue, devolverá null
     *
     * @return una fecha de la clase java.sql.Date o null si hay error
     */
    public static java.sql.Date leerFecha() {
        Date ret = null;
        int dia, mes, anio;
        boolean correcto = false;
        Scanner in;
        do {
            System.out.println("Introduzca un valor para el día (1...31)");
            in = new Scanner(System.in, "ISO-8859-1");
            dia = in.nextInt();
            System.out.println("Introduzca un valor para el mes (1...12)");
            in = new Scanner(System.in, "ISO-8859-1");
            mes = in.nextInt();
            System.out.println("Introduzca un valor para el año");
            in = new Scanner(System.in, "ISO-8859-1");
            anio = in.nextInt();

            try {
                ret = Date.valueOf(LocalDate.of(anio, mes, dia));
                correcto = true;
            } catch (Exception e) {
                System.out.println("Fecha introducida incorrecta.");
                correcto = false;
            }
        } while (!correcto);
        return ret;
    }
}
