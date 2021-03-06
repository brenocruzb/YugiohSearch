package br.com.yugiohsearch.ui.create.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.yugiohsearch.model.CardFilter

class FilterCreateDeckViewModel: ViewModel() {
    val filter: MutableLiveData<CardFilter> by lazy { MutableLiveData<CardFilter>() }
    val nameError: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun onClickFilter(cardFilter: CardFilter){

        if(validate(cardFilter))
            this.filter.value = cardFilter
    }

    private fun validate(cardFilter: CardFilter): Boolean{
        var validate = true

        if(!cardFilter.validateFuzzyName()){
            validate = false
            nameError.value = "Insira um nome"
        }else
            nameError.value = null

        return validate
    }
}