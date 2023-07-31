package com.example.enidemo.demolist

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.TextView
import com.example.enidemo.MainActivity
import com.example.enidemo.Person
import com.example.enidemo.R

class DemoAsyncActivity : AppCompatActivity() {

    lateinit var progressDialog : ProgressDialog;

    override fun onCreate(savedInstanceState: Bundle?): Boolean {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_async)

        var person = Person("Isaac", "Zian")

        // Préparer une dialog box
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Chargement")
        progressDialog.setMessage("Chargement en cours")

        // Affiche le progress bar
        progressDialog.show()

        // Instancier un handler
        var handler = Handler(Handler.Callback {

            progressDialog.setMessage(it.toString())

            true
        })

        // Creer une tâche
        var thread1 = Thread(
            Runnable {
                // Appel le web service
                Thread.sleep(500)

                // Envoyer message Etape 1
                var message = Message()
                message.obj = "Etape 1"
                handler.sendMessage(message)

                // Attendre 1 seconde
                Thread.sleep(1000)

                // Envoyer message Etape 2
                var message2 = Message()
                message2.obj = "Etape 2"
                handler.sendMessage(message2)

                Log.i("EniDemoThread", person.firstname)

                // Fermer la progress bar
                progressDialog.dismiss()
            }
        )
        // Lancer le thread
        thread1.start()
    }

}