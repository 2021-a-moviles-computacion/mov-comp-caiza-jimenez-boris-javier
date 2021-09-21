package com.example.eamenprueba

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
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat

class ECine : AppCompatActivity() {
    companion object{
        var id_a = ""
        var nombre = "cine"
    }


    var arregloCines = ArrayList<Cine>()
    var adapter: ArrayAdapter<Cine>? = null
    var posicionItem = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecine)

        val  botonCine = findViewById<Button>(R.id.btn_crear_cine1)
        botonCine.setOnClickListener{
            abrirActividad(CrearCine::class.java)
        }

        val db = Firebase.firestore
        var documentoRestaurante: (MutableList<DocumentSnapshot>)
        var referencia = db.collection("cine")
            .get()
            .addOnSuccessListener {
                documentoRestaurante = it.documents
                documentoRestaurante.forEach { iteracion ->
                    arregloCines.add(Cine(iteracion.get("nombre").toString(),
                        iteracion.get("direccion").toString(),
                        iteracion.get("salas").toString().toInt(),
                        iteracion.get("estrellas").toString().toDouble(),
                        SimpleDateFormat("dd/MM/yyyy").parse(iteracion.get("fecha").toString()),))

                }
                if(arregloCines.size > 0) {
                    adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arregloCines)
                    val listViewUsuario = findViewById<ListView>(R.id.ltv_cine)
                    listViewUsuario.adapter = adapter
                    registerForContextMenu(listViewUsuario)
                }else{

                }
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
        id_a = "${adapter!!.getItem(posicionItem)!!.nombre.toString()}-${adapter!!.getItem(posicionItem)!!.dirección.toString()}"
        nombre = adapter!!.getItem(posicionItem)!!.nombre.toString()





    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var cine1 = adapter!!.getItem(posicionItem)

        return when(item?.itemId){

            //Editar
            R.id.editar_cine-> {

                if (cine1 != null) {
                    this.startActivity(Intent(this,EditarCine::class.java).putExtra("cine",cine1))
                }

                return true
            }

            //Eliminar
            R.id.eliminar_cine -> {
                AlertDialog.Builder(this).apply {
                    setTitle("Alerta")
                    setMessage("¿Desea Eliminar?")
                    setPositiveButton("Si"){_: DialogInterface, _: Int ->
                        val db = Firebase.firestore
                        var refCasa = db.collection("pelicula")
                        EPelicula.arregloPeliculasAUX2.forEach {
                            db.collection("cine").document("${cine1!!.nombre}-${cine1!!.dirección}")
                                .collection("pelicula").document("${it.nombre}-${it.director}") .delete()
                        }

                        db.collection("cine").document("${cine1!!.nombre}-${cine1!!.dirección}").delete()
                        adapter?.remove(adapter!!.getItem(posicionItem));

                    }
                    setNegativeButton("No", null)
                }.show()


                return true }
            //Ver Casas
            R.id.ver_peliculas -> {


                if (cine1 != null) {
                    this.startActivity(Intent(this,EPelicula::class.java).putExtra("cine",cine1))
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
}