package com.example.savename2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.savename2.R
import com.example.savename2.databinding.MainFragmentBinding
import com.example.savename2.BR.myViewModel

//private var _binding: MainFragmentBinding? = null
//private val binding get() = _binding!!
class MainFragment : Fragment() {
    //add mainfragment binding code
    companion object {
        fun newInstance() = MainFragment()
    }
    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding
    //private var _binding: ViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=DataBindingUtil.inflate(
            inflater, R.layout.main_fragment,container,false)
        binding.setLifecycleOwner(this)
        return binding.root

    }
    //override fun onActivityCreated(savedInstanceState: Bundle?)
    override fun onViewCreated(view:View, savedInstanceState: Bundle?){
        //super.onActivityCreated(savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)
        // TODO: Use the ViewModel
        //android:onClick="@{()->myViewModel.setName()}"
        //android:text="@={myViewModel.names}"
        //android:text="@={myViewModel.name}"
        }
    }

