package com.example.usuario.inventoryfragment.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase POJO que representa la entidad sector
 *
 * @author Enrique Casielles
 * @version 1.0
 * @see Parcelable
 */
public class Sector implements Parcelable {
    int _ID;
    String name, shortname, description;
    int dependencyId;
    boolean enabled = true;     //Habilitados por defecto
    boolean sectorDefault = true;    //Se visualiza un TextView en el sector por defecto
    public static String TAG = "Sector";

    public Sector(int ID, String name, String shortname, String description, int dependencyId, boolean enabled, boolean sectorDefault) {
        this._ID = ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this.dependencyId = dependencyId;
        this.enabled = enabled;
        this.sectorDefault = sectorDefault;
    }

    protected Sector(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
        dependencyId = in.readInt();
        enabled = in.readByte() != 0;
        sectorDefault = in.readByte() != 0;
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

    public int getID() {
        return _ID;
    }
    public void setID(int _ID) {
        this._ID = _ID;
    }
    public int getDependencyId() {
        return dependencyId;
    }
    public void setDependencyId(int _dependencyId) {
        this.dependencyId = _dependencyId;
    }
    public String getName() {
        return name;
    }
    public void setName(String _name) {
        this.name = _name;
    }
    public String getShortname() {
        return shortname;
    }
    public void setShortname(String _shortname) {
        this.shortname = _shortname;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String _description) {
        this.description = _description;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean _enabled) {
        this.enabled = _enabled;
    }
    public boolean isDefault() {
        return sectorDefault;
    }
    public void setDefault(boolean _default) {
        this.sectorDefault = _default;
    }


    @Override
    public String toString() {
        return shortname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_ID);
        dest.writeString(name);
        dest.writeString(shortname);
        dest.writeString(description);
        dest.writeInt(dependencyId);
        dest.writeByte((byte) (enabled ? 1 : 0));
        dest.writeByte((byte) (sectorDefault ? 1 : 0));
    }

}
