package com.example.myrestapp_tommasopignatta

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest
import java.util.Base64

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userName = findViewById<EditText>(R.id.txtUserLoginActivity)
        val userPass = findViewById<EditText>(R.id.textPswLoginActivity)
        val btnAcc = findViewById<Button>(R.id.btnLoginActivity)

        btnAcc.setOnClickListener {
            val risultato = valida(userName.text.toString(), userPass.text.toString())

            if (risultato != "CREDENZIALI ERRATE") {
                Toast.makeText(this, "ACCESSO ESEGUITO!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, risultato, Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun valida(nome: String, password: String): String {
        if (nome.isNotBlank() && password.length > 5) {
            if (nome == "TommyPigna" && password == "16112006") {
                val digest = MessageDigest.getInstance("SHA-256")
                val hashBytes = digest.digest(password.toByteArray(Charsets.UTF_8))
                return Base64.getEncoder().encodeToString(hashBytes)
            }
        }
        return "CREDENZIALI ERRATE!"
    }
}
