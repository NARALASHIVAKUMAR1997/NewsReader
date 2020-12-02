package com.example.newsreader

import android.app.Application
import com.example.newsreader.DI.basicModule
import com.example.newsreader.DI.basicViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.KoinContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication


class NewsReaderApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            //inject Android context
            androidContext(this@NewsReaderApp)
            // use modules
            modules(basicModule, basicViewModel)
        }

    }
}