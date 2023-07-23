package com.example.chuckjokes.data

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitModule {

    fun createJokesService(): JokesService {

        val logging = HttpLoggingInterceptor()
        logging.apply {
            HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit
            .Builder()
            .client(client)
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))

        return retrofit
            .build()
            .create(JokesService::class.java)
    }

}