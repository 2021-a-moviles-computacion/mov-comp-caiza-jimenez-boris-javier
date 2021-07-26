package com.example.myapplication

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
):Serializable {
}