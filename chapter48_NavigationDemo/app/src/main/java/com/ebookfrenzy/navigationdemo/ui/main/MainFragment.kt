package com.ebookfrenzy.navigationdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.navigationdemo.R
import androidx.navigation.Navigation

import com.ebookfrenzy.navigationdemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding=null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btn1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond()

            action.message = binding.img1.contentDescription.toString()
            action.newImg = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)

        }
        binding.btn2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond()

            action.message = binding.img2.contentDescription.toString()
            action.newImg = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action)
        }
        binding.btn3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond  =  MainFragmentDirections.mainToSecond()

            action.message = binding.img3.contentDescription.toString()
            action.newImg = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)
        }
    }

}