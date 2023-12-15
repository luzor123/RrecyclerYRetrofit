package com.example.rrecycleryretrofit

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rrecycleryretrofit.adapter.Carta
import com.example.rrecycleryretrofit.adapter.CartasAdapter
import com.example.rrecycleryretrofit.databinding.ActivityMainBinding
import com.example.rrecycleryretrofit.utiil.APIservice
import com.example.rrecycleryretrofit.utiil.HeaderInterceptor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CartasAdapter
    private val cartaslist = mutableListOf<Carta>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svCartas.setOnQueryTextListener(this)
        initReciclerView()
    }

    private fun initReciclerView() {
        // val manager= LinearLayoutManager(this)
        //val manager= GridLayoutManager(this, 2)
        //val decoration=DividerItemDecoration(this,manager.orientation)
        //val recyclerView=findViewById<RecyclerView>(R.id.reclicador)
        //recyclerView.layoutManager=LinearLayoutManager(this)
        //recyclerView.adapter=SuperHeroAdapter(SuperHeroProvider.superheroList)
        //adapter = CartasAdapter(cartaslist){ cartas}
        binding.rvCartas.layoutManager = LinearLayoutManager(this)
        binding.rvCartas.adapter =CartasAdapter(cartaslist) {carta ->onItemSelected(carta)}
        //binding.reclicador.layoutManager=manager//LinearLayoutManager(this)
        /* binding.reclicador.adapter=SuperHeroAdapter(SuperHeroProvider.superheroList) { superhero ->
             onItemSelected(
                 superhero
             )
         }*/
        //binding.reclicador.addItemDecoration(decoration)

    }

    fun onItemSelected(carta: Carta){
        val intent = Intent(this, detalleActivity::class.java)
        intent.putExtra("Nombre", carta.name)
        intent.putExtra("id", carta.cardId)
        intent.putExtra("tipo", carta.type)
        intent.putExtra("clase", carta.playerClass)
        intent.putExtra("texto", carta.playerClass)
        // Agrega otros datos que desees pasar a la nueva actividad

        startActivity(intent)
    }
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/cards")
            .client(getClient()).build()
    }

    fun getClient(): OkHttpClient {
        val client = OkHttpClient.Builder().addInterceptor(HeaderInterceptor()).build()
        return client
    }

    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofit().create(APIservice::class.java).getCardsByName("$query/name")
            val cards = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val cartasm = cards?.name ?: emptyList<Carta>()
                    cartaslist.clear()
                    //cartaslist.addAll(cartasm)
                    adapter.notifyDataSetChanged()

                    //show recyclerview
                } else {
                    showError()
                }
            }

        }

        }
    private fun showError(){
        Toast.makeText(this, "ha occurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){

                searchByName(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return  true
    }
}

