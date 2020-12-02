package com.example.newsreader

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_view.*
import kotlinx.android.synthetic.main.custom_view.view.*


class SampleActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_view)

        t1.setOnClickListener {
            updateData(it.t1, p1)
        }
        t2.setOnClickListener {
            updateData(it.t2, p2)
        }
        t3.setOnClickListener {
            updateData(it.t3, p3)
        }
        t4.setOnClickListener {
            updateData(it.t4, p4)
        }


    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun updateData(view: TextView, progressBar: ProgressBar) {
        when (view) {
            t1 -> {
                view.setTextAppearance(R.style.active_style)
                progressBar.visibility = View.VISIBLE
                disableData(t2, p2, t3, p3, t4, p4)
                updateProgressData(t1, p1)

            }
            t2 -> {
                view.setTextAppearance(R.style.active_style)
                progressBar.visibility = View.VISIBLE
                disableData(t1, p1, t3, p3, t4, p4)
                updateProgressData(t2, p2)

            }
            t3 -> {
                view.setTextAppearance(R.style.active_style)
                progressBar.visibility = View.VISIBLE
                disableData(t2, p2, t1, p1, t4, p4)
                updateProgressData(t3, p3)

            }
            t4 -> {
                view.setTextAppearance(R.style.active_style)
                progressBar.visibility = View.VISIBLE
                disableData(t2, p2, t3, p3, t1, p1)
                updateProgressData(t4, p4)

            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun disableData(
        t1: TextView,
        p1: ProgressBar,
        t2: TextView,
        p2: ProgressBar,
        t3: TextView,
        p3: ProgressBar
    ) {
        t1.setTextAppearance(R.style.normal_style)
        p1.visibility = View.INVISIBLE
        t2.setTextAppearance(R.style.normal_style)
        p2.visibility = View.INVISIBLE
        t3.setTextAppearance(R.style.normal_style)
        p3.visibility = View.INVISIBLE
    }

    fun updateProgressData(t1: TextView, progressBar: ProgressBar) {
        /*Thread(Runnable {
            fun run() {
                var process: Int = 0
                while (process < 100) {
                    process += 1
                    Handler().post(Runnable {
                        fun run() {
                            progressBar.progress = process
                            t1.text = process.toString()
                        }
                    })
                }
            }

        }).start()*/

        val t: Thread = object : Thread() {
            override fun run() {
                var jumpTime = 0
                while (jumpTime < 100) {
                    try {
                        sleep(100)
                        jumpTime += 5
                        progressBar.setProgress(jumpTime)
                        t1.text = jumpTime.toString()
                    } catch (e: InterruptedException) { // TODO Auto-generated catch block
                        e.printStackTrace()
                    }
                }
            }
        }
        t.start()
    }

}