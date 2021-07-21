package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class Pelicula : AppCompatActivity() {


    var adapter: ArrayAdapter<EPelicula>? = null
    var CODIGO_RESPUESTA_INTENT_EXPLICITO = 402
    var CODIGO_RESPUESTA_INTENT_EXPLICITO3 = 405
    var posicionItem = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)

        val cine= intent.getParcelableExtra<ECine>("cine")
       //  aux_cine!!.add(cine!!)
        //val id = cine!!.id_cine
        val id = Cine.id_a

        Log.i("bdd","Id:  ${id}")

        BaseDatos.Base= Tablas(this)

        if(BaseDatos.Base != null) {
            adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                BaseDatos.Base!!.cossultarPelicula(id)
            )
            val listViewejemplo = findViewById<ListView>(R.id.ltv_pelicula)
            listViewejemplo.adapter = adapter
            registerForContextMenu(listViewejemplo)
        }


        val botoncrearPelicula = findViewById<Button>(R.id.btn_crear_peliula)
        botoncrearPelicula.setOnClickListener{
           abrirActividadConParametros3(CrearPelicula::class.java, cine!!)

        }


    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater = menuInflater
        inflater.inflate(R.menu.menupelicula,menu)

        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        posicionItem = id
        Log.i("bdd","Selección: ${posicionItem}")


    }


    override fun onContextItemSelected(item: MenuItem): Boolean {

        var pelicula = adapter!!.getItem(posicionItem)

        return when(item?.itemId){


            R.id.editar_pelicula-> {


                    abrirActividadConParametros(EditarPelicula::class.java,pelicula!!)


                return true
            }


            R.id.eliminar_pelicula -> {

                if(BaseDatos.Base!=null){

                    AlertDialog.Builder(this).apply {
                        setTitle("Alerta")
                        setMessage("¿Desea eliminar?")
                        setPositiveButton("Si"){ _: DialogInterface, _: Int ->
                            BaseDatos.Base!!.eliminarCine(adapter!!.getItem(posicionItem)!!.id_pelicula)
                            adapter?.remove(adapter!!.getItem(posicionItem));

                        }
                        setNegativeButton("No", null)
                    }.show()


                }
                return true }


            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirActividadConParametros(clase: Class<*>, pelicula: EPelicula){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("pelicula",pelicula)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO)

    }



    fun abrirActividadConParametros3(clase: Class<*>, cine: ECine){
        val intentExplicito = Intent(
            this,
            clase
        )
        intentExplicito.putExtra("cine",cine)
        startActivityForResult(intentExplicito,CODIGO_RESPUESTA_INTENT_EXPLICITO3)

    }



    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }


}