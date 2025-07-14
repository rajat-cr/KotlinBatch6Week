package com.coderroots.kotlinclass6week.fragments

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class StudentModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String? = null,
    var rollNo: String? = null,
    var contactNo: String? = null

){
    override fun toString(): String {
        return name.toString()
    }

}
