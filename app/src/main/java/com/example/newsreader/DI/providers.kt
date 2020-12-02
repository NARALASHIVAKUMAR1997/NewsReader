package com.example.newsreader.DI

import android.content.Context
import android.provider.ContactsContract
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreader.DatapooldataHandler
import com.example.newsreader.EventHandler
import com.example.newsreader.PrepareData
import com.example.newsreader.RecylerviewAdapter
import org.koin.dsl.module

val basicModule = module {

    single { provideEventHandler() }
    single { provideDatapooDataHandler() }
    single { PrepareData() }
}

fun provideEventHandler(): EventHandler {
    return EventHandler()
}

fun provideDatapooDataHandler():DatapooldataHandler{
    return DatapooldataHandler()
}

