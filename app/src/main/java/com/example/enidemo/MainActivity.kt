package com.example.enidemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.enidemo.demolist.DemoAsyncActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }

    /**
     * Lorsque je clique le bouton de l'accueil
     */
    fun onClickBtnTest(view: View) {
        // Je vais ouvrir une activité
        // val = constante ; var = variable (ecriture/lecture)
        // 1 : Instancier l'Intent
        val intent = Intent(this, DemoVueModule2::class.java)

        // Envoyer un int
        intent.putExtra("id", 10);

        // Envoyer une personne
        intent.putExtra("person", Person("isaac", "toto"))

        // 2 : Appeler une methode avec l'Intent à l'intérieur
        startActivity(intent)
    }

}