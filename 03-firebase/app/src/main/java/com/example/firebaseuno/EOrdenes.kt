
package com.example.firebaseuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.isEmpty
import com.example.firebaseuno.dto.Orden
import com.example.firebaseuno.dto.Producto
import com.example.firebaseuno.dto.Restaurante
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EOrdenes : AppCompatActivity() {

    var arregloRestaurantes2 = ArrayList<Restaurante>()
    var arregloProductos2 = ArrayList<Producto>()
    var postionRestaurante:Int? = null
    var postionProducto:Int? = null
    var adapter: ArrayAdapter<Orden>? = null
    val arregloOrdenes = ArrayList<Orden>()
    var nombreRestaurante: String? = null
    var nombreProducto: String? = null
    var productoPrecio: Double? = null
    var precio: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eordenes)


        var documentoRestaurante: (MutableList<DocumentSnapshot>)
        var documentoProductos: (MutableList<DocumentSnapshot>)
        val botonAdd = findViewById<Button>(R.id.btn_anadir_lista_producto)
        var suma = 0.0
        var tvtotal = findViewById<TextView>(R.id.tvTotal)
        tvtotal.setText("0")



        val db = Firebase.firestore

        var referencia = db.collection("restaurante")
            .get()
            .addOnSuccessListener {
                documentoRestaurante = it.documents
                documentoRestaurante.forEach { iteracion ->
                    arregloRestaurantes2.add(Restaurante(iteracion.get("nombre").toString()))

                }
                var spinnerRestaurantes = findViewById<Spinner>(R.id.sp_restaurantes)
                val adaptadorRestaurantes = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    arregloRestaurantes2
                )
                spinnerRestaurantes.adapter = adaptadorRestaurantes
                spinnerRestaurantes.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        postionRestaurante = position
                        nombreRestaurante = arregloRestaurantes2[postionRestaurante!!].toString()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }


                }
            }


        val referencia2 = db.collection("producto")
        referencia2
            .get()
            .addOnSuccessListener {
                documentoProductos = it.documents
                documentoProductos.forEach { iteracion ->
                    arregloProductos2.add(Producto(iteracion.get("nombre").toString(), (iteracion.get("precio").toString().toDouble())))
                }
                var spinnerProductos = findViewById<Spinner>(R.id.sp_producto)
                val adaptadorProductos = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arregloProductos2)
                spinnerProductos.adapter = adaptadorProductos

                spinnerProductos.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        postionProducto = position
                        nombreProducto = arregloProductos2[postionRestaurante!!].nombre
                        productoPrecio = arregloProductos2[postionRestaurante!!].precio


                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }


                }


            }

        botonAdd.setOnClickListener {



            val cantidad = findViewById<EditText>(R.id.et_cantidad_producto)
            if (cantidad.text.isNotBlank() && cantidad.text.toString().toInt() != 0 ) {
                val listaPedidos = findViewById<ListView>(R.id.lv_lista_productos)

                val total = productoPrecio!! * cantidad.text.toString().toInt()
                precio = precio + total
                        arregloOrdenes.add(
                            Orden(
                                nombreRestaurante!!,
                                nombreProducto!!,
                                productoPrecio!!,
                                cantidad.text.toString().toInt(),
                                total
                            )

                        )
                    Log.i("help","Arreglo: ${arregloOrdenes}")
                        adapter =
                            ArrayAdapter(this, android.R.layout.simple_list_item_1, arregloOrdenes)
                        listaPedidos.adapter = adapter
                        adapter!!.notifyDataSetChanged()



                Log.i("help", "obtuvo")



            } else {
                Toast.makeText(this, "Llene los campos correctamente, el valor 0 en cantidad tampoco es permitido", Toast.LENGTH_SHORT).show()
            }

            cantidad.setText("")


            Log.i("help", "suma: ${suma}")
            tvtotal.setText(precio.toString())

        }



    }

}