package br.com.uedat.lmsapp

import com.google.gson.GsonBuilder

class Disciplina {
    var id: Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var professor = ""


    fun toJson(): String{
        return GsonBuilder().create().toJson(this)
    }
}