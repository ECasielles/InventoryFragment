package com.example.usuario.inventoryfragment.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Clase POJO que representa la entidad dependencia
 *
 * @author Enrique Casielles
 * @version 2.0
 * @see java.lang.Comparable
 */
public class Dependency implements Comparable, Parcelable {
    private int _ID;
    private String name;
    private String shortname;
    private String description;
    public static String TAG = "Dependency";

    public Dependency(int _ID, String name, String shortname, String description) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
    }

    //CREATOR DEL PARCELABLE
    protected Dependency(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
    }

    public static final Creator<Dependency> CREATOR = new Creator<Dependency>() {
        @Override
        public Dependency createFromParcel(Parcel in) {
            return new Dependency(in);
        }

        @Override
        public Dependency[] newArray(int size) {
            return new Dependency[size];
        }
    };

    public int get_ID() {
        return _ID;
    }
    public void set_ID(int _ID) {
        this._ID = _ID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShortname() {
        return shortname;
    }
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return shortname;
    }

    @Override
    public boolean equals(Object obj) {
        Dependency dependency = (Dependency) obj;
        boolean result = true;

        if (!name.equals(dependency.getName()))
            result = false;
        else if (!shortname.equals(dependency.getShortname()))
            result = false;

        return result;
    }

    /**
     * Implementando la interfaz Comparable.
     * @param o
     * @return Valor menor/mayor que 0 si es anterior/posterior,
     * e igual a 0 si son iguales
     */
    @Override
    public int compareTo(@NonNull Object o) {
        return name.compareTo(((Dependency)o).name);
    }

    //IMPLEMENTANDO PARCELABLE
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_ID);
        parcel.writeString(name);
        parcel.writeString(shortname);
        parcel.writeString(description);
    }


    /**
     * Clase interna de Dependency que ordena la lista de dependencias
     * por nombre corto.
     *
     * @author Enrique Casielles Lapeira
     * @version 1.0
     * @see java.util.Comparator
     */
    public static class DependencyOrderByShortName implements Comparator<Dependency> {
        /**
         * El ArrayList se ordena según el/los criterio/s
         * del método compartido de la interfaz Comparable
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getShortname().compareTo(o2.getShortname());
        }
    }
    /**
     * Clase interna de Dependency que ordena la lista de dependencias
     * por nombre.
     *
     * @author Enrique Casielles Lapeira
     * @version 1.0
     * @see java.util.Comparator
     */
    public static class DependencyOrderByName implements Comparator<Dependency> {
        /**
         * El ArrayList se ordena según el/los criterio/s
         * del método compartido de la interfaz Comparable
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    /**
     * Clase interna de Dependency que ordena la lista de dependencias
     * por ID.
     *
     * @author Enrique Casielles Lapeira
     * @version 1.0
     * @see java.util.Comparator
     */
    public static class DependencyOrderById implements Comparator<Dependency> {
        /**
         * El ArrayList se ordena según el/los criterio/s
         * del método compartido de la interfaz Comparable
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Dependency o1, Dependency o2) {
            //Devuelve positivo si el objeto es mayor que el argumento
            return o1.get_ID() - o2.get_ID() ;
        }
    }

}
