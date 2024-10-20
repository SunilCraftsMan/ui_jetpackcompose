package com.example.jetpackbasicui.data.repository

import android.util.Log
import com.example.jetpackbasicui.data.local.room.User
import com.example.jetpackbasicui.data.local.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val TAG = "===>UserRepository"
class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun storeUserData(user: User){
        withContext(Dispatchers.IO){
            user.apply {
                Log.d(TAG, "storeUserData:username ${username},password ${password} phone ${phone}")
            }
            userDao.insertUser(user)

            userDao.getUserByUsername(user.username).collect{userdata->
                userdata.apply {
                    Log.d(TAG, "storeUserData:All Data ${userdata}")
                }
            }
        }

    }

}