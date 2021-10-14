package com.example.brvah_demo.ui.multi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.brvah_demo.databinding.ActivityChooseMultipleItemUseTypeBinding
import com.example.brvah_demo.ui.binder.BinderUseActivity

class ChooseMultipleItemUseTypeActivity:AppCompatActivity() {
    private lateinit var mBinding :ActivityChooseMultipleItemUseTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityChooseMultipleItemUseTypeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initListener()
    }

    private fun initListener() {
        mBinding.cardView0.setOnClickListener {
          startActivity(Intent(this@ChooseMultipleItemUseTypeActivity,BinderUseActivity::class.java))
        }
    }
}