package com.example.pc1dam21100534

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configura el layout de la actividad
        setContentView(R.layout.activity_main)

        // Habilitar ajuste para barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        title = "Sign In"

        // Credenciales correctas
        val emailSuccess: String = "admin@peru.com"
        val passwordSuccess: String = "12345678"

        // Elementos de la interfaz de usuario
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btLogin: Button = findViewById(R.id.btnLogin)

        // Acción cuando se hace clic en el botón de login
        btLogin.setOnClickListener {
            val email: String = etEmail.text.trim().toString()
            val password: String = etPassword.text.trim().toString()

            // Verificar credenciales
            if (email == emailSuccess && password == passwordSuccess) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val rootView: View = findViewById(android.R.id.content)
                Snackbar.make(rootView, "Credenciales inválidas", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
