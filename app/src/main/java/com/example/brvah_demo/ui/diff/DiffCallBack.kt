package com.example.brvah_demo.ui.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.brvah_demo.data.DiffUtilDemoEntity

class DiffCallBack : DiffUtil.ItemCallback<DiffUtilDemoEntity>() {
    override fun areItemsTheSame(
        oldItem: DiffUtilDemoEntity,
        newItem: DiffUtilDemoEntity
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: DiffUtilDemoEntity,
        newItem: DiffUtilDemoEntity
    ): Boolean {
        return oldItem.tittle == newItem.tittle && oldItem.content == newItem.content && oldItem.date == newItem.date
    }

}
