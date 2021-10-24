package com.example.savename2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    //var = variable
    //val = value
    // TODO: Implement the ViewModel
    var name: MutableLiveData<String> = MutableLiveData()
    var names: MutableLiveData<String> = MutableLiveData()

    fun setList(){
    name.let{
        if(!it.value.isNullOrBlank()){
            if (names.value==null){
                names.value = it.value
            }else{
                names.value += "\n" + it.value
            }
        }
    }
       // names.value += name.value + " \n"
        //remove null if else statement
        
    }

}