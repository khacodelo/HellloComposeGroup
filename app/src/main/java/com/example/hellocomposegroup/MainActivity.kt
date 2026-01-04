package com.example.hellocomposegroup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                GroupIntroScreen()
            }
        }
    }
}

@Composable
fun GroupIntroScreen() {
    val context = LocalContext.current

    val members = listOf(
       "Nguyễn Hữu Kha - Project Setup",
        "Huỳnh Duy Hưng - abc"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo hình tròn ở giữa
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Group Logo",
            modifier = Modifier
                .size(340.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "HELLO COMPOSE GROUP",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Danh sách 5 thành viên
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            members.forEachIndexed { index, name ->
                val isMyName = (index == 0)

                Text(
                    text = "• $name",
                    modifier = Modifier.padding(vertical = 4.dp),
                    color = if (isMyName) Color.Red else Color.Blue,
                    fontSize = if (isMyName) 20.sp else 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Hello from Compose!", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Say Hello")
        }
    }
}
