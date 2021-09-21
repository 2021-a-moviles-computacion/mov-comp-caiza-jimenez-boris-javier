package com.example.eamenprueba

import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class Cine ( var nombre: String?, var dirección: String?, var salas:Int?, var estrellas:Double?, var fecha_estrenos: Date?):
    Serializable {
    override fun toString(): String {
        return "  Nombre:$nombre  Dirección:$dirección  Salas:$salas  Estrellas:$estrellas  Fecha:${SimpleDateFormat("dd/MM/yyyy").format(fecha_estrenos)}"
    }
}