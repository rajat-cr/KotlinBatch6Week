package com.coderroots.kotlinclass6week.practiceroomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var userName: String? = null,
    var userContact: String? = null


)
