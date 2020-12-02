package com.example.newsreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsreader.databinding.CountryListBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.uil_countries_list_item.view.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), EventResponseHandler {
    lateinit var binding: CountryListBinding
    private val eventHandler: EventHandler by inject()
    private val datapooldataHandler: DatapooldataHandler by inject()
    private val countryViewModel: CountryViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {

        eventHandler.registerEventListener(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
                as CountryListBinding

        binding.let {
            it.clickHandler = eventHandler
            it.datapoolHandler = datapooldataHandler
        }
        loadData()

    }

    fun loadData() {
        countryViewModel.loadData()
        list_of_countries.layoutManager = LinearLayoutManager(this)
        val adapter = RecylerviewAdapter(
            R.layout.uil_countries_list_item,
            datapooldataHandler.countryList,
            eventHandler, datapooldataHandler
        )
        list_of_countries.adapter = adapter
    }

    override fun eventResponse(view: View, obj: Any) {
        if (view is ConstraintLayout) {
            val intent = Intent(this, SubCategoriesActivity::class.java)
            intent.putExtra("country Code",view.country_code.text)
            startActivity(intent)
        }
    }

}