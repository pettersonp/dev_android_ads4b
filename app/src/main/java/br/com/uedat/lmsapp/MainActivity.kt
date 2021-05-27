package br.com.uedat.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*



class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val obj = MyFirebaseMessagingService()
        obj.onNewToken(" AAAAB899ajU:APA91bG9rUSHjWbaDUby_DrLO2CXEm9rmjYXjc3PPdm8jMC5hQVLlOrLEfkl0dzCq4WJDtFsbrGXW0zzMQw9CliIJsAtF_5x9Forstbl75DJ6JYA6GUn3tmPsp4WTBykfTLWICzjtaP7")


        //zed.setImageResource(R.drawable.zed)

        botao_login.setOnClickListener {
            //Toast.makeText(this,"Clicou no botão de login", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, TelaInicialActivity::class.java)
            val params = Bundle()
            val nome_usuario = campo_usuario.text.toString()
            val campo_senha = campo_senha.text.toString()
            var usu = "aluno"
            var sen = "impacta"

            intent.putExtra("nome","$nome_usuario")
            if (nome_usuario == usu && campo_senha == sen) {

                startActivity(intent)

            }else{
                Toast.makeText(this,"Usuario errado.", Toast.LENGTH_SHORT).show()
                tVIEW.text = "usuario errado $nome_usuario"
            }

        }




    }

}