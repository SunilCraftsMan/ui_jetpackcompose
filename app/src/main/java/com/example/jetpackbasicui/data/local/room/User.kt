package com.example.jetpackbasicui.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_register_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    @ColumnInfo(name = "user_name") val username:String="",
    @ColumnInfo(name = "password") val password:String="",
    @ColumnInfo(name = "phone") val phone:String=""
)
