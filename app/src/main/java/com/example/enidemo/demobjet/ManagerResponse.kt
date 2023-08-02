package com.example.enidemo.demobjet

class ManagerResponse<T>(var code : String = "000", var message: String = "TODO", var data :T? = null) {

    override fun toString(): String {
        return String.format(String.format("Company : Code : %s - Message : %s"), code, message)
    }
}