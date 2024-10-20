package com.example.jetpackbasicui.di

import android.content.Context
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.jetpackbasicui.data.local.room.AppDataBase
import com.example.jetpackbasicui.data.local.room.UserDao
import com.example.jetpackbasicui.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module //Create the Dagger hilt module
@InstallIn(SingletonComponent::class) //install dagger module
object AppModule { //there is no need for create the object it's default singleton
    @Provides //this provide annotation tells to dagger how to create the need instance of the project
    fun provideDatabase(@ApplicationContext app:Context):AppDataBase
    {
        return Room.databaseBuilder(app,AppDataBase::class.java,"register_details").build()
    }

    @Provides
    fun provideDao(db:AppDataBase):UserDao{
        return db.userDao()
    }

    @Provides
    fun provideUserRepository(userDao: UserDao):UserRepository{
        return UserRepository(userDao)
    }


}