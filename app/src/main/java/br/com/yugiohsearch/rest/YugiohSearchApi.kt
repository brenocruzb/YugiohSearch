package br.com.yugiohsearch.rest

import br.com.yugiohsearch.model.Card
import retrofit2.Callback
import java.util.HashMap

class YugiohSearchApi {
    private val appService by lazy { ApiClient.retrofit.create(AppService::class.java) }

    fun getRandomCard(callback: Callback<List<List<Card>>>) = appService.getRandomCard().enqueue(callback)

    fun getFuzzyCard(fuzzyName: String, callback: Callback<List<List<Card>>>){
        val map = HashMap<String, String>()
        map["fname"] = fuzzyName

        appService.getCard(map).enqueue(callback)
    }
}