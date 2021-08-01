package com.example.myapplication

import java.io.Serializable

data class MovieStreaming (var nombre:String, var certificado:String? = null, var certificado_imagen:Int):Serializable {
}