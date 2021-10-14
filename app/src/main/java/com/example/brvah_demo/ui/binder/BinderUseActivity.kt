package com.example.brvah_demo.ui.binder

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseBinderAdapter
import com.example.brvah_demo.R
import com.example.brvah_demo.data.ContentEntity
import com.example.brvah_demo.data.ImageEntity
import com.example.brvah_demo.data.Movie
import com.example.brvah_demo.data.Video
import com.example.brvah_demo.databinding.ActivityMultipleItemUseBinding

class BinderUseActivity:AppCompatActivity() {
    private lateinit var mBinding :ActivityMultipleItemUseBinding

    private val mAdapter by lazy {
          BaseBinderAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMultipleItemUseBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initView()
        initRv()
    }

    override fun onStart() {
        super.onStart()
        val list = mutableListOf<Any>()
        list.add(ImageEntity())
        list.add(ImageEntity())
        list.add(ImageEntity())
        list.add(ImageEntity())
        list.add(Video(1,"","video 1 "))
        list.add(Video(2,"","video 2 "))
        list.add(Video(3,"","video 3 "))
        list.add(Video(4,"","video 4 "))
        list.add(Movie("Movie 1",60,13,"电影1"))
        list.add(Movie("Movie 2",70,15,"电影2"))
        list.add(Movie("Movie 3",90,12,"电影3"))
        list.add(Movie("Movie 4",80,11,"电影4"))
        list.add(ContentEntity("content  1"))
        list.add(ContentEntity("content  2"))
        list.add(ContentEntity("content  3"))
        mAdapter.setList(list)
      // 延迟3秒以后执行，模拟Diff刷新数据
      mBinding.rvList.postDelayed(
       Runnable {
           val listData =  mAdapter.data
           listData.add(0,ImageEntity())
           listData.add(8,Movie("Movie 1",66,13,"电影1"))
           listData.add(Movie("Movie 5",88,19,"电影5"))
           mAdapter.setDiffNewData(listData)
       },3000
      )


    }

    private fun initRv() {
        mAdapter.addItemBinder(ImageEntity::class.java,ImageItemBinder())//QuickItemBinder 方式
        mAdapter.addItemBinder(Video::class.java,ImageTextItemBinder()) //QuickViewBindingItemBinder 方式
        mAdapter.addItemBinder(ContentEntity::class.java,ContentItemBinder())//BaseItemBinder 方式
        mAdapter.addItemBinder(Movie::class.java,MovieItemBinder(),MovieDiff())//QuickItemBinder 方式  注册diff




        val headView = layoutInflater.inflate(R.layout.head_view,null,false)
        headView.findViewById<ImageView>(R.id.iv).isVisible = false
        headView.setOnClickListener {
            Toast.makeText(this@BinderUseActivity,"headView click",Toast.LENGTH_SHORT).show()
        }
        mAdapter.setHeaderView(headView)
        mBinding.rvList.layoutManager = LinearLayoutManager(this)
        mBinding.rvList.adapter = mAdapter
    }

    private fun initView() {

    }
}