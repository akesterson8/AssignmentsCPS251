package com.ebookfrenzy.finalProject.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.finalProject.Contacts
import com.ebookfrenzy.finalProject.R
import com.ebookfrenzy.finalProject.databinding.CardLayoutBinding

import com.ebookfrenzy.finalProject.databinding.MainFragmentBinding
import java.lang.Integer.parseInt
import java.util.*

//import com.ebookfrenzy.roomdemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private var _bindingCard: CardLayoutBinding? = null
    private val bindingCard get() = _bindingCard!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {

        binding.addBtn.setOnClickListener {
            val name = binding.name.text.toString()
            val phone = binding.phone.text.toString()

            if (name != "" && phone != "") {
                val contact = Contacts(name, phone)
                viewModel.insertContact(contact)
                clearFields()
            }
        }

        binding.findBtn.setOnClickListener { viewModel.findcontact(binding.name.text.toString()) }
        binding.ascBtn.setOnClickListener { viewModel.ascContact() }
        binding.descBtn.setOnClickListener { viewModel.descContact() }
//        bindingCard.deleteBtn.setOnClickListener{
//            (viewModel.deleteContact(bindingCard.itemId.text.toString().toInt()))
//            clearFields()
//        }

    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { products ->

            products?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                }

            }
        })
        viewModel.ascContact()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })
        viewModel.descContact()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setContactList(it)
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter

        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener{
            override fun onClick(id: String) {
                var itemid: Int = parseInt(id)
                viewModel.deleteContact(itemid)
            }
        })
    }

    private fun clearFields() {

        binding.name.setText("")
        binding.phone.setText("")
    }
}


