package br.com.yugiohsearch.model

data class ReturnObject<T> (val obj: T?, val message: String?, val status: Int = 0)