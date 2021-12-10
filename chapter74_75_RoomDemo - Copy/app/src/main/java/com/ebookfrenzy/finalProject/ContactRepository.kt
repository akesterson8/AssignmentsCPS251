package com.ebookfrenzy.finalProject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contacts>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contacts>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contacts) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private suspend fun asyncInsert(contacts: Contacts) {
        contactDao?.insertContact(contacts)
    }


    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }


    fun findContact(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contacts>?> =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }


    fun descContact() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncdescContact().await()
        }
    }

    private suspend fun asyncdescContact(): Deferred<List<Contacts>?> =
        coroutineScope.async(Dispatchers.IO) {
        return@async contactDao?.descContact()
    }



    fun ascContact(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncascContact().await()
        }
    }
    private suspend fun asyncascContact(): Deferred<List<Contacts>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.ascContact()
        }

}