package com.example.brvah_demo.ui.diff

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.brvah_demo.R
import com.example.brvah_demo.data.DiffUtilDemoEntity
import com.example.brvah_demo.databinding.ActivityDiffUtilBinding
import com.example.brvah_demo.databinding.HeadViewBinding

class DiffUtilActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityDiffUtilBinding
    private var diffUtilDataList = mutableListOf<DiffUtilDemoEntity>()
    private val mAdapter by lazy {
        DiffUtilAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityDiffUtilBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initRv()
        initData()
        initListener()
    }

    private fun initListener() {
        mBinding.itemChangeBtn.setOnClickListener {
            //新数据
            val newData = getNewList()
            mAdapter.setDiffNewData(newData)

        }
        mBinding.notifyChangeBtn.setOnClickListener {
            //精确更新  某单条item   部分UI刷新
            mAdapter.data[0] = DiffUtilDemoEntity(
                1,
                "\uD83D\uDE0A\uD83D\uDE0AItem 0",
                "item 0 content changed(notifyItemChanged)",
                "09-30"
            )
            mAdapter.notifyItemChanged(
                0 + mAdapter.headerLayoutCount,
                DiffUtilAdapter.ITEW_0_PAYLOAD
            )
        }
    }

    private fun getNewList(): MutableList<DiffUtilDemoEntity> {
        val list = mutableListOf<DiffUtilDemoEntity>()
        for (i in 0..10) {
            //删除 1  3
            if (i == 1 || i == 3) {
                continue
            }
            //修改 0 数据title
            if (i == 0) {
                list.add(
                    DiffUtilDemoEntity(
                        i,
                        "\uD83D\uDE0AItem $i",
                        "this item $i content",
                        "09-29"
                    )
                )
                continue
            }
            //修改 4 数据content
            if (i == 4) {
                list.add(DiffUtilDemoEntity(i, "Item $i", "哈哈哈哈哈,item $i content changed", "09-29"))
                continue
            }

            list.add(DiffUtilDemoEntity(i, "Item $i", "this item $i content", "09-28"))
        }
        return list
    }

    private fun initData() {
        for (i in 0..10) {
            diffUtilDataList.add(DiffUtilDemoEntity(i, "Item $i", "this item $i content", "09-28"))
        }
        mAdapter.setList(diffUtilDataList)
    }

    private fun initRv() {
        mBinding.diffRv.adapter = mAdapter
        val top = layoutInflater.inflate(R.layout.head_view, mBinding.diffRv, false)
        top.findViewById<ImageView>(R.id.iv).isVisible = false
        mAdapter.addHeaderView(top)
        mAdapter.setDiffCallback(DiffCallBack())
    }


}