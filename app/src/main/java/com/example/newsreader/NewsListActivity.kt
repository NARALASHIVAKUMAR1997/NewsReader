package com.example.newsreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_news_list.*
import kotlinx.android.synthetic.main.activity_sub_categories.*
import org.koin.android.ext.android.inject

class NewsListActivity : AppCompatActivity() {
    val newsListViewModel:NewsListViewModel by inject()
    val datapooldataHandler:DatapooldataHandler by inject()
    val eventHandler:EventHandler by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
    }
    private fun loadData(){
        list_of_news.layoutManager = LinearLayoutManager(this)
        val adapter = RecylerviewAdapter(
            R.layout.sub_categories_item,
            datapooldataHandler.resultData,
            eventHandler, datapooldataHandler
        )
        list_of_sub_categories.adapter = adapter
    }
}
