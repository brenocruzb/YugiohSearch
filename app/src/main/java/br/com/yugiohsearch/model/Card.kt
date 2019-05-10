package br.com.yugiohsearch.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Card: Serializable{

    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("type")
    @Expose
    var type: String = ""

    @SerializedName("desc")
    @Expose
    var desc: String = ""

    @SerializedName("race")
    @Expose
    var race: String = ""



    @SerializedName("archetype")
    @Expose
    var archetype: String? = null

    @SerializedName("set_tag")
    @Expose
    var tag: String? = null

    @SerializedName("setcode")
    @Expose
    var code: String? = null

    @SerializedName("ban_tcg")
    @Expose
    var banTcg: String? = null

    @SerializedName("ban_ocg")
    @Expose
    var banOcg: String? = null

    @SerializedName("ban_goat")
    @Expose
    var banGoat: String? = null

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null

    @SerializedName("image_url_small")
    @Expose
    var imageUrlSmall: String? = null



    @SerializedName("atk")
    @Expose
    var atk: String? = null

    @SerializedName("def")
    @Expose
    var def: String? = null

    @SerializedName("level")
    @Expose
    var level: String? = null

    @SerializedName("attribute")
    @Expose
    var attribute: String? = null



    @SerializedName("scale")
    @Expose
    var scale: String? = null

    @SerializedName("linkval")
    @Expose
    var linkval: String? = null

    @SerializedName("linkmarkers")
    @Expose
    var linkmarkers: String? = null


    fun isAMonster(): Boolean = !attribute.isNullOrBlank()
    fun isAPendulum(): Boolean = !scale.isNullOrBlank()
    fun isALink(): Boolean = !linkval.isNullOrBlank()
}