package br.com.yugiohsearch.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.rest.YugiohSearchApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchCardViewModel: ViewModel() {

    val errorSearch: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val search: MutableLiveData<String> by lazy { MutableLiveData<String>().apply { value = "a" } }
    val output: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val loading: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = 8 } }
    val loadCard: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = 0 } }

    val cardMutableLiveData: MutableLiveData<List<Card>> by lazy { MutableLiveData<List<Card>>() }

    fun onSearchClicked(){
        loading.value = 0
        loadCard.value = 4

        errorSearch.value = if(search.value.isNullOrEmpty()){
            "Insira o nome de um card"
        }else{
            YugiohSearchApi().getRandomCard(object : Callback<List<List<Card>>> {
                override fun onResponse(call: Call<List<List<Card>>>, response: Response<List<List<Card>>>) {
                    if(response.code() == 200){
                        val cards = response.body()!![0]
                        output.value = cards[0].image_url
                        cardMutableLiveData.value = cards
                    }else{
                        errorSearch.value = "Falha ao converter retorno em card."
                    }
                    loading.value = 8
                    loadCard.value = 0
                }

                override fun onFailure(call: Call<List<List<Card>>>, t: Throwable) {
                    errorSearch.value = "Falha ao se conectar com o servidor."
                    loading.value = 8
                    loadCard.value = 0
                }
            })
            null
        }
    }


}
