// Student ID: 300868207
package com.khyam.adhikari

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.khyam.adhikari.ui.theme.MyContactsTheme
import androidx.compose.ui.tooling.preview.Preview

// Student ID: 300868207

class KhyamActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyContactsTheme {
                MainScreen(this)
            }
        }
    }
}

@Composable
fun MainScreen(activity: KhyamActivity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Displaying the logo from the drawable folder
        Image(
            painter = painterResource(id = R.drawable.logo), // Ensure that your logo file is named logo.png and placed in the drawable folder
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Button to navigate to the contact adding screen
        Button(
            onClick = {
                val intent = Intent(activity, AdhikariActivity::class.java)
                activity.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF6200EE))
        ) {
            Text(text = "Go to Add Contacts")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyContactsTheme {
        MainScreen(KhyamActivity())
    }
}
