package com.example.deberbase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonirUsuario = findViewById<Button>(R.id.btn_usuario)
        botonirUsuario.setOnClickListener{abrirActividad(InterfaceUsuario::class.java)}

        val botonirLista = findViewById<Button>(R.id.btn_list_view)
        botonirLista.setOnClickListener{abrirActividad(BListViewUsuario::class.java)}
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