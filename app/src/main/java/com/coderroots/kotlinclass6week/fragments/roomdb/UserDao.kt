package com.coderroots.kotlinclass6week.fragments.roomdb

import androidx.room.Dao
import androidx.room.Insert
import com.coderroots.kotlinclass6week.fragments.StudentModel


@Dao
interface UserDao {

    @Insert
    fun insertUser(user: StudentModel)

}
