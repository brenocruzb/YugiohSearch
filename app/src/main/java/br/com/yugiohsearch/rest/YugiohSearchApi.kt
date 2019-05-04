package br.com.yugiohsearch.rest

import br.com.yugiohsearch.model.Card
import retrofit2.Callback

class YugiohSearchApi {
    private val appService by lazy { ApiClient.retrofit.create(AppService::class.java) }

    fun getRandomCard(callback: Callback<List<List<Card>>>) = appService.getRandomCard().enqueue(callback)
}