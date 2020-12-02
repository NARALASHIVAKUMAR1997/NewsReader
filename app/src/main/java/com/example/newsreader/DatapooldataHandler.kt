package com.example.newsreader

import android.database.Observable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField

class DatapooldataHandler {

    val countryList = ObservableArrayList<CountryList>()
    val subCategoryList = ObservableArrayList<String>()
    val resultData = ObservableArrayList<NewsData>()
}