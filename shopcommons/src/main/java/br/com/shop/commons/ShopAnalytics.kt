package br.com.shop.commons

/**
 * An Interface contract to use Analytics Screen and Action.
 */
interface ShopAnalytics {

    fun trackScreen(screenName: String)
    fun trackAction(screenName: String, action: String)

}