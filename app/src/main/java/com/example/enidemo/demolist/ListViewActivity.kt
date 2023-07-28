package com.example.enidemo.demolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import com.example.enidemo.Person
import com.example.enidemo.R

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // Récupérer la list view
        var lvPersons = findViewById<ListView>(R.id.lvPersons)

        // Utiliser un adpater déja développé par Android
        // var myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        var myAdapter = ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1)

        // On le connecter à la ListView de notre activité
        lvPersons.adapter = myAdapter

        // Envoyer une liste de donné
        // var listFirstnames = arrayListOf<String>("isaac", "morgan", "octavia")
        //  myAdapter.addAll(listFirstnames)

        var listPersons = arrayListOf<Person>(Person("isaac", "test"), Person("laurent", "le vrai"))
        myAdapter.addAll(listPersons)
    }
}