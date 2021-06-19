package com.udacity.shoestore.view.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WelcomeViewModelFactory(private val userName: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WelcomeViewModel::class.java)){
            return WelcomeViewModel(userName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}