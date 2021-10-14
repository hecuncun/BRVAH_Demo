package com.example.brvah_demo.ui.binder

import androidx.recyclerview.widget.DiffUtil
import com.example.brvah_demo.data.Movie

class MovieDiff :DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
       return oldItem.content == newItem.content && oldItem.price == newItem.price && oldItem.length == newItem.length
    }
}