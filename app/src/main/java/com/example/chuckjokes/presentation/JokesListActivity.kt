package com.example.chuckjokes.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckjokes.R
import com.example.chuckjokes.data.Jokes


class JokesListActivity : AppCompatActivity() {

    private val adapter = JokesListAdapter()

    private val viewModel by lazy {
        JokesListViewModel.create()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokeslist)

        val jokesList: RecyclerView = findViewById(R.id.rv_chuckjokes)
        jokesList.adapter = adapter

        viewModel.jokesListLiveData.observe(this) {jokesListDto ->
                val jokesList = jokesListDto.map { JokesDto ->
                    Jokes(
                        imageUrl = JokesDto.imageUrl,
                        value = JokesDto.value
                    )
                }
                adapter.submitList(jokesList)
        }

    }
}