package com.example.chuckjokes.data

import retrofit2.http.GET

interface JokesService {

    @GET("jokes/random")
    suspend fun fetchJokes(): JokesResponse
}