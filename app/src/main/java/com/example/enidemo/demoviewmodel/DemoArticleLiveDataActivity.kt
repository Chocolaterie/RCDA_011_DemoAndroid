package com.example.enidemo.demoviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityDemoArticleLiveDataBinding
import kotlin.random.Random

class DemoArticleLiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // La vue de mon activity
        var myActivityView = DataBindingUtil.setContentView<ActivityDemoArticleLiveDataBinding>(this, R.layout.activity_demo_article_live_data)

        // Instancier le view model
        var viewModel = EditArticleViewModel()

        // Liéer mon view model dans la vue (dans l'IHM)
        myActivityView.vmEditArticle = viewModel

        // Ecouter quand un article change
        viewModel.article.observe(this, Observer {
            // Rafraichir le view model de la vue (rafraichir la vue)
            myActivityView.vmEditArticle = viewModel
        })

        // Lors du clique du bouton generer un article
        myActivityView.btnRandomArticle.setOnClickListener {
            viewModel.saveArticle()
        }
    }
}