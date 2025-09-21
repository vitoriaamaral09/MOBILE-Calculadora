package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CalculatorSimple()
            }
        }
    }
}

@Composable
fun CalculatorSimple() {
    var display by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Display
        Text(
            text = display,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
        )

        // Botões em linhas (Rows dentro de uma Column)
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalcBtn("1") { display = append(display, "1") }
                CalcBtn("2") { display = append(display, "2") }
                CalcBtn("3") { display = append(display, "3") }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalcBtn("4") { display = append(display, "4") }
                CalcBtn("5") { display = append(display, "5") }
                CalcBtn("6") { display = append(display, "6") }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalcBtn("7") { display = append(display, "7") }
                CalcBtn("8") { display = append(display, "8") }
                CalcBtn("9") { display = append(display, "9") }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalcBtn("0") { display = append(display, "0") }
                CalcBtn("C") { display = "0" }
            }
        }
    }
}

@Composable
fun CalcBtn(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .weight(1f)
    ) {
        Text(text = text, fontSize = 24.sp)
    }
}

// Função auxiliar para acrescentar números
fun append(current: String, digit: String): String {
    return if (current == "0") digit else current + digit
}
