package br.com.uedat.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import org.w3c.dom.Text

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
//zed.setImageResource(R.drawable.zed)
        var params = intent.extras
        var nome = params?.getString("nome")
        Toast.makeText(this, "nome do usuario: $nome", Toast.LENGTH_LONG).show()
        //viewT.text = "$nome"
        // teste git

        var num = 1


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        val id = item.itemId
        if (id == R.id.action_buscar){
            Toast.makeText(this, "clicou no buscar", Toast.LENGTH_LONG).show()
        }else if (id == R.id.action_atualizar){
            Toast.makeText(this, "clicou no atualizar", Toast.LENGTH_LONG).show()

        }else if (id == R.id.action_config){
            Toast.makeText(this, "clicou no config", Toast.LENGTH_LONG).show()

        }
        return super.onOptionsItemSelected(item)
    }
}