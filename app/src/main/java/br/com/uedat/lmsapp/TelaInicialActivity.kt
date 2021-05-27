package br.com.uedat.lmsapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.NotificationCompat
import androidx.core.view.isVisible
import com.google.android.material.navigation.NavigationView
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*
import org.w3c.dom.Text
import kotlin.concurrent.thread
import kotlin.concurrent.timer
import java.util.Timer
import kotlin.concurrent.schedule

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        var nome = params?.getString("nome")
        Toast.makeText(this, "nome do usuario: $nome", Toast.LENGTH_LONG).show()
        setSupportActionBar(toolbar)
        ConfigMenuLateral()


        supportActionBar?.title = "Musicas"
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
        butAbout.setOnClickListener {

            val intent = Intent(this, SegundaActivity::class.java)
            var name = "Ajuda"
            intent.putExtra("name","$name")
            startActivity(intent)
        }
        btnGerarNotificacao.setOnClickListener {
            val intent = Intent(this, TelaInicialActivity::class.java)
            enviaNotificacao(intent)
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
    public fun enviaNotificacao(intent: Intent){
        intent.putExtra("Tela inicial", "Notificação")
        NotificatinUtil.create(this, 1, intent, "Mob Music", "Você tem uma nova recomendação !")
    }
    public fun finishApp() {
        finish()
    }



}