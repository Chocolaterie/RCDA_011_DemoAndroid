package com.example.enidemo

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Person (var firstname : String, var lastname : String) : Parcelable {

}