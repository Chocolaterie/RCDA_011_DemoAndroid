package com.example.enidemo.demoapi

import com.squareup.moshi.Json

class Article(@Json(name="id") var id : Int,
              @Json(name="title") var title: String,
              @Json(name="content") var content : String) {
}