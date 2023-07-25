package com.example.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DemoVueModule2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_vue_module2)

        Log.i("EniDemoTest", String.format("Je suis dans le on create"));
        Log.w("EniDemoTest", String.format("Je suis dans le on create"));
        Log.v("EniDemoTest", String.format("Je suis dans le on create"));
        Log.d("EniDemoTest", String.format("Je suis dans le on create"));
        Log.wtf("EniDemoTest", String.format("Je suis dans le on create"));

        // On peut caster tant que l'heritage est valide
        Log.i("EniDemoTest", findViewById<TextView>(R.id.btnSignUp).text.toString());

        // j'ajoute un evenement/listener on click sur le bouton (que faire lorsque je clique sur le bouton)
        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            (it as Button).text = "Coucou";
            Log.i("EniDemoTest", String.format("J'ai cliqué sur le bouton dans le setOnClick"));
        }
    }

    fun onClickSignUp(view: View) {
        // Soit on teste et ça caste en meme temps
        if (view is Button){
            view.text = "Coucou";
            Log.i("EniDemoTest", String.format("J'ai cliqué sur le bouton (avec un if)"));
        }
        // Soit on caste on dur
        (view as Button).text = "Coucou";
        Log.i("EniDemoTest", String.format("J'ai cliqué sur le bouton"));
    }

}