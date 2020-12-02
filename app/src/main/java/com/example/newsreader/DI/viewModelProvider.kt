package com.example.newsreader.DI

import android.content.Context
import android.service.notification.NotificationListenerService
import com.example.newsreader.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val basicViewModel = module {
    viewModel { provideCountryViewModel(get(), get()) }
    viewModel { provideSubCategoryViewModel(get(),get()) }
    viewModel { NewsListViewModel(get()) }
}

fun provideCountryViewModel(
    context: Context,
    datapooldataHandler: DatapooldataHandler
): CountryViewModel {
    return CountryViewModel(context, datapooldataHandler)
}

fun provideSubCategoryViewModel(context: Context,datapooldataHandler: DatapooldataHandler):SubCategoryViewModel{
    return SubCategoryViewModel(context,datapooldataHandler)
}

