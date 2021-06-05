package br.com.uedat.lmsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.auth0.android.jwt.JWT
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.Timer
import kotlin.concurrent.schedule

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        var pref = getSharedPreferences("br.com.uedate.lmsapp", Context.MODE_PRIVATE)
        var session = pref.getString("session", "vazio").toString()
        var token = JWT(session)
        var nome = token.getClaim("username").asString()
        Toast.makeText(this, "Bem vindo $nome !", Toast.LENGTH_LONG).show()
        setSupportActionBar(toolbar)
        ConfigMenuLateral()


        supportActionBar?.title = "MobMusic"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)






        butMusics.setOnClickListener {

            val intent = Intent(this, SegundaActivity::class.java)
            var name = "Playlists"
            intent.putExtra("name","$name")
            startActivity(intent)
        }




        butArtists.setOnClickListener {

            val intent = Intent(this, SegundaActivity::class.java)
            var name = "Artistas"
            intent.putExtra("name","$name")
            startActivity(intent)
        }






    }
    private fun ConfigMenuLateral(){
        var toogle = ActionBarDrawerToggle(this, layout_menu_lateral,toolbar, R.string.nav_open, R.string.nav_close )
        layout_menu_lateral.addDrawerListener(toogle)
        toogle.syncState()
        naveg_menu_lateral.setNavigationItemSelectedListener(this)


    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true

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
            Timer("SettingUp", false).schedule(10000) {
                barra.visibility = View.INVISIBLE
            }




        }else if (id == R.id.action_sair){
            Toast.makeText(this, "clicou em Sair", Toast.LENGTH_LONG).show()
            finishApp()


        } else if (id == R.id.localizacao_naveg) {
            finishApp()
        }else if(id == android.R.id.home){
            val intent = Intent(this, TelaInicialActivity::class.java)
            var name = "Home"
            intent.putExtra("name","$name")
            startActivity(intent)
        }



        return super.onOptionsItemSelected(item)
    }
    public fun finishApp() {
        finish()
    }



}