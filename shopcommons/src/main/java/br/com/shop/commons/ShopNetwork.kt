package br.com.shop.commons

/**
 * An Interface contract to use Get or Post network.
 */
interface ShopNetwork {

    suspend fun getNetwork(url: String, responseClass: Any) : Any
    suspend fun postNetwork(url: String, params: Any, responseClass: Any) : Any

}