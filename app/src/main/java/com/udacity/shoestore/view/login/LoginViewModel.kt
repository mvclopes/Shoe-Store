package com.udacity.shoestore.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {

    var _user = MutableLiveData<String>()

    var _password = MutableLiveData<String>()

    private var _eventUserLogged = MutableLiveData<Boolean>()
    val eventUserLogged : LiveData<Boolean>
        get() = _eventUserLogged

    private var _eventUserCreated = MutableLiveData<Boolean>()
    val eventUserCreated : LiveData<Boolean>
        get() = _eventUserCreated

    init {
        _eventUserLogged.value = false
        _eventUserCreated.value = false
    }

    fun onCreateUser(){
        _eventUserCreated.value = true
    }

    fun onCreateUserComplete(){
        _eventUserCreated.value = false
    }

    fun onLogin(){
        _eventUserLogged.value = true
    }
}