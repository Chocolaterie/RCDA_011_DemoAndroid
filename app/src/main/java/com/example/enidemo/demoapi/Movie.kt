package com.example.enidemo.demoapi

import com.squareup.moshi.Json

class Movie(@Json(name = "id") var id: Int,@Json(name = "title") var title: String,
            @Json(name = "description") var description: String) {

    override fun toString(): String {
        return String.format("%d : %s", id, title)
    }
}