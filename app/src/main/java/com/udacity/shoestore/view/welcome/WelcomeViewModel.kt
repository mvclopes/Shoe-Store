package com.udacity.shoestore.view.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel(userName: String): ViewModel() {

    private var _user = MutableLiveData<String>()
    val user : LiveData<String>
        get() = _user

    init {
        _user.value = userName
    }
}