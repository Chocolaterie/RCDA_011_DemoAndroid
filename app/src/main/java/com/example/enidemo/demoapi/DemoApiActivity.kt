package com.example.enidemo.demoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.example.enidemo.R
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
        // Appel api
        lifecycleScope.launch {
            // Appel le service
            val joke = ChuckApi.retrofitService.getRandomJoke()

            // Afficher la blague dans la console
            Log.i("DemoApi", String.format("la blague est : %s", joke.message))
        }
    }
}