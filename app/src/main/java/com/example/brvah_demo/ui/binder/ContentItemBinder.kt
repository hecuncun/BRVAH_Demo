package com.example.brvah_demo.ui.binder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chad.library.adapter.base.binder.BaseItemBinder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.brvah_demo.R
import com.example.brvah_demo.data.ContentEntity

class ContentItemBinder:BaseItemBinder<ContentEntity,BaseViewHolder>() {
    override fun convert(holder: BaseViewHolder, data: ContentEntity) {
        holder.setText(R.id.tv,data.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view  = LayoutInflater.from(context).inflate(R.layout.item_text_view,parent,false)
        return BaseViewHolder(view)
    }

    override fun onClick(holder: BaseViewHolder, view: View, data: ContentEntity, position: Int) {
        super.onClick(holder, view, data, position)
        Toast.makeText(context,"content $position",Toast.LENGTH_SHORT).show()
    }
}