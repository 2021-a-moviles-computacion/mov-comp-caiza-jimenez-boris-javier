package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class Cine : AppCompatActivity() {
    companion object{
        var id_a = 0
        var nombre = "cine"
    }

    var posicionItem = 0
    var adapter: ArrayAdapter<ECine>? = null
    val CODIGO_RESPUESTA_INTENT_EXPLICITO = 401


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cine)

        BaseDatos.Base= Tablas(this)



        if(BaseDatos.Base != null) {
            val cine = BaseDatos.Base!!.consultarCineTodo()
            adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cine)
            val listViewUsuario = findViewById<ListView>(R.id.ltv_cine)
            listViewUsuario.adapter = adapter
            registerForContextMenu(listViewUsuario)

        }

        val  botoncrrearCine = findViewById<Button>(R.id.btn_crear1)
        botoncrrearCine.setOnClickListener{
            abrirActividad(CrearCine::class.java)
        }


    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater = menuInflater
        inflater.inflate(R.menu.menucine,menu)

        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        posicionItem = id
        id_a = adapter!!.getItem(posicionItem)!!.id_cine
        nombre = adapter!!.getItem(posicionItem)!!.nombre.toString()




    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var cine1 = adapter!!.getItem(posicionItem)

        return when(item?.itemId){

            //Editar
            R.id.editar_cine-> {

                if (cine1 != null) {
                    abrirActividadConParametros(EditarCine::class.java,cine1)
                }

                return true
            }

            //Eliminar
            R.id.eliminar_cine -> {
                //Log.i("list-view","Eliminar ${UsuarioSelect}")

                if(BaseDatos.Base!=null){

                    AlertDialog.Builder(this).apply {
                        setTitle("Alerta")
                        setMessage("¿Desea eliminar?")
                        setPositiveButton("Si"){ _: DialogInterface, _: Int ->
                            BaseDatos.Base!!.eliminarCine(cine1!!.id_cine)
                            adapter?.remove(adapter!!.getItem(posicionItem));

                        }
                        setNegativeButton("No", null)
                    }.show()


                }
                return true }
            //Ver Casas
            R.id.ver_peliculas -> {

                if (cine1 != null) {
                    abrirActividadConParametros(Pelicula::class.java,cine1)
                }



                return true }

            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }



    fun abrirActividadConParametros(clase: Class<*>, cine: ECine, ){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("cine",cine)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO)

    }
}