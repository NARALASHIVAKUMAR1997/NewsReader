package com.example.newsreader

import android.content.Context
import androidx.lifecycle.ViewModel

class SubCategoryViewModel(val context: Context,val datapooldataHandler: DatapooldataHandler) : ViewModel() {

    fun loadData() {
        val subCategory = context.resources.getStringArray(R.array.subCategory_name)
        for (element in subCategory.indices){
            datapooldataHandler.subCategoryList.add(
                subCategory[element]
            )
        }
    }
}