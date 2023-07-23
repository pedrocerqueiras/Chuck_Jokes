package com.example.chuckjokes.data

import com.google.gson.annotations.SerializedName

data class JokesResponse (
    val data: List<JokesDto>
)

data class JokesDto(
    @SerializedName("icon_url")
    val imageUrl: String,
    val value: String
)