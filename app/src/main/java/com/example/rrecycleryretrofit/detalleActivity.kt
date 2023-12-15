package com.example.rrecycleryretrofit

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class detalleActivity : ComponentActivity( ){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cartadetallada)
        title="datos de la carta seleccionada"
        val nombrecarta = intent.getStringExtra("Nombre")
        val idcarta = intent.getStringExtra("id")
        val tipocarta = intent.getStringExtra("tipo")
        val clasecarta = intent.getStringExtra("clase")
        val textcarta= intent.getStringExtra("texto")
        val TVCartaNombre: TextView = findViewById(R.id.idnombred)
        TVCartaNombre.text= nombrecarta
        val TVCartaid: TextView=findViewById(R.id.ididd)
        TVCartaid.text=idcarta
        val TVCartatipo: TextView=findViewById(R.id.idtipod)
        TVCartatipo.text=tipocarta
        val TVCartaClase: TextView=findViewById(R.id.idclased)
        TVCartaClase.text=clasecarta
        val TVCartaTexto: TextView=findViewById(R.id.idtextdo)
        TVCartaTexto.text=textcarta
    }

}