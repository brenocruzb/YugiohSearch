package br.com.yugiohsearch.ui.fuzzy

import androidx.lifecycle.ViewModel
import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.rest.YugiohSearchApi
import br.com.yugiohsearch.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchCardViewModel: ViewModel() {

//    fun onSearchClicked(){
//        loading.value = Constants.visible
//        loadCard.value = Constants.invisible
//
//        tilErrorSearch.value = if(editSearch.value.isNullOrEmpty()){
//            "Insira o nome de um card"
//        }else{
//            YugiohSearchApi().getRandomCard(object : Callback<List<List<Card>>> {
//                override fun onResponse(call: Call<List<List<Card>>>, response: Response<List<List<Card>>>) {
//                    if(response.code() == 200){
//                        val card = response.body()!![0][0]
//                        cardMutableLiveData.value = card
//                    }else{
//                        tilErrorSearch.value = "Falha ao converter retorno em card."
//                    }
//                    loading.value = Constants.gone
//                    loadCard.value = Constants.visible
//                }
//
//                override fun onFailure(call: Call<List<List<Card>>>, t: Throwable) {
//                    tilErrorSearch.value = "Falha ao se conectar com o servidor."
//                    loading.value = Constants.gone
//                    loadCard.value = Constants.visible
//                }
//            })
//            null
//        }
//    }
//    }
}