package com.example.newsreader

import androidx.lifecycle.ViewModel
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

class NewsListViewModel(val datapooldataHandler: DatapooldataHandler) : ViewModel() {

    lateinit var remainsData: RemainsData
    /*fun loadDataFromRepo(remainsData: RemainsData) {
        //datapooldataHandler.resultData.add(remainsData.articles)
    }*/

}