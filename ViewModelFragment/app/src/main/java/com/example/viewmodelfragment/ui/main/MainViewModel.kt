package com.example.viewmodelfragment.ui.main

import androidx.lifecycle.ViewModel

//20 lines here
class MainViewModel : ViewModel() {
    //var = variable
    //val = value
    // TODO: Implement the ViewModel
    private var name = ""
    private val namelist = ArrayList<String>()
    private var value=""

    fun setName(value: String){

        name = "$value\n"
        namelist.add(name)
    }
    fun getName(): String  {   //getters dont need parameters but setters do
       var names =""
        for(i in namelist)
         names+=i
        return names
    }



}