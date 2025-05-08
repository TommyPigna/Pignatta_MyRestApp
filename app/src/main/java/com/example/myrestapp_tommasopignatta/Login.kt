package com.example.myrestapp_tommasopignatta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest
import java.util.Base64

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        var userName = findViewById<EditText>(R.id.txtUserLoginActivity)
        var userPass = findViewById<EditText>(R.id.textPswLoginActivity)
        var btnAcc = findViewById<Button>(R.id.btnLoginActivity)
        btnAcc.setOnClickListener{
        valida(userName.text.toString(), userPass.text.toString())
        }
    }

        fun valida(nome: String, password: String): String {
            if (nome != "" && password != "" && password.length > 5) {
                if (nome == "TommyPigna" && password == "Tommy.161106") {
                    val digest = MessageDigest.getInstance("SHA-256")
                    val hashBytes = digest.digest(password.toByteArray(Charsets.UTF_8))
                    return Base64.getEncoder().encodeToString(hashBytes)
                }
            }
            return "Credenziali non valide"
}
    }