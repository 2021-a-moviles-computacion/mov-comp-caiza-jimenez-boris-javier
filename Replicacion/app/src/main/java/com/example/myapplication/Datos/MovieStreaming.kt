package com.example.myapplication.Datos

import java.io.Serializable

data class MovieStreaming (var nombre:String, var certificado:String? = null, var certificado_imagen:Int,
var clasificacion:String, var fecha:String, var genero:String,  var duracion:Int,
var imagen_certificado_cliente:Int, var certificado_cliente:String):Serializable {
}