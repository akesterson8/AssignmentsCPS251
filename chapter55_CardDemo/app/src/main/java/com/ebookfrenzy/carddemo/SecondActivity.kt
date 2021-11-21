package com.ebookfrenzy.carddemo

import android.content.Intent
import android.os.Bundle

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.carddemo.databinding.ActivityMainBinding
import com.ebookfrenzy.carddemo.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    var data = Data.newInstance()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val arrTitle = extras.getInt("titles")
        val arrDetail = extras.getInt("details")
        val arrImage = extras.getInt("image")

        binding.titleText.text = data.titles[arrTitle]
        binding.detailText.text = data.details[arrDetail]
        binding.pic.setImageResource(data.images[arrImage])


    }

}