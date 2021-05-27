package br.com.uedat.lmsapp

import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    val TAG = "firebase"
    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d(TAG, "Novo token: $token")
        println("Token: $token")
    }

    override fun onMessageReceived(mensagemRemota: RemoteMessage?) {
        Log.d(TAG, "onMessageReceived")

        if(mensagemRemota?.notification != null) {
            val titulo = mensagemRemota?.notification?.title
            val corpo = mensagemRemota?.notification?.body
            Log.d(TAG, "Título da mensagem: $titulo")
            Log.d(TAG, "Corpo da mensagem: $corpo")
            val intent: Intent = Intent(this, TelaInicialActivity::class.java)
            intent.putExtra("Tela inicial", "Notificação")
            NotificatinUtil.create(this, 1, intent, "$titulo", "$corpo")

        }
    }
}