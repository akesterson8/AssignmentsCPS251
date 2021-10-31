package com.example.lifecycle.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val LOG_TAG = "MainViewModel"
    companion object{
        val log = "MainViewModel"
        var stage: MutableLiveData<String> = MutableLiveData()
        var printResult = ""

        fun setMessage(life: String){
            printResult += "${life}\n"
            stage.value = printResult
            Log.i(log, "setMessage" + stage.toString())
        }

    }
    fun getMessage(): MutableLiveData<String> {
        Log.i(LOG_TAG, "getMessage" + stage.value.toString())
        return stage

    }
//    var stage =""
//    private var printResult=""
//
//    fun setMessage() {
//        this.stage = ("${this.printResult}\n")
//
//
//    }


//    fun getMessage(): String{
//        return printResult
//    }
}