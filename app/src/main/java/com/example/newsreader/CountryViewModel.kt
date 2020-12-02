package com.example.newsreader

import android.content.Context
import androidx.lifecycle.ViewModel

class CountryViewModel(val context: Context,val datapooldataHandler: DatapooldataHandler) : ViewModel() {

    fun loadData() {
        val countryName = context.resources.getStringArray(R.array.news_sources)
        val countryCode = context.resources.getStringArray(R.array.country_codes)
        for (element in countryCode.indices) {
            datapooldataHandler.countryList.add(
                CountryList(
                    countryCode[element],
                    countryName[element]
                )
            )
        }
    }
}