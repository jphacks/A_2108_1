package com.dawn.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dawn.android.R
import com.dawn.android.ui.theme.DawnTheme
import com.dawn.android.ui.theme.Gray900
import com.dawn.android.ui.theme.MainColor
import com.dawn.android.ui.theme.Typography
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchedEffect(Unit) {
                delay(1000)
                val intent = MainActivity.createIntent(this@SplashActivity)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
            DawnTheme {
                Surface(
                    color = MainColor,
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(96.dp)
                                    .shadow(
                                        elevation = 3.dp,
                                        shape = RoundedCornerShape(21.dp),
                                    )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "DAWN",
                                style = Typography.h1,
                                color = Gray900,
                            )
                        }
                    }
                }
            }
        }
    }
}
