package com.example.enidemo.demonav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityDemoNavBinding

class DemoNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityDemoNavBinding>(this, R.layout.activity_demo_nav)
    }
}