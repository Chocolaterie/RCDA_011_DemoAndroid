package com.example.enidemo.demoapi

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.enidemo.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DemoApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_api)

        // le clique du bouton
        findViewById<Button>(R.id.btnAppelApi).setOnClickListener {
            appelApi()
        }
    }

    fun appelApi(){
        // Afficher chargement
        var progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Chargement")
        progressDialog.setMessage("Chargement de la blague...")
        progressDialog.show()

        // Appel api
        lifecycleScope.launch {
            // Attendre 1 sec
            delay(1000)

            // Appel le service
            val joke = ChuckApi.retrofitService.getRandomJoke()

            // Afficher la blague dans un TextView et la console
            findViewById<TextView>(R.id.tvJoke).text = joke.message

            Log.i("DemoApi", String.format("la blague est : %s", joke.message))

            // Fermer le chargement
            progressDialog.dismiss()
        }
    }
}