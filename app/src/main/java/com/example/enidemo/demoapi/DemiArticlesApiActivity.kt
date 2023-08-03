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

class DemiArticlesApiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demi_articles_api)

        // Appel api lors du clique
        findViewById<Button>(R.id.btnAppelApi).setOnClickListener {
            appelApi()
        }
    }

    fun appelApi(){
        // La liste de film a envoyer dans le liste
        lifecycleScope.launch {
            // Récupère les données depuis un API
            var articles = ArticleApi.retrofitService.getArticles()

            // Récupère la list view
            var lvArticles = findViewById<ListView>(R.id.lvArticles)

            // Adapter déjà développé par Android
            var arrayAdapter = ArrayAdapter<Article>(this@DemiArticlesApiActivity,  android.R.layout.simple_list_item_1)

            // Liaison de l'adapter
            lvArticles.adapter = arrayAdapter

            // Envoyer les données dans l'adapteur
            arrayAdapter.addAll(articles)

            Log.i("DemoApiList", articles.count().toString())
        }
    }
}