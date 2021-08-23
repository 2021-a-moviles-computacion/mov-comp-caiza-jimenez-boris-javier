package com.example.firebaseuno

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.Auth

class MainActivity : AppCompatActivity() {

    val codigo_inicio_sesion = 102
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonLogin = findViewById<Button>(R.id.btn_login)
        botonLogin.setOnClickListener{
                llamarLoginUsuario()
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
                if(resultCode == Activity.RESULT_OK){
                    val usuario = IdpResponse.fromResultIntent(data)
                    if(usuario?.isNewUser == true){
                        Log.i("firebase-login","Nuevo Usuario")
                    }else{
                        Log.i("firebase-login","Usario Antiguo")
                    }
                }else{
                    Log.i("firebase-login","El usuario cancelo")
                }
            }
        }
    }
}