package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val CODIGO_RESPUESTA_INTENT_EXPLICITO = 401
    val CODIGO_RESPUESTA_INTENT_IMPLICITO = 402
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* EBaseDeDatos.TablaUsuario = ESqliteHelperUsuario(this)
        if(EBaseDeDatos.TablaUsuario!=null){
            EBaseDeDatos.TablaUsuario!!.consultarUsuarioPorId()
            EBaseDeDatos.TablaUsuario!!.creatUsuarioFormulario()
            EBaseDeDatos.TablaUsuario!!.eliminarUsuarioFomrulario()
            EBaseDeDatos.TablaUsuario!!.actualizarUsuarioFormulario()
        }*/


        val botonIrACicloVida = findViewById<Button>(R.id.btn_ciclo_vida)  //Lo heredamos de la clase.
        botonIrACicloVida.setOnClickListener{ abrirActividad(ACicloVida::class.java) }

        val botonIrBListView = findViewById<Button>(R.id.btn_ir_list_view)  //Lo heredamos de la clase.
        botonIrBListView.setOnClickListener{ abrirActividad(BListView::class.java) }


        val botonIrIntent = findViewById<Button>(R.id.btn_ir_intent)
      //  botonIrIntent.setOnClickListener{abrirActividadConParametros(CIntentExplicitoParametros::class.java)}

        val botonAbrirIntentImplicito = findViewById<Button>(R.id.btn_ir_intent_implicito)
        botonAbrirIntentImplicito.setOnClickListener{
            val intentConRespuesta = Intent(Intent.ACTION_PICK,
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
            //startActivityForResult(intentConRespuesta, CODIGO_RESPUESTA_INTENT_IMPLICITO)
        }

        val botonIrUsuario = findViewById<Button>(R.id.btn_ir_usuario)
        botonIrUsuario.setOnClickListener{abrirActividad(InterfaceUsuario::class.java)}

        val botonAbrirRecylcerView = findViewById<Button>(R.id.btn_ir_recycler_view)
        botonAbrirRecylcerView.setOnClickListener{abrirActividadConParametros(GReculcerView::class.java)}

    }


    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent( //Intent es una clase, solamente para que este bien contextualizado.
            this,
            clase
        )
        startActivity(intentExplicito) //Lo heredamos de la clase.
    }

   fun abrirActividadConParametros(clase: Class<*>){
       val  intentExplicito = Intent(this, clase)
        intentExplicito.putExtra("nombre","Boris")
        intentExplicito.putExtra("apellido","Caiza")
        intentExplicito.putExtra("edad",21)
        intentExplicito.putExtra("entrenador",BEntrenador("Boris","Caiza"))
        startActivityForResult(intentExplicito, CODIGO_RESPUESTA_INTENT_EXPLICITO)
     /*  registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            when(it.resultCode){
                Activity.RESULT_OK-> {
                    //Ejecutar codigo OK
                    it.data?.getStringExtra("nombreModofocado")
                    it.data?.getIntExtra("edadModificada",0)
                    it.data?.getParcelableExtra<BEntrenador>("entrenadorModificado")
                }
            }
        }*/
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            CODIGO_RESPUESTA_INTENT_EXPLICITO -> {
                if(resultCode == RESULT_OK){
                    Log.i("intent-explicito","Si actualizo los datods" )
                    if(data != null ){
                        val nombre = data.getStringExtra("nombreModificado")
                        val edad = data.getIntExtra("edadModificado",0)
                        val entrenador = data.getParcelableExtra<BEntrenador>("entrenadorModificado")
                        Log.i("intent-explicito","${nombre}" )
                        Log.i("intent-explicito","${edad}" )
                        Log.i("intent-explicito","${entrenador}" )
                    }
                }
            }

            CODIGO_RESPUESTA_INTENT_IMPLICITO -> {
                if(resultCode == RESULT_OK){
                    if(data != null){
                        if(data.data != null){
                            val uri: Uri = data.data!!
                            val cursor = contentResolver.query(
                            uri,
                            null,
                            null,
                            null,
                            null,
                            null
                            )
                            cursor?.moveToFirst()
                            val indiceTelefono = cursor?.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                            )

                            val telefono = cursor?.getString(indiceTelefono!!)

                            cursor?.close()
                            Log.i("resultado","${telefono}")
                        }
                    }
                }
            }
        }
    }
}