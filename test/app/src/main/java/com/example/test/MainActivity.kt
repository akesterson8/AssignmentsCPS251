package com.example.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tipBtn.setOnClickListener{convertTip()}
    }

    fun convertTip(){

        if (binding.billAmount.text.isNotEmpty()) {
            val dollar = binding.billAmount.text.toString().toFloat()
            val tip20 = ("%.2f".format((dollar * 0.20f) + dollar))
            val tip15 = ("%.2f".format((dollar * 0.15f) + dollar))
            val tip10 = ("%.2f".format((dollar * 0.10f) + dollar))
            // binding.output.text = "The tips are as follows:\n"
            // binding.output.text = tip20.toString() + "\n"
            // binding.output.text = tip15.toString() + "\n"
            binding.output.text = "The tips are as follows:\n20%=$tip20\n15%=$tip15\n10%=$tip10"
        } else {
            binding.output.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }
}