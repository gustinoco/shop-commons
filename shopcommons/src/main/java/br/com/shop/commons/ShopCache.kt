package br.com.shop.commons

/**
 * An Interface contract to use Analytics Screen and Action.
 */
interface ShopCache {

    fun putCache(key: String, data: Any)
    fun getCache(key: String, cacheClass: Any): Any?
    fun deleteCache(key: String)

}