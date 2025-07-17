package com.coderroots.kotlinclass6week.practiceroomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface UserDao {

    @Insert
    fun insertUser(userModel: UserModel)

    @Query("SELECT * FROM UserModel")
    fun getUserData() :List<UserModel>


    @Update
    fun userUpdate(userModel : UserModel)

    @Delete
    fun deleteUser(userModel: UserModel)



}