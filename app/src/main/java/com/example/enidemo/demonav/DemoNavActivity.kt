package com.example.enidemo.demonav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityDemoNavBinding

class DemoNavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var myView = DataBindingUtil.setContentView<ActivityDemoNavBinding>(this, R.layout.activity_demo_nav)

        myView.navBtn.setOnClickListener {
            // Naviguer sans data binding
            // findNavController(R.id.myNavHost).navigate(R.id.action_homeFragment_to_articleFragment)
        }
    }
}