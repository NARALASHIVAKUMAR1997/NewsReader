package com.example.newsreader

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import java.io.Reader
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

class PrepareData {

    lateinit var URL: String
    private val newsListViewModel: NewsListViewModel by inject(NewsListViewModel::class.java)
    private val datapooldataHandler:DatapooldataHandler by inject(DatapooldataHandler::class.java)

    fun getDataFromApi(countryCode: String, subCategoriesName: String) {
        FuelManager.instance.basePath = "https://newsapi.org/v2/"
        URL =
            "https://newsapi.org/v2/top-headlines?country=$countryCode&category=$subCategoriesName&apiKey=072176f25a704b8f8e9ce1f426023170"

        URL.httpGet().responseObject(NewsDataDeserializable()) { request, response, result ->
            when (result) {
                is Result.Success -> {
                    //newsListViewModel.loadDataFromRepo(result.value)
                }
                is Result.Failure -> {
                    result.error
                }
            }
        }
    }
}

class NewsDataDeserializable() : ResponseDeserializable<RemainsData> {
    override fun deserialize(reader: Reader) = Gson().fromJson(reader, RemainsData::class.java)
}