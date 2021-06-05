package br.com.uedat.lmsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_segunda.*
import org.json.JSONArray
import org.json.JSONObject

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        var pref = getSharedPreferences("br.com.uedate.lmsapp", Context.MODE_PRIVATE)
        var token = pref.getString("session", "vazio").toString()
        var params = intent.extras
        var nome = params?.getString("name")
        getSupportActionBar()?.setTitle("$nome")
        var api = APIUtility()

        if(nome == "Artistas"){
            var map_header = HashMap<String, String>()
            map_header["authorization"] = "bearer $token"
            var callback = ReturnAPI
            var api_return = api.get(
                url = "artists/",
                header = map_header,
                context = this,
                callback = callback
            )

            Toast.makeText(this, "${callback.data}", Toast.LENGTH_SHORT).show()
        }
    }


}