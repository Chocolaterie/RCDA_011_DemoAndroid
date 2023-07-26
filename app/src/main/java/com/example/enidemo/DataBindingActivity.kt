package com.example.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.enidemo.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en mode DataBinding
        var myView = DataBindingUtil.setContentView<ActivityDataBindingBinding>(this, R.layout.activity_data_binding)

        // Dans ma vue => la person c'est untel
        myView.person = Person("Vincent", "Le Goat")

        // Je change le texte de mon bouton
        myView.myButton.text = "Mon Bouton Morgan"
    }
}