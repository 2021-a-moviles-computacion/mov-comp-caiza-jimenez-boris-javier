package com.example.firebaseuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EOrdenes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eordenes)

         val spinnerRestaurante = findViewById<Spinner>(R.id.sp_restaurantes)

        var restaurantesa:(MutableList<DocumentSnapshot>)
        var restauranteB= ArrayList<String>()
        val db = Firebase.firestore
        val referencia = db.collection("restaurante").get().addOnSuccessListener {
            restaurantesa  = it.documents
            restaurantesa.forEach {iteracion ->
                restauranteB.add(iteracion.get("nombre").toString())
                //Log.i("help", "Respuesta: ${iteracion.get("nombre").toString()}")
                //Log.i("help", "Respuesta: ${restauranteB}")
            }
            Log.i("help", "Respuesta 5: ${restauranteB}")
            val lista = restauranteB.toList()
            Log.i("help", "Respuesta 6: ${lista}")
            val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista)
            spinnerRestaurante.adapter = adaptador


        }

        val spinnerProducto = findViewById<Spinner>(R.id.sp_producto)

        var productosa:(MutableList<DocumentSnapshot>)
        var productosB= ArrayList<String>()
        val referencia2 = db.collection("producto").get().addOnSuccessListener {
            productosa  = it.documents
            productosa.forEach {iteracion ->
                productosB.add(iteracion.get("nombre").toString())
                //Log.i("help", "Respuesta: ${iteracion.get("nombre").toString()}")
                Log.i("help", "Respuesta: ${productosB}")
            }
            Log.i("help", "Respuesta 5: ${productosB}")
            val lista = productosB.toList()
            Log.i("help", "Respuesta 6: ${lista}")
            val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista)
            spinnerProducto.adapter = adaptador


        }


    }



}

