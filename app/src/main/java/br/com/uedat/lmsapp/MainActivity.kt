package br.com.uedat.lmsapp

import android.content.Intent
import android.os.Bundle
import android.util.JsonReader
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.login.*
import okhttp3.Callback
import okhttp3.OkHttpClient
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import android.widget.Toast
import com.google.android.gms.common.api.GoogleApi
import com.google.gson.JsonObject
import org.json.JSONObject


class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val obj = MyFirebaseMessagingService()
        obj.onNewToken("AAAAB899ajU:APA91bG9rUSHjWbaDUby_DrLO2CXEm9rmjYXjc3PPdm8jMC5hQVLlOrLEfkl0dzCq4WJDtFsbrGXW0zzMQw9CliIJsAtF_5x9Forstbl75DJ6JYA6GUn3tmPsp4WTBykfTLWICzjtaP7")
        val url_api = "http://192.168.1.104:8080"
        //zed.setImageResource(R.drawable.zed)
        campo_usuario.setText("aluno")
        campo_senha.setText("impacta")
        val pref = getSharedPreferences("br.com.uedate.lmsapp", Context.MODE_PRIVATE)
        botao_login.setOnClickListener {
            //Toast.makeText(this,"Clicou no botão de login", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, TelaInicialActivity::class.java)
            val nome_usuario = campo_usuario.text.toString()
            val campo_senha = campo_senha.text.toString()
            val body = JSONObject()
            body.put("username", nome_usuario)
            body.put("password", campo_senha)
            val api = APIUtility()
            api.login("login", body, this, pref)
            if(pref.getString("session", "vazio") != "vazio"){
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuário/senha incorretos!", Toast.LENGTH_SHORT).show()
                tVIEW.text = "Usuário/Senha incorretos!"

            }
        }
    }
}