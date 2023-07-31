package com.example.enidemo.demolist

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.enidemo.MainActivity
import com.example.enidemo.Person
import com.example.enidemo.R

class DemoAsyncActivity : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_async)

        var person = Person("Isaac", "Zian")

        // Préparer une dialog box
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Chargement")
        progressDialog.setMessage("Chargement en cours")

        // Affiche le progress bar
        progressDialog.show()

        // Creer une tâche
        var thread1 = Thread(
            Runnable {
                // Appel le web service
                // Attendre 1 seconde
                Thread.sleep(3000)

                Log.i("EniDemoThread", person.firstname)

                // Fermer la progress bar
                progressDialog.dismiss()
            }
        )
        // Lancer le thread
        thread1.start()
    }

}