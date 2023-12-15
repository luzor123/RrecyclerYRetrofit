package com.example.rrecycleryretrofit.adapter

import com.google.gson.annotations.SerializedName

data class Carta (@SerializedName("cardId") var cardId: String,
                  @SerializedName("dbfId") val dbfId: Int,
                  @SerializedName("name") val name: String,
                  @SerializedName("cardSet") var cardSet: String,
                  @SerializedName("type") var type: String,
                  @SerializedName("text") var text: String,
                  @SerializedName("playerClass") var playerClass: String,
                  @SerializedName("locale") var locale: String)