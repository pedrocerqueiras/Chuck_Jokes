package com.example.chuckjokes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.chuckjokes.R
import com.example.chuckjokes.data.Jokes

class JokesListAdapter: ListAdapter<Jokes, JokesListViewHolder>(JokesListAdapter){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_jokes,parent,false)

        return JokesListViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokesListViewHolder, position: Int) {
        val joke = getItem(position)
        holder.bind(joke)
    }

    companion object: DiffUtil.ItemCallback<Jokes>(){
        override fun areItemsTheSame(oldItem: Jokes, newItem: Jokes): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Jokes, newItem: Jokes): Boolean {
            return oldItem.imageUrl == newItem.imageUrl &&
                    oldItem.value == newItem.value
        }

    }


}

class JokesListViewHolder(
    private val view: View
    ): RecyclerView.ViewHolder(view){

    private val tvJokes = view.findViewById<TextView>(R.id.tv_chuckjoke)
    private val ivJokes = view.findViewById<ImageView>(R.id.iv_chuckjoke)

    fun bind (
        joke: Jokes
    ){
        tvJokes.text = joke.value
        ivJokes.load(joke.imageUrl)
    }

}