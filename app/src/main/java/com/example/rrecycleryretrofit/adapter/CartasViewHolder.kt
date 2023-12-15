package com.example.rrecycleryretrofit.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rrecycleryretrofit.databinding.ItemCartasBinding

class CartasViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val binding= ItemCartasBinding.bind(view)
    //  val superHero=view.findViewById<TextView>(R.id.idsupernombre1)
    //  val realName=view.findViewById<TextView>(R.id.idRealName1)
    //  val publiser=view.findViewById<TextView>(R.id.idpublisher1)
    //  val foto=view.findViewById<ImageView>(R.id.idsuper1)
    fun render(cartaModel: Carta, onClickListener:(Carta)->Unit){
        // superHero.text=superHeroModel.superHero
        // realName.text=superHeroModel.realName
        //  publiser.text=superHeroModel.publisher
        //  Glide.with(foto.context).load(superHeroModel.photo).into(foto)
        binding.idnombre1.text=cartaModel.name
        binding.idnombre2.text=cartaModel.type
        binding.idnombre2.text=cartaModel.text
        binding.idnombre1.setOnClickListener{ Toast.makeText(binding.idnombre1.context, cartaModel.playerClass , Toast.LENGTH_SHORT).show()}
        itemView.setOnClickListener{onClickListener(cartaModel)
            //Toast.makeText(binding.idsuper1.context, superHeroModel.realName, Toast.LENGTH_SHORT).show()
        }
    }
}