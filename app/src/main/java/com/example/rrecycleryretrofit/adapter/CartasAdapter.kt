package com.example.rrecycleryretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rrecycleryretrofit.R

class CartasAdapter(private val cartaList:List<Carta>, private val onClickListener:(Carta)->Unit):
    RecyclerView.Adapter<CartasViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartasViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return CartasViewHolder(layoutInflater.inflate(R.layout.item_cartas, parent, false))
    }

    override fun getItemCount(): Int = cartaList.size

    override fun onBindViewHolder(holder: CartasViewHolder, position: Int) {
        val item=cartaList[position]
        holder.render(item, onClickListener)
    }
}