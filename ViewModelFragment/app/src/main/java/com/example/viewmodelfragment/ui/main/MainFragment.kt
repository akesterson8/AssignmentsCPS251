package com.example.viewmodelfragment.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewmodelfragment.databinding.MainFragmentBinding


//80 lines here
private var _binding: MainFragmentBinding? = null
private val binding get() = _binding!!
class MainFragment : Fragment() {
    //add mainfragment binding code
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    //private var _binding: ViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        binding.namebtn.setOnClickListener {
            viewModel.setName(binding.nameText.text.toString())
           //binding.nameText.text = viewModel.addName().text.toString()
            binding.displayNames.text = viewModel.getName()

        }
    }





}