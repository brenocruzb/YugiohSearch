package br.com.yugiohsearch.ui.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.model.CardFilter
import br.com.yugiohsearch.model.FilterDescription
import br.com.yugiohsearch.rest.YugiohSearchApi
import br.com.yugiohsearch.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateDeckViewModel: ViewModel(){
    val event: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    val listCards: MutableLiveData<List<Card>> by lazy { MutableLiveData<List<Card>>() }
    val cardFilter: MutableLiveData<CardFilter> by lazy { MutableLiveData<CardFilter>() }
    val error: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val loading: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = Constants.gone } }
    val loadCard: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = Constants.visible } }

    fun addFilter(){
        event.value = true
    }

    fun onSearch(cardFilter: CardFilter){
        loading.value = Constants.visible
        loadCard.value = Constants.invisible
        this.cardFilter.value = cardFilter

        YugiohSearchApi().getListCard(cardFilter , object : Callback<List<List<Card>>> {
            override fun onResponse(call: Call<List<List<Card>>>, response: Response<List<List<Card>>>) {
                when(response.code()) {
                    200 -> listCards.value = response.body()!![0]
                    400 -> error.value = "Card não encontrado."
                    else -> error.value = "Falha ao converter retorno em card."
                }
                loading.value = Constants.gone
                loadCard.value = Constants.visible
            }

            override fun onFailure(call: Call<List<List<Card>>>, t: Throwable) {
                error.value = "Falha ao se conectar com o servidor."
                loading.value = Constants.gone
                loadCard.value = Constants.visible
            }
        })
    }

    fun get(): List<FilterDescription>?{
        return cardFilter.value?.getFilterDescription()
    }
}