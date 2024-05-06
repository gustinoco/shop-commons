package br.com.shop.commons

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class ShopAnalyticsTest {

    private val shopAnalytics = mockk<ShopAnalytics>(relaxed = true)

    @Test
    fun `when testTrackScreen`() {
        shopAnalytics.trackScreen("test")

        verify(exactly = 1) {
            shopAnalytics.trackScreen("test")
        }
    }

    @Test
    fun `when testTrackAction`() {
        shopAnalytics.trackAction("test", "button")

        verify(exactly = 1) {
            shopAnalytics.trackAction("test", "button")
        }
    }
}