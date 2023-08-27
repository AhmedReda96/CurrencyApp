package com.example.currencyapp.app.utils

import org.json.JSONObject

object Mapper {
    fun convertRatesJsonObjectToList(jsonBody: String,keyName:String): MutableList<Pair<String, Double>> {

        val jsonString = """
       $jsonBody
    """.trimIndent()
        val jsonObject = JSONObject(jsonString)
        val ratesObject = jsonObject.getJSONObject(keyName)

        val ratesList = mutableListOf<Pair<String, Double>>()
        ratesObject.keys().forEach { key ->
            val value = ratesObject.getDouble(key)
            ratesList.add(key to value)
        }
        return ratesList
    }


}