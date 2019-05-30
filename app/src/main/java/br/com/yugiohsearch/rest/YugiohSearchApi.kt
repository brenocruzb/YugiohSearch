package br.com.yugiohsearch.rest

import br.com.yugiohsearch.model.Card
import br.com.yugiohsearch.model.CardFilter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Callback
import java.util.HashMap

class YugiohSearchApi {
    private val appService by lazy { ApiClient.retrofit.create(AppService::class.java) }

    fun getRandomCard(callback: Callback<List<List<Card>>>) = appService.getRandomCard().enqueue(callback)

    fun getListCard(cardFilter: CardFilter, callback: Callback<List<List<Card>>>){
        val map = convertObjectToMap(cardFilter)!!


        appService.getCard(map).enqueue(callback)
    }

    private fun convertObjectToMap(obj: Any): Map<String, String>? {
        var json = Gson().toJson(obj)

        try {
            json = removeArrays(JSONObject(json)).toString()
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return Gson().fromJson<Map<String, String>>(
            json, object : TypeToken<HashMap<String, String>>() {}.type
        )
    }

    private fun removeArrays(jObject: JSONObject): JSONObject {

        val newJsonObject = JSONObject()
        val keys = jObject.keys()

        while (keys.hasNext()) {
            val key = keys.next() as String
            try {
                if (jObject.get(key) is JSONArray) {

                    val array = jObject.get(key) as JSONArray
                    for (i in 0 until array.length()) {
                        newJsonObject.put("$key[$i]", array.get(i))
                    }
                    //jObject.remove(key);
                } else {
                    newJsonObject.put(key, jObject.get(key))
                }

            } catch (e: JSONException) {
                e.printStackTrace()
                return newJsonObject
            }

        }

        return newJsonObject
    }
}