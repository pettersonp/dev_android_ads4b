package br.com.uedat.lmsapp

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

object ReturnAPI {
    var status: Boolean = false
    var error: String = ""
    var status_code: Int = 400
    var data: JSONArray = JSONArray("""[{}]""")
}


class APIUtility() {
    var url_api = "http://192.168.1.104:8080"
    public fun login(url: String, body: JSONObject, context: Context, pref: SharedPreferences){
        val queue = Volley.newRequestQueue(context)
        var response_return : String = """{"status": false}"""
        val jsonArrayRequest = object : JsonObjectRequest(
            Request.Method.POST,
            "$url_api/$url",
            body,
            Response.Listener { response ->

                pref.edit().putString("session", response["token"].toString()).commit()

            },
            Response.ErrorListener { erro_message ->
                Toast.makeText(context,"Erro ao realizar login: $erro_message", Toast.LENGTH_LONG).show()
                pref.edit().putString("session", "vazio").commit()
            }
        ){
            override fun getBody(): ByteArray {
                return super.getBody()
            }

        }
        queue.add(jsonArrayRequest)
        return
    }

    public fun get(
        url: String,
        context: Context,
        params: HashMap<String, String> = HashMap(),
        header: HashMap<String, String> = HashMap(),
        callback: ReturnAPI
    ){
        val queue = Volley.newRequestQueue(context)
        val jsonArrayRequest = object : JsonObjectRequest(
            Request.Method.GET,
            "$url_api/$url",
            null,
            Response.Listener { response ->
                if(response.getBoolean("status")){
                    callback.status = response.getBoolean("status")
                    callback.data = response.getJSONArray("data")
                }else{
                    callback.status = response.getBoolean("status")
                    callback.status_code = response.getInt("status_code")
                    callback.error = response.getString("error")
                }

            },
            Response.ErrorListener {
                // Do something when error occurred
                error_message ->

                Toast.makeText(context,"Erro: $error_message", Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return header
            }

            override fun getParams(): MutableMap<String, String> {
                return params
            }
        }
        queue.add(jsonArrayRequest)
        return
    }

    public fun post(url: String,
                    context: Context,
                    body: JSONObject,
                    header: HashMap<String, String> = HashMap(),
                    callback: ReturnAPI
    ){
        val queue = Volley.newRequestQueue(context)
        val jsonArrayRequest = object : JsonObjectRequest(
            Request.Method.POST,
            "$url_api/$url",
            body,
            Response.Listener { response ->
                if(response.getBoolean("status")){
                    callback.status = response.getBoolean("status")
                    callback.data = response.getJSONArray("data")
                }else{
                    callback.status = response.getBoolean("status")
                    callback.status_code = response.getInt("status_code")
                    callback.error = response.getString("error")
                }

            },
            Response.ErrorListener {
                // Do something when error occurred
                    error_message ->
                Toast.makeText(context,"Erro: $error_message", Toast.LENGTH_LONG).show()
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                return header
            }

            override fun getParams(): MutableMap<String, String> {
                return params
            }
        }
        queue.add(jsonArrayRequest)
        return
    }
}