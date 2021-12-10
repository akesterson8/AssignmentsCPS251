package com.ebookfrenzy.finalProject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contacts: Contacts)

    @Query("SELECT * FROM contacts WHERE name LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contacts>

    @Query("SELECT * FROM contacts ORDER BY name DESC")
    fun descContact(): List<Contacts>

    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun ascContact(): List<Contacts>

    @Query("DELETE FROM contacts WHERE id = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contacts>>
}