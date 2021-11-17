package entidades;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class Gen<T> {

    public T obj;

    public Gen() {
    }

    public Gen(T o) {
        obj = o;
    }

    public T get() {
        return obj;
    }

    public void set(T t) {
        this.obj = t;
    }

    public void classType() {
        System.out.println("El tipo de clase es " + obj.getClass().getName());
    }

    public final ArrayList<T> convertir(T[] array) {
        ArrayList<T> ret = new ArrayList<T>();
        for (T t : array) {
            ret.add((T) t);
        }
        return ret;
    }

}
