package br.com.yugiohsearch.rest

import br.com.yugiohsearch.model.Card
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface AppService {
    @GET("randomcard.php")
    fun getRandomCard(): Call<List<List<Card>>>

    @GET("cardinfo.php")
    fun getCard(@QueryMap filter: Map<String, String>): Call<List<List<Card>>>
}