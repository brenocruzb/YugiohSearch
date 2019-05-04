package br.com.yugiohsearch.rest

import br.com.yugiohsearch.model.Card
import retrofit2.Call
import retrofit2.http.GET

interface AppService {
    @GET("randomcard.php")
    fun getRandomCard(): Call<List<List<Card>>>
}