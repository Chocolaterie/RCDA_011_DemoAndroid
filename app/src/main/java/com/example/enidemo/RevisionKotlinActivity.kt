package com.example.enidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize

open class Entity{

}

interface IRepo {

    fun test()
}

class PersonTest (var firstname : String,  var lastname : String, var age : Int = 0) : Entity(), IRepo {
    // Que faire lorsque le constructeur est appelé
    init {

    }

    // overloading plus function
    operator fun plus(other: PersonTest) : PersonTest {
        return PersonTest(firstname + other.firstname, lastname)
    }

    // overloading minus function
    operator fun minus(other: PersonTest) : PersonTest {
        return PersonTest("Chocolatine", lastname)
    }

    // toute les fonctions statics
    companion object {
        fun getTVA() : Double{
            return 19.6
        }

        fun getToto() : String {
            return "Toto"
        }
    }

    override fun test() {
        TODO("Not yet implemented")
    }
}

class RevisionKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_revision_kotlin)

        test();
    }

    fun test(){
        // var = ecriture/lecture
        var age = 12
        age = 15

        // val = constante
        val age2 = 16
        // age2 = 52 // impossible car lecture seule

        var age4 : Int
        var note : Double
        var lastname : String

        var notes = ArrayList<Double>()

        notes.average()

        var noteA = 12
        var noteB = 20

        noteA++

        noteA + noteB

        // Test static
        Log.i("Kotlin revision", String.format("La TVA : %f", PersonTest.getTVA()))

        // Test surcharge d'operateur
        var isaac = PersonTest("isaac", "test");
        var morgan = PersonTest("morgan", "test");

        var resultat = isaac + morgan;
        Log.i("Kotlin revision", "Resultat de l'addition: " + resultat.firstname)

        var resultat2 = isaac - morgan;
        Log.i("Kotlin revision", "Resultat de la soustraction: " + resultat2.firstname)

        // Liste de deux persons
        var persons = arrayListOf<PersonTest>(isaac, morgan)

        var personEnBase = PersonTest("isaac", "test") // nouvelle adresse mémoire

        persons.contains(personEnBase)
        val index = persons.indexOf(personEnBase)
    }
}