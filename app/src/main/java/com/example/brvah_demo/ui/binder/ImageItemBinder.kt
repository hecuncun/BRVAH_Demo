package com.example.brvah_demo.ui.binder

import android.view.View
import android.widget.Toast
import com.chad.library.adapter.base.binder.QuickItemBinder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.brvah_demo.R
import com.example.brvah_demo.data.ImageEntity

class ImageItemBinder:QuickItemBinder<ImageEntity>() {

    override fun convert(holder: BaseViewHolder, data: ImageEntity) {

    }

    override fun getLayoutId(): Int = R.layout.item_image_view

    override fun onClick(holder: BaseViewHolder, view: View, data: ImageEntity, position: Int) {
        Toast.makeText(context,"click index $position",Toast.LENGTH_SHORT).show()
    }
}