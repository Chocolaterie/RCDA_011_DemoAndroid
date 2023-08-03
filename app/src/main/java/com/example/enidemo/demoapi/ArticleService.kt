package com.example.enidemo.demoapi

import com.example.enidemo.demoapi.MovieService.Companion.retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ArticleService {

    companion object {
        // L'url racine de l'api
        val BASE_URL = "http://10.0.2.2:80/demo-api/public/"

        // Préparer l'utilitaire qui va permettre de mapper le JSON en Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        // Utilitaire retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("articles")
    suspend fun getArticles() : List<Article>

    @POST("add-article")
    suspend fun addArticle(@Body article: Article)
}

object ArticleApi {
    val retrofitService : ArticleService by lazy { retrofit.create(ArticleService::class.java) }
}