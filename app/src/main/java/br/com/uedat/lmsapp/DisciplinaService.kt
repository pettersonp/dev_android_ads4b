package br.com.uedat.lmsapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object DisciplinaService {
    fun getDisciplinas(): List<Disciplina>{

        val host = "http://fesousa.pythonanywhere.com"
        val TAG = "WS_LMSApp"


        val url = "$host/disciplinas"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        var disciplinas = parserJson<List<Disciplina>>(json)


        return disciplinas
    }

    fun saveDisciplina(disciplina: Disciplina): String{
        val host = "http://fesousa.pythonanywhere.com"
        val json = HttpHelper.post("$host/disciplinas", disciplina.toJson())
        return json
    }



    inline fun <reified T > parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)

    }


}