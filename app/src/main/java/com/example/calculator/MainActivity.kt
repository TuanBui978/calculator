package com.example.calculator

import android.os.Bundle
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.BlueCorner
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.MainAppColor
import com.example.calculator.ui.theme.NumButtonColor
import com.example.calculator.ui.theme.TextBlueColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mainActivityViewModel = MainActivityViewModel()
                    CalculatorScreen(mainActivityViewModel =  mainActivityViewModel)
                }
            }
        }
    }
}



@Composable
fun ResultScreen(modifier: Modifier = Modifier, result: String = "1+1=2", value: String = "2") {
    Column(modifier = Modifier
        .wrapContentHeight()
        .clip(RoundedCornerShape(5.dp))
        .border(3.dp, Color.Gray, RoundedCornerShape(5.dp))
        .padding(10.dp)
         ) {
        Row (horizontalArrangement = Arrangement.Absolute.SpaceBetween, modifier = Modifier.fillMaxWidth()){
            Text(text = "M1: 0", color = Color.Gray)
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_content_copy_24), contentDescription = "Copy Icon", tint = Color.Gray )
        }
        Text(text = value, fontSize = 50.sp, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
        Divider()
        Text(text = result, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth(), color = Color.Gray )
    }
}

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier, mainActivityViewModel: MainActivityViewModel) {
    val uiState = mainActivityViewModel.uiState.collectAsState()
    Column (modifier = Modifier
        .fillMaxWidth()
        .border(3.dp, BlueCorner)
        .background(MainAppColor)
        .padding(20.dp)){
        Text(text = "Calculator-1.com", color = TextBlueColor, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
        ResultScreen(value = uiState.value.valueInScreen, result = uiState.value.currentCalculator)
        Row {
            TextButton(onClick = { /*TODO*/ }, contentPadding = PaddingValues(0.dp), modifier = Modifier.wrapContentSize()) {
                Text(text = "MC", color = Color.LightGray, modifier = Modifier.padding(0.dp))
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "MR", color = Color.LightGray)
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "M-", color = Color.LightGray)
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "M+", color = Color.LightGray)
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                TextButton(onClick = { mainActivityViewModel.onNumButtonClick("7")}, colors = ButtonDefaults.buttonColors(
                    NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                    Text(text = "7", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                }
                TextButton(onClick = { mainActivityViewModel.onNumButtonClick("8") }, colors = ButtonDefaults.buttonColors(
                    NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                    Text(text = "8", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                }
                TextButton(onClick = { mainActivityViewModel.onNumButtonClick("9") }, colors = ButtonDefaults.buttonColors(
                    NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                    Text(text = "9", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                }
                Button(onClick = { mainActivityViewModel.onSighButtonClick() }, shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp), contentPadding = PaddingValues(10.dp), colors = ButtonDefaults.buttonColors(
                    Color.Gray) ) {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.plus_minus_bold_svgrepo_com), contentDescription = null , modifier = Modifier.size(30.dp))
                }
                Button(onClick = { mainActivityViewModel.onBackButtonClick()}, shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp), contentPadding = PaddingValues(10.dp), colors = ButtonDefaults.buttonColors(
                    Color.Gray) ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null , modifier = Modifier.size(45.dp) )
                }
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                TextButton(onClick = { mainActivityViewModel.onNumButtonClick("4") }, colors = ButtonDefaults.buttonColors(
                    NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                    Text(text = "4", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                }
                TextButton(onClick = { mainActivityViewModel.onNumButtonClick("5") }, colors = ButtonDefaults.buttonColors(
                    NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                    Text(text = "5", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                }
                TextButton(onClick = { mainActivityViewModel.onNumButtonClick("6") }, colors = ButtonDefaults.buttonColors(
                    NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                    Text(text = "6", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                }
                Button(onClick = { mainActivityViewModel.onOperatorClick("*") }, shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp), contentPadding = PaddingValues(10.dp), colors = ButtonDefaults.buttonColors(
                    Color.DarkGray) ) {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.multiply_svgrepo_com), contentDescription = null , modifier = Modifier.size(45.dp))
                }
                Button(onClick = { mainActivityViewModel.onOperatorClick("/") }, shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp), contentPadding = PaddingValues(10.dp), colors = ButtonDefaults.buttonColors(
                    Color.DarkGray) ) {
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.divide_straight_svgrepo_com), contentDescription = null , modifier = Modifier.size(45.dp) )
                }
            }
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Row {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        TextButton(onClick = { mainActivityViewModel.onNumButtonClick("1") }, colors = ButtonDefaults.buttonColors(
                            NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                            Text(text = "1", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                        }
                        TextButton(onClick = { mainActivityViewModel.onCButtonClick() }, colors = ButtonDefaults.buttonColors(
                            Color.Red
                        ), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                            Text(text = "C", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                        }
                    }
                }

                Row {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        TextButton(onClick = { mainActivityViewModel.onNumButtonClick("2") }, colors = ButtonDefaults.buttonColors(
                            NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                            Text(text = "2", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                        }
                        TextButton(onClick = { mainActivityViewModel.onNumButtonClick("0") }, colors = ButtonDefaults.buttonColors(
                            NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                            Text(text = "0", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                        }
                    }
                }

                Row {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        TextButton(onClick = { mainActivityViewModel.onNumButtonClick("3") }, colors = ButtonDefaults.buttonColors(
                            NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                            Text(text = "3", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                        }
                        TextButton(onClick = { mainActivityViewModel.onPointClick() }, colors = ButtonDefaults.buttonColors(
                            NumButtonColor), shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp)) {
                            Text(text = ".", fontSize = 30.sp, modifier = Modifier.align(Alignment.CenterVertically), color = BlueCorner)
                        }
                    }
                }

                Row {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(onClick = { mainActivityViewModel.onOperatorClick("-") }, shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp), contentPadding = PaddingValues(10.dp), colors = ButtonDefaults.buttonColors(
                            Color.DarkGray) ) {
                            Icon(imageVector = ImageVector.vectorResource(R.drawable.minus_svgrepo_com), contentDescription = null , modifier = Modifier.size(25.dp))
                        }
                        Button(onClick = { mainActivityViewModel.onOperatorClick("+") }, shape = RoundedCornerShape(5.dp), modifier = Modifier.size(60.dp), contentPadding = PaddingValues(10.dp), colors = ButtonDefaults.buttonColors(
                            Color.DarkGray) ) {
                            Icon(imageVector = ImageVector.vectorResource(R.drawable.add_plus_svgrepo_com), contentDescription = null , modifier = Modifier.size(45.dp) )
                        }
                    }
                }

                Column {
                    Button(onClick = {
                        mainActivityViewModel.onEquClick()
                    }, shape = RoundedCornerShape(5.dp), modifier = Modifier
                        .width(60.dp)
                        .height(130.dp), contentPadding = PaddingValues(10.dp), colors = ButtonDefaults.buttonColors(
                        Color.Blue) ) {
                        Icon(imageVector = ImageVector.vectorResource(R.drawable.equal_svgrepo_com), contentDescription = null , modifier = Modifier.size(45.dp))
                    }
                }

            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), Arrangement.End){
            Text("PC", fontWeight = FontWeight.Bold)
            Text("/Mobile")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        CalculatorScreen(mainActivityViewModel = MainActivityViewModel())
    }
}


