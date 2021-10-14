package com.example.brvah_demo.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brvah_demo.R
import com.example.brvah_demo.data.HomeEntity
import com.example.brvah_demo.databinding.ActivityMainBinding
import com.example.brvah_demo.ui.diff.DiffUtilActivity
import com.example.brvah_demo.ui.multi.ChooseMultipleItemUseTypeActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding :ActivityMainBinding

    private val homeAdapter by lazy {
        HomeAdapter(homeItemData).apply {
            animationEnable = true
            val top = layoutInflater.inflate(R.layout.top_view,mBinding.rv,false)
            addHeaderView(top)
            setOnItemClickListener { adapter, view, position ->
                val item = adapter.data[position] as HomeEntity
                if (!item.isHeader){
                    startActivity(Intent(this@MainActivity,item.activity))
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.rv.adapter = homeAdapter
    }


    private val homeItemData:ArrayList<HomeEntity>
    get() = arrayListOf(
        HomeEntity(headerTitle = "BaseQuickAdapter 基础功能"),
        HomeEntity("DiffUtil", DiffUtilActivity::class.java, R.mipmap.gv_databinding),
        HomeEntity(headerTitle = "Adapter 类型"),
        HomeEntity("MultipleItem", ChooseMultipleItemUseTypeActivity::class.java, R.mipmap.gv_multipleltem),
        HomeEntity(headerTitle = "功能模块")
    )
}