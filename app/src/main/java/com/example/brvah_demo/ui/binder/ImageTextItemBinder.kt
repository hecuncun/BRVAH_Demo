package com.example.brvah_demo.ui.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chad.library.adapter.base.binder.QuickViewBindingItemBinder
import com.example.brvah_demo.data.Video
import com.example.brvah_demo.databinding.ItemImgTextViewBinding

class ImageTextItemBinder:QuickViewBindingItemBinder<Video,ItemImgTextViewBinding>() {
    override fun convert(holder: BinderVBHolder<ItemImgTextViewBinding>, data: Video) {
        holder.viewBinding.tv.text ="(ViewBinding) ${data.name} "
    }

    override fun onCreateViewBinding(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ItemImgTextViewBinding = ItemImgTextViewBinding.inflate(layoutInflater,parent,false)

    override fun onClick(
        holder: BinderVBHolder<ItemImgTextViewBinding>,
        view: View,
        data: Video,
        position: Int
    ) {
        super.onChildClick(holder, view, data, position)
        Toast.makeText(context,"video $position",Toast.LENGTH_SHORT).show()
    }
}