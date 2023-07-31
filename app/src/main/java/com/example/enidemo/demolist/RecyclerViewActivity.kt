package com.example.enidemo.demolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.enidemo.Person
import com.example.enidemo.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        // Get Recycler View element
        val rvPerson = findViewById<RecyclerView>(R.id.rvPersons)

        // Instancier un adapter
        val adapter = PersonsAdapter()

        rvPerson.adapter = adapter

        // Je prépare des données mock
        var listPersons = arrayListOf<Person>(Person("isaac", "test"), Person("laurent", "le vrai"))

        // Envoyer les données dans l'adapter / dans la liste
        adapter.submitList(listPersons)
    }
}