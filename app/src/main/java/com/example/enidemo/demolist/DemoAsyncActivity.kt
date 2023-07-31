package com.example.enidemo.demolist

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ProgressBar
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
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)

        // Affiche le progress bar
        progressDialog.show()

        // Notre handler
        var handler = RegisterHandler(progressDialog)

        // Creer une tâche
        var thread1 = Thread(
            Runnable {
                // Appel le web service
                handler.onStepProgress(0.0, "Initialisation...")

                // Attendre 1 seconde
                Thread.sleep(1000)
                handler.onStepProgress(0.2,"Envoi des données en cours ...")

                // Attendre 1 seconde
                Thread.sleep(1500)
                handler.onStepProgress(0.8,"Insertion en base ...")

                // Attendre 1 seconde
                Thread.sleep(500)
                handler.onStepProgress(0.9,"Validation en cours ...")

                Log.i("EniDemoThread", person.firstname)

                Thread.sleep(500)
                handler.onStepProgress(1.0,"Complete")
            }
        )
        // Lancer le thread
        thread1.start()
    }

    class RegisterHandler(var progressDialog: ProgressDialog) {
        fun onStepProgress(weight: Double, message: String){
            progressDialog.setMessage(message)
            progressDialog.progress = (weight * 100.0).toInt()

            if (weight >= 1.0) {
                // Fermer la progress bar
                progressDialog.dismiss()
            }
        }
    }
}