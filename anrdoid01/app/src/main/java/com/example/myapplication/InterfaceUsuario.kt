package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.math.E

class InterfaceUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface_usuario)
        EBaseDatos.TablaUsuario = ESqliteHelperUsuario(this)

        /////Crear
        val botonCrear = findViewById<Button>(R.id.btn_crear)
        val nombre = findViewById<EditText>(R.id.txt_nombre)
        val descripcion = findViewById<EditText>(R.id.txt_descripcion)

        botonCrear.setOnClickListener {
            if (EBaseDatos.TablaUsuario != null) {
                EBaseDatos.TablaUsuario!!.crearUsuarioFormulario(
                    nombre.text.toString(),
                    descripcion.text.toString()
                )
                Log.i("bdd", "Usuario creado ${nombre.text}, Descripcion; ${descripcion.text} ")
            }
        }

        val id = findViewById<EditText>(R.id.con_elim)
        val botonConsultar = findViewById<Button>(R.id.btn_consultar)
        botonConsultar.setOnClickListener {
            if (EBaseDatos.TablaUsuario != null) {
                val usuario= EBaseDatos.TablaUsuario!!.consultarUsuarioPorId(id.text.toString().toInt())
                Log.i("bdd", " id: ${usuario.id} nombre: ${usuario.nombre} descripción:${usuario.descripcion} ")
            }
        }

        val botonEliminar = findViewById<Button>(R.id.btn_eliminar)
        botonEliminar.setOnClickListener{
            if (EBaseDatos.TablaUsuario != null) {
                val usuario = EBaseDatos.TablaUsuario!!.eliminarUsuarioFormulario(id.text.toString().toInt())
                Log.i("bdd", "usuario eliminado con id: ${id.text}, existe el usuario: ${usuario} ")
            }
        }

        val botonActualizar =  findViewById<Button>(R.id.btn_acualizar)
        val id_actualizar = findViewById<EditText>(R.id.txt_id)
        val nombre_actualizar = findViewById<EditText>(R.id.txt_nomre_actualizar)
        val descripcion_actualizar = findViewById<EditText>(R.id.txt_Descripcion_actualizar)
        botonActualizar.setOnClickListener{
            if (EBaseDatos.TablaUsuario != null) {
                val usuario = EBaseDatos.TablaUsuario!!.actualizarUsuarioFormulario(nombre_actualizar.text.toString(),
                    descripcion_actualizar.text.toString(), id_actualizar.text.toString().toInt())
                Log.i("bdd", "usuario actualizado con id: ${id_actualizar.text}, ha sido actualizado a nombre: ${nombre_actualizar.text}" +
                        "y Descripción: ${descripcion_actualizar.text} ")
            }

        }

    }
}

