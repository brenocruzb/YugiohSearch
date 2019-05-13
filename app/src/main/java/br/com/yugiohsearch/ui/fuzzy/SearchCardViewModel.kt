package br.com.yugiohsearch.ui.fuzzy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.rest.YugiohSearchApi
import br.com.yugiohsearch.util.Constants
import com.facebook.drawee.backends.pipeline.Fresco
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchCardViewModel: ViewModel() {

    val loading: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = Constants.gone } }
    val loadCard: MutableLiveData<Int> by lazy { MutableLiveData<Int>().apply { value = Constants.visible } }

    val listCards: MutableLiveData<List<Card>> by lazy { MutableLiveData<List<Card>>() }

    val editSearch: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val tilErrorSearch: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun onSearchClicked(){
        loading.value = Constants.visible
        loadCard.value = Constants.invisible

        tilErrorSearch.value = if(editSearch.value.isNullOrEmpty()){
            "Insira o nome de um card"
        }else{
            YugiohSearchApi().getFuzzyCard(editSearch.value ?: "IS NULL", object : Callback<List<List<Card>>>{
                override fun onResponse(
                    call: Call<List<List<Card>>>,
                    response: Response<List<List<Card>>>
                ) {
                    if(response.code() == 200){
                        val card = response.body()!![0]
                        listCards.value = card
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

    override fun onCleared() {
        super.onCleared()
        Fresco.getImagePipeline().clearCaches()
    }
}