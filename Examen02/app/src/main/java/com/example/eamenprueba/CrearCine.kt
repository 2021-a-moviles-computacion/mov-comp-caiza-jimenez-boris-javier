package com.example.eamenprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CrearCine : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cine)
        val nombre = findViewById<EditText>(R.id.txt_nombre_crear)
        val direccion = findViewById<EditText>(R.id.txt_direccion_crear)
        val salas = findViewById<EditText>(R.id.txt_salas_crear)
        val estrellas = findViewById<EditText>(R.id.txt_esrellas_Crear)
        val fecha = findViewById<EditText>(R.id.txt_fecha_Crear)


        val crearCine = findViewById<Button>(R.id.btn_crear2)
        crearCine.setOnClickListener {
            if(nombre.text.isNotBlank() && direccion.text.isNotBlank() && salas.text.isNotBlank() &&
                estrellas.text.isNotBlank() && fecha.text.isNotBlank()){
                if(validar_sala(salas.text.toString()) == true && validar_fecha(fecha.text.toString()) == true &&
                    validar_estrella(estrellas.text.toString()) == true){
                    crearcine()
                    abrirActividad(ECine::class.java)
                }else{
                    Toast.makeText(this,"Ingrese los campos correctamente", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Llene los Campos", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun crearcine() {

        val nombre = findViewById<EditText>(R.id.txt_nombre_crear)
        val direccion = findViewById<EditText>(R.id.txt_direccion_crear)
        val salas = findViewById<EditText>(R.id.txt_salas_crear)
        val estrellas = findViewById<EditText>(R.id.txt_esrellas_Crear)
        val fecha = findViewById<EditText>(R.id.txt_fecha_Crear)

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

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }


}