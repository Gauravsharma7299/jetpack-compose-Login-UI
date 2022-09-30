package com.example.myjetpackjourney


import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackjourney.ui.theme.MyJetpackJourneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackJourneyTheme {
                Surface(color = MaterialTheme.colors.background ){



                }


            }
        }
    }

     private  fun Logged (username:String,password:String){
        if (username=="gaurav"&& password=="12345"){
            Toast.makeText(this,"logged",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Wrong Credentials",Toast.LENGTH_SHORT).show()
        }
    }
@Composable
fun LoginScreen(){
    val username= remember { mutableStateOf("")}
        val password= remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "Well come Back", fontSize = 20.sp,
        fontFamily = FontFamily(Typeface.MONOSPACE),
        color = androidx.compose.ui.graphics.Color.Gray)
        Text(text = "To Future", fontSize = 20.sp,
            fontFamily = FontFamily(Typeface.MONOSPACE),
            color = androidx.compose.ui.graphics.Color.Blue)
        Text(text = "For Developers", fontSize = 20.sp,
            fontFamily = FontFamily(Typeface.MONOSPACE),
            color = androidx.compose.ui.graphics.Color.Gray)
        
        OutlinedTextField(value = username.value,
            onValueChange = {username.value=it},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription ="person" )
                
            }, label = {
                Text(text = "USername")
            }, placeholder = {
                Text(text = "Enter username")
            },
            modifier = Modifier.fillMaxWidth()
                
                )
        OutlinedTextField(value = password.value,
            onValueChange = {password.value=it},
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription ="Lock" )

            }, label = {
                Text(text = "Password")
            }, placeholder = {
                Text(text = "Enter Password")
            },
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedButton(onClick = { Logged(username.value,password.value)  } , modifier = Modifier.fillMaxWidth().padding(top = 10.dp)) {
            Text(text = "Login")
        }


    }
}
    
    @Preview
    @Composable
    fun previewLoginScreen(){
        LoginScreen()
    }
}


