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

    }
}