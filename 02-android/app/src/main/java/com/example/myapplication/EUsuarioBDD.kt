package com.example.myapplication

class EUsuarioBDD(
    var id: Int,
    var nombre: String,
    var descripcion: String){

    override fun toString(): String {
        return  "${id} - ${nombre} - ${descripcion}"
    }

}