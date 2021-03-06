package com.example.lifecycle.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.OnLifecycleEvent
import com.example.lifecycle.databinding.MainFragmentBinding
import androidx.lifecycle.Observer

private var _binding: MainFragmentBinding? = null
private val binding get() = _binding!!
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

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

//    private lateinit var owner: Owner

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        lifecycle.addObserver(Observer())
        val resultObserver = Observer<String>{
                result -> binding.message.text = result
        }
        viewModel.getMessage().observe(viewLifecycleOwner, resultObserver)
        binding.message.text = viewModel.getMessage().value.toString()


//        owner = Owner()
//        owner.startOwner()
//        owner.stopOwner()
    }

}