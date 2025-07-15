package com.coderroots.kotlinclass6week.practiceroomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserModel::class] ,version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object{

        fun getDatabase(context: Context) : UserDatabase{
            var userDatabase : UserDatabase? = null
            if(userDatabase == null){
                userDatabase = Room.databaseBuilder(context,UserDatabase::class.java,"Userdatabase")
                    .allowMainThreadQueries()
                    .build()

            }

       return userDatabase
        }
    }
}