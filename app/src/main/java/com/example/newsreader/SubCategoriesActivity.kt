package com.example.newsreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsreader.databinding.CountryListBinding
import com.example.newsreader.databinding.SubCategoryBinding
import kotlinx.android.synthetic.main.activity_sub_categories.*
import kotlinx.android.synthetic.main.activity_sub_categories.view.*
import kotlinx.android.synthetic.main.sub_categories_item.view.*
import org.koin.android.ext.android.inject

class SubCategoriesActivity : AppCompatActivity(), EventResponseHandler {

    lateinit var binding: SubCategoryBinding
    private val eventHandler: EventHandler by inject()
    private val datapooldataHandler: DatapooldataHandler by inject()
    private val subCategoryViewModel: SubCategoryViewModel by inject()
    private val prepareData:PrepareData by inject()
    lateinit var countryCode:String
    lateinit var subCategoryName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        eventHandler.registerEventListener(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_categories)
                as SubCategoryBinding
        loadData()
        binding.let {
            it.clickHandler = eventHandler
            it.datapoolHandler = datapooldataHandler

        }
    }

    fun loadData() {
        subCategoryViewModel.loadData()
        list_of_sub_categories.layoutManager = LinearLayoutManager(this)
        val adapter = RecylerviewAdapter(
            R.layout.sub_categories_item,
            datapooldataHandler.subCategoryList,
            eventHandler, datapooldataHandler
        )
        list_of_sub_categories.adapter = adapter

    }

    override fun eventResponse(view: View, obj: Any) {
        if (view is ConstraintLayout){
            val bundle = intent.extras
            countryCode =bundle!!.getString("country Code")!!
            subCategoryName = view.list_item_sub_categories.text.toString()
            prepareData.getDataFromApi(countryCode,subCategoryName)
            val intent = Intent(this,NewsListActivity::class.java)
            startActivity(intent)
        }
    }


}

