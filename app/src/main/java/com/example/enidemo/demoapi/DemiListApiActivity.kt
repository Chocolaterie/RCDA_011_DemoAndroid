package com.example.enidemo.demoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.lifecycle.lifecycleScope
import com.example.enidemo.R
import kotlinx.coroutines.launch

class DemiListApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demi_list_api)

        // Appel api lors du clique
        findViewById<Button>(R.id.btnAppelApi).setOnClickListener {
            appelApi()
        }
    }

    fun appelApi(){
        // La liste de film a envoyer dans le liste
        lifecycleScope.launch {
            // Récupère les données depuis un API
            var movies = MovieApi.retrofitService.getMovies()

            // Récupère la list view
            var lvMovies = findViewById<ListView>(R.id.lvMovies)

            // Adapter déjà développé par Android
            var arrayAdapter = ArrayAdapter<Movie>(this@DemiListApiActivity,  android.R.layout.simple_list_item_1)

            // Liaison de l'adapter
            lvMovies.adapter = arrayAdapter

            // Envoyer les données dans l'adapteur
            arrayAdapter.addAll(movies)

            Log.i("DemoApiList", movies.count().toString())
        }
    }
}