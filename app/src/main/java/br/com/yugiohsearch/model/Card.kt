package br.com.yugiohsearch.model

class Card{
    var id: String = ""
    var name: String = ""
    var type: String = ""
    var desc: String = ""
    var race: String = ""

    var archetype: String? = null
    var set_tag: String? = null
    var setcode: String? = null
    var ban_tcg: String? = null
    var ban_ocg: String? = null
    var ban_goat: String? = null
    var image_url: String? = null
    var image_url_small: String? = null

    var atk: String? = null
    var def: String? = null
    var level: String? = null
    var attribute: String? = null

    var scale: String? = null
    var linkval: String? = null
    var linkmarkers: String? = null


    fun isAMonster(): Boolean = !attribute.isNullOrBlank()
    fun isAPendulum(): Boolean = !scale.isNullOrBlank()
    fun isALink(): Boolean = !linkval.isNullOrBlank()
}