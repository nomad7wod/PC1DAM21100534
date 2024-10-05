package com.example.pc1dam21100534

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {

    var arrFP = arrayOf("Messi","Ronaldhino","Neymar")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        //se obtiene el view
        val lsvFootballPlayers : ListView = findViewById<View>(R.id.lsvFP) as ListView
        //crear adaptador para llenar lista
        val adaptador: Any? = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrFP)
        //se asigna adaptador al view
        lsvFootballPlayers.adapter = adaptador as ListAdapter?
        //generar metodo de setOnItemCliclListener de la view
        lsvFootballPlayers.setOnItemClickListener { parent, view, position, id -> Toast.makeText(applicationContext, "Posicion: $position", Toast.LENGTH_SHORT).show() }
        // intent
        val message = intent.getStringExtra("param")
        val textView = findViewById<TextView>(R.id.tvResult)
        textView.text = message
        val btnBack = findViewById<View>(R.id.btnBack)

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}