package br.com.shop.commons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity(), ShopAnalytics, ShopDesignSystem, ShopNetwork {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivity()
        }
    }

    @Composable
    @Preview
    fun MainActivity() {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = primaryColor(),
                        titleContentColor = secondaryColor(),
                    ),
                    title = {
                        Text("Small Top App Bar")
                    }
                )
            },
        ) { innerPadding ->
            ScrollContent(innerPadding)
        }


    }


    @Composable
    fun ScrollContent(innerPadding: PaddingValues) {
        val range = 1..4

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(range.count()) { index ->
                Text(text = "- List item number ${index + 1}")
            }
        }
    }


    override fun trackScreen(screenName: String) {
        //
    }

    override fun trackAction(screenName: String, action: String) {
    }

    override fun primaryColor(): Color = Color(0)

    override fun secondaryColor(): Color =   Color(1)
    override fun typograpy(): Typography {
        return Typography(
            displayLarge = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 57.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 64.sp
            ),
            displayMedium = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 45.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 52.sp
            ),
            displaySmall = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 36.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 44.sp
            ),
            headlineLarge = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 32.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 40.sp
            ),
            headlineMedium = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 28.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 36.sp
            ),
            headlineSmall = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 24.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 32.sp
            ),
            titleLarge = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 22.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 28.sp
            ),
            titleMedium = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp
            ),
            titleSmall = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp
            ),
            labelLarge = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp
            ),
            labelMedium = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            ),
            labelSmall = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 11.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            ),
            bodyLarge = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            ),
            bodyMedium = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp
            ),
            bodySmall = TextStyle(
                fontFamily = fontFamily(),
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp
            ),
        )
    }

    override fun fontFamily(): FontFamily {
        return FontFamily(
            Font(R.font.montserrat_light, FontWeight.Light),
            Font(R.font.montserrat_regular, FontWeight.Normal),
            Font(R.font.montserrat_medium, FontWeight.Medium),
            Font(R.font.montserrat_semibold, FontWeight.SemiBold)
            )
    }

    override suspend fun getNetwork(url: String): Any {
        return "teste"
    }

    override suspend fun postNetwork(url: String, params: Any): Any {
        return "teste post"
    }
}
