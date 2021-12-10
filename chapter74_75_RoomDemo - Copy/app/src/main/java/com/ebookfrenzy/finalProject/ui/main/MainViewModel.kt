package com.ebookfrenzy.finalProject.ui.main

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.finalProject.Contacts
import com.ebookfrenzy.finalProject.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contacts>>?
    private val searchResults: MutableLiveData<List<Contacts>>

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
    }

    fun insertContact(contacts: Contacts) {
        repository.insertContact(contacts)
    }

    fun findcontact(name: String) {
        repository.findContact(name)
    }

    fun descContact(): MutableLiveData<List<Contacts>>? {
        repository.descContact()
        return searchResults
    }
    fun ascContact(): MutableLiveData<List<Contacts>>? {
        repository.ascContact()
        return searchResults
    }

    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }

    fun getSearchResults(): MutableLiveData<List<Contacts>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contacts>>? {
        return allContacts
    }
}