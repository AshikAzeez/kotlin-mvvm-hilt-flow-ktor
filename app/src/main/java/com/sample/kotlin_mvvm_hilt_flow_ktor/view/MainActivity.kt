package com.sample.kotlin_mvvm_hilt_flow_ktor.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sample.kotlin_mvvm_hilt_flow_ktor.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

