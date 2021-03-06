package com.udacity.shoestore.view.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel:ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf(
            Shoe("AirMax 90",40,"Nike", "A marca do swoosh acumula ao longo de décadas muitas cartadas de sucesso dentro e fora do âmbito esportivo"),
            Shoe("Ultrarange EXO",39,"Vans", "Tênis confortável e ideal para quem curte andar de Skate"),
            Shoe("NMD R1",40,"Adidas", "Tênis confortável para praticar exercícios"),
            Shoe("RS Dreamer",40,"Puma", "A clássica linha RS, recebe uma silhueta esportiva, unindo o mais alto nível de desempenho com um design moderno"),
            Shoe("All Star",40,"Converse", "A clássica linha RS, recebe uma silhueta esportiva, unindo o mais alto nível de desempenho com um design moderno")
        )
    }

    fun addNewShoe(shoe: Shoe){
        _shoeList.value?.add(shoe)
    }

    fun updateShoeList(positionId: Int, shoeEdit: Shoe?){
        if (shoeEdit != null)
            _shoeList.value?.set(positionId,shoeEdit)
    }

}