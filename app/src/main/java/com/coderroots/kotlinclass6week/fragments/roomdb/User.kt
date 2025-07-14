package com.coderroots.kotlinclass6week.fragments.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var name: String? = null,
    var contact: String? = null
)
