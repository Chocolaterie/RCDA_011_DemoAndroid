package com.example.enidemo.demoviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.enidemo.R
import com.example.enidemo.databinding.ActivityDemoCounterBinding

class DemoCounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ma vue xml
        var myView = DataBindingUtil.setContentView<ActivityDemoCounterBinding>(this, R.layout.activity_demo_counter)

        // View model instancié
        var vmCounter = CounterViewModel()

        // Laison du view model avec l'ihm
        myView.vmCounter = vmCounter

        // Ecouter les changement du view model
        vmCounter.counter.observe(this, Observer {
            // Je force de moi a rafraichir la vue
            myView.vmCounter = vmCounter
        })

        // Lancer le compteur
        vmCounter.startCounter();

        myView.btnCounter.setOnClickListener {
            vmCounter.plus()
        }

//        myView.btnCounter2.setOnClickListener {
//            vmCounter.plus()
//        }

    }
}