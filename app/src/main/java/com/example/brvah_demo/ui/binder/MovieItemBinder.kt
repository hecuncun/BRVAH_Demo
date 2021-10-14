package com.example.brvah_demo.ui.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chad.library.adapter.base.binder.QuickViewBindingItemBinder
import com.example.brvah_demo.data.Movie
import com.example.brvah_demo.databinding.ItemMovieBinding

class MovieItemBinder:QuickViewBindingItemBinder<Movie,ItemMovieBinding>() {
    override fun convert(holder: BinderVBHolder<ItemMovieBinding>, data: Movie) {
       holder.viewBinding.moviePrice.text = data.price.toString()
        holder.viewBinding.movieName.text = data.name
        holder.viewBinding.movieContent.text = data.content
    }

    override fun onCreateViewBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ItemMovieBinding = ItemMovieBinding.inflate(layoutInflater,parent,false)

    override fun onClick(
        holder: BinderVBHolder<ItemMovieBinding>,
        view: View,
        data: Movie,
        position: Int
    ) {
        super.onClick(holder, view, data, position)
        Toast.makeText(context,"Movie $position",Toast.LENGTH_SHORT).show()
    }
}