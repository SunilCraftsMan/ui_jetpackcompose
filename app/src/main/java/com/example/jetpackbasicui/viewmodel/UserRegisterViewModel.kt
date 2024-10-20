package com.example.jetpackbasicui.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackbasicui.data.local.room.User
import com.example.jetpackbasicui.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRegisterViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {
    // LiveData variables for form fields
    private val _regName = MutableLiveData("")
    val regName: LiveData<String> = _regName

    private val _regPassword = MutableLiveData("")
    val regPassword: LiveData<String> = _regPassword

    private val _regPhone = MutableLiveData("")
    val regPhone: LiveData<String> = _regPhone

    // LiveData variables for error messages
    private val _nameErrorMesg = MutableLiveData("")
    val nameErrorMesg: LiveData<String> = _nameErrorMesg

    private val _passwordErrorMesg = MutableLiveData("")
    val passwordErrorMesg: LiveData<String> = _passwordErrorMesg

    private val _phoneErrorMesg = MutableLiveData("")
    val phoneErrorMesg: LiveData<String> = _phoneErrorMesg

    fun onNameChanged(newValue: String) {
        _regName.value = newValue
    }

    fun onPasswordChanged(newValue: String) {
        _regPassword.value = newValue
    }

    fun onPhoneChanged(newValue: String) {
        _regPhone.value = newValue
    }

    fun validateUserInput(): Boolean {
        var isValid = true

        // Username validation
        if (_regName.value.isNullOrEmpty()) {
            _nameErrorMesg.value = "Username cannot be empty."
            isValid = false
        } else if (_regName.value!!.length < 4) {
            _nameErrorMesg.value = "Username must be at least 4 characters long."
            isValid = false
        } else if (_regName.value!!.contains(" ")) {
            _nameErrorMesg.value = "Username cannot contain spaces."
            isValid = false
        } else {
            _nameErrorMesg.value = ""
        }

        // Password validation
        if (_regPassword.value.isNullOrEmpty()) {
            _passwordErrorMesg.value = "Password cannot be empty."
            isValid = false
        } else if (_regPassword.value!!.length < 6) {
            _passwordErrorMesg.value = "Password must be at least 6 characters long."
            isValid = false
        } else {
            _passwordErrorMesg.value = ""
        }

        // Phone number validation
        if (_regPhone.value.isNullOrEmpty()) {
            _phoneErrorMesg.value = "PhoneNumber cannot be empty."
            isValid = false
        } else if (_regPhone.value!!.length < 10) {
            _phoneErrorMesg.value = "PhoneNumber must be at least 10 characters long."
            isValid = false
        } else {
            _phoneErrorMesg.value = ""
        }

        return isValid
    }

    fun storeUserData(user: User){
        viewModelScope.launch {
            userRepository?.storeUserData(user)
        }
    }

}