package com.example.enidemo.demoapi

import com.example.enidemo.demoapi.ChuckService.Companion.retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ChuckService {

    companion object {
        // L'url racine de l'api
        val BASE_URL = "https://api.chucknorris.io/jokes/"

        // Préparer l'utilitaire qui va permettre de mapper le JSON en Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        // Utilitaire retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("random")
    suspend fun getRandomJoke() : Joke
}

object ChuckApi {
    val retrofitService : ChuckService by lazy { retrofit.create(ChuckService::class.java) }
}