package com.example.enidemo.demoapi

import com.squareup.moshi.Json

class Joke(@Json(name="value") var message : String) {
}