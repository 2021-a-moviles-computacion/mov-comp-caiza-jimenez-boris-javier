package com.example.firebaseuno

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.firebaseuno.dto.FirestoreUsuarioDto
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    val codigo_inicio_sesion = 102
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonLogin = findViewById<Button>(R.id.btn_login)
        botonLogin.setOnClickListener{
                llamarLoginUsuario()
        }

        val botonLogout = findViewById<Button>(R.id.btn_logout)
        botonLogout.setOnClickListener{
            solicitarSalirDelAplicativo()
        }
    }

    fun llamarLoginUsuario(){

        val providers = arrayListOf(
            //Lista de proveedores.
            AuthUI.IdpConfig.EmailBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTosAndPrivacyPolicyUrls(
                    "https://example.com/terms.html",
                    "https://example.com/provacy.html"
                )
                .build(),
            codigo_inicio_sesion
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            codigo_inicio_sesion-> {
                if(resultCode == Activity.RESULT_OK) {
                    val usuario = IdpResponse.fromResultIntent(data)
                    if (usuario != null) {
                        if (usuario?.isNewUser == true) {
                            Log.i("firebase-login", "Nuevo Usuario")
                            registrarUsuarioPorPrimeraVez(usuario)
                        } else {
                            setearUsuarioFirebase()
                            Log.i("firebase-login", "Usario Antiguo")


                        }
                      }
                    } else {
                        Log.i("firebase-login", "El usuario cancelo")
                    }
            }
        }
    }

    fun setearUsuarioFirebase(){
        val instanciaAuth = FirebaseAuth.getInstance()
        val usuarioLocal = instanciaAuth.currentUser
        if(usuarioLocal != null){
            if(usuarioLocal.email != null){
                val db = Firebase.firestore
                val referencia = db.collection("usuario").document(usuarioLocal.email.toString())
                referencia.get().addOnSuccessListener {
                    val usuarioCargado: FirestoreUsuarioDto?  = it.toObject(FirestoreUsuarioDto::class.java)

                    if(usuarioCargado !=null){
                        BAuthUsuario.usuario = BUsuarioFirebase(usuarioCargado.uid, usuarioCargado.email,
                        usuarioCargado.roles)
                    }
                    setearBienvenida()

                   /* Log.i("firebase-firestore","${usuarioCargado!!.email}")
                    Log.i("firebase-firestore","${usuarioCargado!!.uid}")
                    Log.i("firebase-firestore","${usuarioCargado!!.roles}")*/




                    Log.i("firebase-firestore","Usuario cargado")
                }.addOnFailureListener{
                    Log.i("firebase-firestore","Fallo cargar usuario")
                }
            }
        }
    }

    fun registrarUsuarioPorPrimeraVez(usuario:IdpResponse){
        val identificadorUsuario  = usuario.email
        val  usuarioLogeado = FirebaseAuth.getInstance().getCurrentUser()
        if(usuario.email !=null && usuarioLogeado !=null){
            //roles : ["usuario", "admin"]
            val db = Firebase.firestore
            val rolesUsuario = arrayListOf("usuario")
            val nuevoUsuario = hashMapOf<String, Any>(
                "roles" to rolesUsuario,
                "uid" to usuarioLogeado.uid,
                "email" to identificadorUsuario.toString()
            )

            db.collection("usuario").document(identificadorUsuario.toString())
                .set(nuevoUsuario).addOnSuccessListener {
              Log.i("firebase-firestore","Se creo")
                    setearUsuarioFirebase()
            }
                .addOnFailureListener{
                    Log.i("firebase-firestore","Fallo")
                }


        }else{
            Log.i("firebase-login","ERROR")
        }
    }

        fun setearBienvenida(){
            val textViewBienvenida = findViewById<TextView>(R.id.tv_bienvenida)
            val botonLogin = findViewById<Button>(R.id.btn_login)
            val botonLogout = findViewById<Button>(R.id.btn_logout)
            if(BAuthUsuario.usuario != null){
                textViewBienvenida.text = "Bienvenido ${BAuthUsuario.usuario?.email}"
                botonLogin.visibility = View.INVISIBLE
                botonLogout.visibility = View.VISIBLE
            }else{
                textViewBienvenida.text = "Ingresa al aplicativo"
                botonLogin.visibility = View.VISIBLE
                botonLogout.visibility = View.INVISIBLE
            }
        }


    fun solicitarSalirDelAplicativo(){
        AuthUI.getInstance().signOut(this).addOnCompleteListener{
            BAuthUsuario.usuario = null
            setearBienvenida()
        }
    }



}