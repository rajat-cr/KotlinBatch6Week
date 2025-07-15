package com.coderroots.kotlinclass6week.practiceroomdb

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface UserDao {

    @Insert
    fun insertUser(userModel: UserModel)
}