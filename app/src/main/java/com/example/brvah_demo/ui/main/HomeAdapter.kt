package com.example.brvah_demo.ui.main

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.brvah_demo.R
import com.example.brvah_demo.data.HomeEntity

class HomeAdapter(data:MutableList<HomeEntity>):BaseSectionQuickAdapter<HomeEntity,BaseViewHolder>(R.layout.def_section_head,R.layout.home_item_view,data) {
    override fun convert(holder: BaseViewHolder, item: HomeEntity) {
        holder.setText(R.id.text,item.name)
        holder.setImageResource(R.id.icon,item.imageResource)
    }

    override fun convertHeader(helper: BaseViewHolder, item: HomeEntity) {
        helper.setGone(R.id.more,true)
        helper.setText(R.id.header,item.headerTitle)
    }
}