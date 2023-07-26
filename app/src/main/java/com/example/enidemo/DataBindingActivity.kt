package com.example.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.enidemo.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    // En membre de classe
    var person : Person = Person("Vincent", "Le Goat");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en mode DataBinding
        var myView = DataBindingUtil.setContentView<ActivityDataBindingBinding>(this, R.layout.activity_data_binding)

        // Dans ma vue => la person c'est untel
        myView.person = person

        // Je change le texte de mon bouton
        myView.myButton.text = "Mon Bouton Morgan"

        // je définie le comportement du clique du bouton de la vue
        myView.myButton.setOnClickListener {
            // Modifie la valeur d'une donné de la vue ?
            //myView.person.firstname = "Toto"

            // Je met à jour l'attribut d'une instance
            person.firstname = "Morgan";

            // J'appel le setter de la vue pour enclencher le rafaichissement
            myView.person = person // Met toi à jour

        }
    }
}