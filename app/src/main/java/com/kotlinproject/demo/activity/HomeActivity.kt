package com.kotlinproject.demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlinproject.demo.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}