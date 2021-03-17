package br.com.uedat.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import org.w3c.dom.Text
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

//zed.setImageResource(R.drawable.zed)
        var params = intent.extras
        var nome = params?.getString("nome")
        Toast.makeText(this, "nome do usuario: $nome", Toast.LENGTH_LONG).show()
        //viewT.text = "$nome"
        supportActionBar?.title = "Musicas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        val id = item.itemId
        if (id == R.id.action_buscar){
            Toast.makeText(this, "clicou em buscar", Toast.LENGTH_LONG).show()
        }else if (id == R.id.action_atualizar){
            barra.visibility = View.VISIBLE



        }else if (id == R.id.action_config){
            Toast.makeText(this, "clicou em Sair", Toast.LENGTH_LONG).show()
            finish()


        }else if(id == android.R.id.home){
            finish()
        }



        return super.onOptionsItemSelected(item)
    }
}