package com.github.yamamotoj.disample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    // inject
    val d by lazy { (application as DISampleApplication).container.resolve(D::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("log", d.toString())
    }
}
