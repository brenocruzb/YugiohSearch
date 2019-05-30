package br.com.yugiohsearch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CardFilter: Serializable {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("fname")
    @Expose
    var fuzzyName: String? = null

    fun validateFuzzyName(): Boolean = !fuzzyName.isNullOrEmpty()

    fun getFilterDescription(): List<FilterDescription>{
        val listDescription = ArrayList<FilterDescription>()

        if(!name.isNullOrEmpty()) listDescription.add(FilterDescription("Nome", name!!))
        if(!fuzzyName.isNullOrEmpty()) listDescription.add(FilterDescription("Nome Fuzzy", fuzzyName!!))

        return listDescription
    }

}