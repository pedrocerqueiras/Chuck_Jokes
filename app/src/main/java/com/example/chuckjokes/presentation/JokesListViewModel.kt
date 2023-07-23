package com.example.chuckjokes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chuckjokes.data.JokesDto
import com.example.chuckjokes.data.JokesService
import com.example.chuckjokes.data.RetrofitModule
import kotlinx.coroutines.launch
import java.lang.Exception

class JokesListViewModel(
    private val jokesService: JokesService
): ViewModel() {

    private val _jokesListLiveData = MutableLiveData<List<JokesDto>>()
    val jokesListLiveData: LiveData<List<JokesDto>> = _jokesListLiveData

    init {
        getJokesList()
    }

    private fun getJokesList(){
        viewModelScope.launch {
            try {
                val response = jokesService.fetchJokes()
                _jokesListLiveData.value = response.data
            } catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }

    companion object{

        fun create(): JokesListViewModel{
            val jokesService = RetrofitModule.createJokesService()
            return JokesListViewModel(jokesService)

        }

    }

}