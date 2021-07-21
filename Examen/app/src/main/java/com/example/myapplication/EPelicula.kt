package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable

class EPelicula(
    var id_pelicula:Int, var id_cine_a:Int, var nombre:String?, var director:String?,
    var taquilla:Double,
    var cartelera: Boolean
):Parcelable {


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun toString(): String {
        return "Id_Pelicula:$id_pelicula  Id_Cine:$id_cine_a  Nombre:$nombre  Director:$director  Taquilla:$taquilla  Cartelera:$cartelera"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_pelicula)
        parcel.writeInt(id_cine_a)
        parcel.writeString(nombre)
        parcel.writeString(director)
        parcel.writeDouble(taquilla)
        parcel.writeByte(if (cartelera) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EPelicula> {
        override fun createFromParcel(parcel: Parcel): EPelicula {
            return EPelicula(parcel)
        }

        override fun newArray(size: Int): Array<EPelicula?> {
            return arrayOfNulls(size)
        }
    }
}