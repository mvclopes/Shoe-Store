package com.udacity.shoestore.view.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel:ViewModel() {

    private var _shoeList = MutableLiveData<Shoe>()
    val shoeList : LiveData<Shoe>
        get() = _shoeList
}