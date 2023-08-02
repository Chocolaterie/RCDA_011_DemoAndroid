package com.example.enidemo.demoviewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditArticleViewModel : ViewModel() {
    var article = MutableLiveData<Article>(Article("", ""));

    /**
     * Je met à jour l'article du view model
     */
    fun saveArticle(){
        if (article.value!!.title.length < 3){
            Log.i("Test", "Le titre est invalide")
        }
        // Le code pour envoyer l'article dans une API WEB

        // Enclencher l'observe
        article.value = article.value
    }
}