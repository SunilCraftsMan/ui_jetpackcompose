package com.example.jetpackbasicui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackbasicui.R
import com.example.jetpackbasicui.data.repository.UserRepository
import com.example.jetpackbasicui.ui.helper.BottomMenuContent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val userRepository: UserRepository) :ViewModel() {
    val _bottomMenuContent=MutableLiveData<List<BottomMenuContent>>()
    val bottomMenuContent:LiveData<List<BottomMenuContent>> get() = _bottomMenuContent

    init {
        bottomMenuContents()
    }

    private fun bottomMenuContents() {
        _bottomMenuContent.value= listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Explore", R.drawable.ic_baseline_explore_24),
            BottomMenuContent("Dark Mode", R.drawable.ic_moon),
            BottomMenuContent("Videos", R.drawable.ic_videocam),
            BottomMenuContent("Profile", R.drawable.ic_profile))
    }
}