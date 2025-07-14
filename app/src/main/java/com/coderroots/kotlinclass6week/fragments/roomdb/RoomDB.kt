package com.coderroots.kotlinclass6week.fragments.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.coderroots.kotlinclass6week.fragments.StudentModel


@Database(entities = [StudentModel::class], version = 1)
abstract class RoomDataBases : RoomDatabase()  {
    abstract  fun userDao() : UserDao


    companion object {
        fun getDatabase(context: Context): RoomDataBases {
            var roomDB: RoomDataBases? = null

            if (roomDB == null) {

                  roomDB = Room.databaseBuilder(
                    context, RoomDataBases::class.java,
                    "UserDatabase"
                ).allowMainThreadQueries()
                    .build()
            }

            return roomDB!!
        }
    }






}