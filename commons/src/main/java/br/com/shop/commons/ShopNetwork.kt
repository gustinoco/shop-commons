package br.com.shop.commons

/**
 * An Interface contract to use Get or Post network.
 */
interface ShopNetwork {

    suspend fun getNetwork(url: String) : Any
    suspend fun postNetwork(url: String, params: Any) : Any

}