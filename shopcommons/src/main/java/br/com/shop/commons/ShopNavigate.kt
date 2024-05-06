package br.com.shop.commons

import android.content.Context
import java.io.Serializable

interface ShopNavigate {
    fun navigate(context: Context, route: String, params: HashMap<String, Serializable> = hashMapOf())
}

