package br.com.uedat.lmsapp

import com.google.gson.JsonParser
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody



object HttpHelper {
    val JSON = MediaType.parse("application/json; charset=utf-8")

    var client = OkHttpClient()


    fun get(url: String): String{
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    fun post(url: String, json: String, token: String): String{
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).header("authorization", "bearer $token").build()
        return getJson(request)
    }

    fun login(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }


    fun delete(url: String, json: String): String{
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }


     private fun getJson(request: Request): String{
        val response = client.newCall(request).execute()
         println(response)
        val body = response.body()
         println("\n\n\n\n$response\n\n\n${body.toString()}")
        if (body != null) {
            val json = body.string()
            return json
        }
        return ""
    }
}
