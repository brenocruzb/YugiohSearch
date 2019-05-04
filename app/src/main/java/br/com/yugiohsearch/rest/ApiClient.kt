package br.com.yugiohsearch.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val timeOut = 10

    val retrofit: Retrofit by lazy {

        val urlBase = "https://db.ygoprodeck.com/api/v4/"

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            .connectTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(urlBase)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}