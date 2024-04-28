package br.com.shop.commons


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

interface ShopDesignSystem {

    fun primaryColor(): Color
    fun secondaryColor(): Color

    fun typograpy(): androidx.compose.material3.Typography
    fun fontFamily(): FontFamily
}
