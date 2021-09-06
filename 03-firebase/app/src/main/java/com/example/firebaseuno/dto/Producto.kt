package com.example.firebaseuno.dto

class Producto(var nombre: String, var precio: Double) {

    override fun toString(): String {
        return "$nombre Precio=$precio"
    }
}