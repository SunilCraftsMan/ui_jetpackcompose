package com.example.jetpackbasicui.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao():UserDao
}