package com.example.newsreader

import android.content.Context
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sample_custom.*


class SampleCustomActivity : AppCompatActivity() {

    private lateinit var mPaintProgress: Paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_custom)
    }
}

