package br.com.yugiohsearch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.rest.YugiohSearchApi
import br.com.yugiohsearch.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchCardViewModel: ViewModel() {

    val tilErrorSearch: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val editSearch: MutableLiveData<String> by lazy { MutableLiveData<String>().apply { value = "a" } }

    val tvCardName: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    private val imageUrl: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val loading: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = Constants.gone } }
    val loadCard: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = Constants.visible } }

    val cardMutableLiveData: MutableLiveData<List<Card>> by lazy { MutableLiveData<List<Card>>() }

    fun onSearchClicked(){
        loading.value = Constants.visible
        loadCard.value = Constants.invisible

        tilErrorSearch.value = if(editSearch.value.isNullOrEmpty()){
            "Insira o nome de um card"
        }else{
            YugiohSearchApi().getRandomCard(object : Callback<List<List<Card>>> {
                override fun onResponse(call: Call<List<List<Card>>>, response: Response<List<List<Card>>>) {
                    if(response.code() == 200){
                        val cards = response.body()!![0]
                        fillFields(cards[0])

                        cardMutableLiveData.value = cards
                    }else{
                        tilErrorSearch.value = "Falha ao converter retorno em card."
                    }
                    loading.value = Constants.gone
                    loadCard.value = Constants.visible
                }

                override fun onFailure(call: Call<List<List<Card>>>, t: Throwable) {
                    tilErrorSearch.value = "Falha ao se conectar com o servidor."
                    loading.value = Constants.gone
                    loadCard.value = Constants.visible
                }
            })
            null
        }
    }

    private fun fillFields(card: Card){
        imageUrl.value = card.image_url

        //landscape
        tvCardName.value = card.name
    }


}
