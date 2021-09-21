package com.example.eamenprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class EditarCine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_cine)

        var editarCine = intent.getSerializableExtra("cine") as Cine
        val nombre = findViewById<EditText>(R.id.txt_nombre_editar)
        val direccion =  findViewById<EditText>(R.id.txt_descripcion_editar)
        val salas =  findViewById<EditText>(R.id.txt_salas_Editar)
        val estrellas =  findViewById<EditText>(R.id.txt_estrellas_editar)
        val fecha =  findViewById<EditText>(R.id.txt_fecha_editar)

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val fechaComoCadena = sdf.format(editarCine.fecha_estrenos)

       // Log.i("help","fecha sin parsear: ${editarCine.fecha_estrenos}")
        //Log.i("help","fecha sin parsear: ${fechaComoCadena}")
        nombre.setText(editarCine.nombre)
        direccion.setText(editarCine.dirección)
        salas.setText(editarCine.salas.toString())
        estrellas.setText(editarCine.estrellas.toString())
        fecha.setText(fechaComoCadena)

        val botoneditar = findViewById<Button>(R.id.btn_editar)


        botoneditar.setOnClickListener{
            if(nombre.text.isNotBlank() && direccion.text.isNotBlank() && salas.text.isNotBlank() &&
                estrellas.text.isNotBlank() && fecha.text.isNotBlank()){
                if(validar_sala(salas.text.toString()) == true && validar_fecha(fecha.text.toString()) == true &&
                    validar_estrella(estrellas.text.toString()) == true){

                    val nuevoRestaurante = hashMapOf<String, Any>(
                        "nombre" to nombre.text.toString(),
                        "direccion" to direccion.text.toString(),
                        "salas" to salas.text.toString(),
                        "estrellas" to estrellas.text.toString(),
                        "fecha" to fecha.text.toString(),

                        )

                    val db = Firebase.firestore
                    val referencia = db.collection("cine").document("${nombre.text}-${direccion.text}")
                    referencia.set(nuevoRestaurante).addOnSuccessListener {
                        nombre.text.clear()
                        direccion.text.clear()
                        salas.text.clear()
                        estrellas.text.clear()
                        fecha.text.clear()

                    }.addOnFailureListener {

                    }

                    abrirActividad(ECine::class.java)

                }else{
                    Toast.makeText(this, "Llene los campos correctamente", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Llene los Campos", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun validar_nombre(nombre:String): Boolean{
        val validar = Regex("^[a-zA-Z]+\\ [a-zA-Z]*$")

        return validar.matches(nombre)

    }



    fun validar_direccion(direccion:String):Boolean{
        val validar = Regex("^[a-zA-Z]+\\ [a-zA-Z]*$")
        return validar.matches(direccion)
    }

    fun validar_sala(sala: String):Boolean{
        val validar = Regex("^[0-9]{1,2}+$")
        return validar.matches(sala)
    }

    fun validar_estrella(estrella: String):Boolean{
        val validar = Regex("[0-9]+\\.[0-9]+")
        return validar.matches(estrella)
    }

    fun validar_fecha(fecha:String):Boolean{
        val validar = Regex("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])\\/(19|20)\\d\\d")
        return validar.matches(fecha)
    }

    fun abrirActividad(clase: Class<*>) {
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)

    }
}