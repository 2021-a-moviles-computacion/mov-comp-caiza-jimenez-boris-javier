package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val boton = findViewById<Button>(R.id.btn_cine)
        boton.setOnClickListener{
            abrirActividad(Cine::class.java)
        }
    }

    fun abrirActividad(clase: Class<*>){
        //clase
        val intentExplicito = Intent(
            this,
            clase
        )
        //puedo poner this opcional this.startActivity
        startActivity(intentExplicito)
    }
}