package br.com.shop.commons

import io.mockk.coEvery
import io.mockk.mockk
import org.junit.jupiter.api.Test

class ShopNetworkTest {

    private val shopNetwork = mockk<ShopNetwork>(relaxed = true)

    @Test
    suspend fun `when test get Param and return ANy class`() {
        coEvery {
            shopNetwork.getNetwork("test", Any())
        } returns Any()

        shopNetwork.getNetwork("test", Any())
    }

    @Test
    suspend fun `when testTrackAction`() {
        coEvery {
            shopNetwork.getNetwork("test", Any())
        } returns Any()

        shopNetwork.getNetwork("test", Any())
    }
}