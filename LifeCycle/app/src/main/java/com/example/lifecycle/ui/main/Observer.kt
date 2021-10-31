package com.example.lifecycle.ui.main

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer: LifecycleObserver {
    private val LOG_TAG = "Observer"
//    private var viewModel: MainViewModel = MainViewModel()
    private var viewModel = MainViewModel


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume(){
            Log.i(LOG_TAG, "onResume")
            viewModel.setMessage("onResume")
        }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.i(LOG_TAG, "onPause")
        viewModel.setMessage("onPause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.i(LOG_TAG, "onCreate")
        viewModel.setMessage("onCreate")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.i(LOG_TAG, "onStart")
        viewModel.setMessage("onStart")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.i(LOG_TAG, "onStop")
        viewModel.setMessage("onStop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.i(LOG_TAG, "onDestroy")
        viewModel.setMessage("onDestroy")
    }

//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event){
//        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
//    }

}