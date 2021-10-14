package com.example.brvah_demo.ui.diff

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.brvah_demo.R
import com.example.brvah_demo.data.DiffUtilDemoEntity

class DiffUtilAdapter :
    BaseQuickAdapter<DiffUtilDemoEntity, BaseViewHolder>(R.layout.layout_animation) {
    companion object {
        val ITEW_0_PAYLOAD = 901
    }

    override fun convert(holder: BaseViewHolder, item: DiffUtilDemoEntity) {
        holder.setText(R.id.tweetName, item.tittle)
            .setText(R.id.tweetDate, item.date)
            .setText(R.id.tweetText, item.content)
    }

    /**
     * 当有 payload info 时，只会执行此方法
     * 只刷新部分UI 显示
     */
    override fun convert(holder: BaseViewHolder, item: DiffUtilDemoEntity, payloads: List<Any>) {
        for (p in payloads) {
            val payload = p as Int
            if (payload == ITEW_0_PAYLOAD) {
                holder.setText(R.id.tweetName, item.tittle)
                    .setText(R.id.tweetText, item.content)
            }
        }

    }

}