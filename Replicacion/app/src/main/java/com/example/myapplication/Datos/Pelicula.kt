package com.example.myapplication.Datos

import java.io.Serializable

class Pelicula ( var idImagen: Int,
                      var titulo: String,
                      var director: String,
                      var genero: String,
                      var calificacion: Double,
                      var duracion: Int,
                      var fecha: String,
                      var certificado:String,
                      var imagen_certificado:Int,
                      var clasificacion:String,
                      var certificado_cliente:String,
                      var imagen_certificado_cliente:Int,


):Serializable {
}