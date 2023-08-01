package com.example.enidemo.demoapi

import com.example.enidemo.demoapi.MovieService.Companion.retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MovieService {

    companion object {
        // L'url racine de l'api
        val BASE_URL = "https://raw.githubusercontent.com/Chocolaterie/EniWebService/main/api/"

        // Préparer l'utilitaire qui va permettre de mapper le JSON en Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        // Utilitaire retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("movies.json")
    suspend fun getMovies() : List<Movie>
}

object MovieApi {
    val retrofitService : MovieService by lazy { retrofit.create(MovieService::class.java) }
}