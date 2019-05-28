package br.com.yugiohsearch.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateDeckViewModel: ViewModel(){
    val filter: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    fun addFilter(){
        filter.value = true
    }
}