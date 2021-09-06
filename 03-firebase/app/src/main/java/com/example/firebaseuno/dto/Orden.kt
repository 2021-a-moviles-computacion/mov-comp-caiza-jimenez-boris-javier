package com.example.firebaseuno.dto

data class Orden(var restaurante: String, var producto: String, var precio: Double, var catidad: Int, var total: Double) {

    override fun toString(): String {
        return "$restaurante - $producto - $precio - $catidad - $total"
    }
}