package com.example.myapplication

import android.os.Parcelable
import java.text.SimpleDateFormat
import java.util.*
import android.os.Parcel as Parcel

class ECine(var id_cine:Int, var nombre: String?, var dirección: String?, var salas:Int?, var estrellas:Double?, var fecha_estrenos: Date?):Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble(),
        Date(parcel.readString())

    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_cine)
        parcel.writeString(nombre)
        parcel.writeString(dirección)
        parcel.writeInt(salas!!)
        parcel.writeDouble(estrellas!!)
        parcel.writeString(SimpleDateFormat("dd/MM/yyyy").format(fecha_estrenos))

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "$id_cine-$nombre-$dirección-$salas-$estrellas-${SimpleDateFormat("dd/MM/yyyy").format(fecha_estrenos)}"
    }

    companion object CREATOR : Parcelable.Creator<ECine> {
        override fun createFromParcel(parcel: Parcel): ECine {
            return ECine(parcel)
        }

        override fun newArray(size: Int): Array<ECine?> {
            return arrayOfNulls(size)
        }
    }



}