package com.ebookfrenzy.finalProject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contacts {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String? = null
    var phone: String? = null

    constructor() {}

    constructor(id: Int, name: String, phone: String) {
        this.id = id
        this.name = name
        this.phone = phone
    }
    constructor(name: String, phone:String) {
        this.name = name
        this.phone = phone
    }
}