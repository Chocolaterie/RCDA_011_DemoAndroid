package com.example.enidemo.demoviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditArticleViewModel : ViewModel() {

    var article = MutableLiveData<Article>();

    /**
     * Je met à jour l'article du view model
     */
    fun saveArticle(newArticle : Article ){
        article.value = newArticle
    }
}