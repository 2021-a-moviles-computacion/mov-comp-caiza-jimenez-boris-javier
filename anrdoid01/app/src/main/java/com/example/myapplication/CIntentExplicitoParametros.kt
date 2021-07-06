package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class CIntentExplicitoParametros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cintent_explicito_parametros)

        val nombre = intent?.getStringExtra("nombre")
        val apellido = intent?.getStringExtra("apellido")
        val edad = intent?.getIntExtra("edad",0)
        val entrenador = intent.getParcelableExtra<BEntrenador>("entrenador")

        Log.i("intent-explicito-parametros","${nombre}")
        Log.i("intent-explicito-parametros","${apellido}")
        Log.i("intent-explicito-parametros","${edad}")
        Log.i("intent-explicito-parametros","${entrenador}")

        val botonDevolverRespuesta = findViewById<Button>(R.id.btn_devolver_respuesta)
        botonDevolverRespuesta.setOnClickListener{
            val intentDevolverParametros = Intent()
            intentDevolverParametros.putExtra("nombreModificado","Vicente")
            intentDevolverParametros.putExtra("edadModificado",32)
            intentDevolverParametros.putExtra("entrenadorModificado",BEntrenador("Boris","Jimenez"))
            //this.setResult
            setResult(RESULT_OK, intentDevolverParametros)
            finish()
            //this.finish()
        }

    }
}