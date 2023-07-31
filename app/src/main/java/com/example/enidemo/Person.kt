package com.example.enidemo

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Person (var firstname : String, var lastname : String) : Parcelable {

    override fun toString(): String {
        return String.format("Person : %s %s", firstname, lastname)
    }

    fun display() : String {
        return String.format("La person : %s %s", lastname, firstname)
    }
}